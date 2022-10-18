package data_structures;

import java.util.PriorityQueue;
import java.util.*;

public class WeightedGraph {

  Map<String, Node> nodeMap = new LinkedHashMap<>();

  public void addNode(String name) {
    nodeMap.putIfAbsent(name, new Node(name));
  }

  public void addEdge(String from, String to, int weight) {

    var fromNode = nodeMap.get(from);
    var toNode = nodeMap.get(to);

    if (fromNode != null && toNode != null) {
      fromNode.edges.add(new Edge(fromNode, toNode, weight));
      toNode.edges.add(new Edge(toNode, fromNode, weight));
    }
  }

  void print() {
    for (var node : nodeMap.values()) {
      for (var edge : node.edges) {
        System.out.println(edge);
      }
    }
  }

  void getShortestPath(String to) {

    var table = shortestPath();
    var stack = new Stack<String>();

    var current = table.get(to);
    stack.push(current.node.name);
    while (current.path != null) {
      stack.push(current.path.name);
      current = table.get(current.path.name);
    }

    StringBuilder builder = new StringBuilder();
    while (!stack.isEmpty()) {
      builder.append(stack.pop());
      if (!stack.isEmpty()) builder.append(" -> ");
    }
    System.out.println(builder);
  }

  Map<String, TableEntry> shortestPath() {

    // table

    Map<String, TableEntry> table = new LinkedHashMap<>();

    for (var n : nodeMap.entrySet()) {
      var tableEntry = new TableEntry(n.getValue(), Integer.MAX_VALUE, null);
      table.putIfAbsent(n.getKey(), tableEntry);
    }

    var current = nodeMap.get("A");
    // select next node with min distance
    var queue = new PriorityQueue<>(Comparator.comparingInt(Neighbour::getDistance));
    var visited = new LinkedHashSet<String>();

    queue.add(new Neighbour(current, 0));

    table.computeIfPresent(
        current.name,
        (s, tableEntry) -> {
          tableEntry.dist = 0;
          return tableEntry;
        });

    while (!queue.isEmpty()) {
      var neighbour = queue.remove();
      visited.add(neighbour.node.name);

      for (var e : neighbour.node.edges) {
        // update neighbour estimates

        var newDistance = neighbour.distance + e.weight;
        table.computeIfPresent(
            e.to.name,
            (s, tableEntry) -> {
              if (newDistance < tableEntry.dist) {
                tableEntry.dist = newDistance;
                tableEntry.path = neighbour.node;
              }
              return tableEntry;
            });

        if (!visited.contains(e.to.name)) {
          queue.add(new Neighbour(e.to, newDistance));
        }
      }
    }
    System.out.println(visited);

    for (var entry : table.entrySet()) {
      System.out.println(
          "Distance from A to "
              + entry.getKey()
              + " is "
              + entry.getValue().dist
              + " via "
              + entry.getValue().path);
    }
    return table;
  }

  void hasCycle() {
    System.out.println("Cycle Exists " + hasCycle(nodeMap.get("A"), null, new HashSet<>()));
  }

  private boolean hasCycle(Node node, Node parent, Set<String> visited) {
    var hasCycle = false;
    visited.add(node.name);
    for (var e : node.edges) {
      if (e.to == parent) continue;
      if (!visited.contains(e.to.name)) {
        hasCycle = hasCycle || hasCycle(e.to, node, visited);
      } else {
        return true;
      }
    }

    return hasCycle;
  }

  void getMinimumSpanningTree() {
    var minSpanTree = new WeightedGraph();
    var queue = new PriorityQueue<Edge>(Comparator.comparingInt(value -> value.weight));

    var node = nodeMap.get("A");

    queue.addAll(node.edges);
    minSpanTree.addNode(node.name);

    while (minSpanTree.nodeMap.size() < nodeMap.size()) {

      var minEdge = queue.remove();
      var nextNode = minEdge.to;

      if (minSpanTree.nodeMap.containsKey(nextNode.name)) continue;

      minSpanTree.addNode(nextNode.name);
      minSpanTree.addEdge(minEdge.from.name, nextNode.name, minEdge.weight);

      for (var e : nextNode.edges) {
        if(!minSpanTree.nodeMap.containsKey( e.to.name ))
         queue.add(e);
      }
    }
    minSpanTree.print();
  }

  static class Neighbour {
    private final Node node;
    private final int distance;

    public Neighbour(Node node, int distance) {
      this.node = node;
      this.distance = distance;
    }

    public int getDistance() {
      return distance;
    }
  }

  static class TableEntry {

    private final Node node;
    private int dist;
    private Node path;

    public TableEntry(Node node, int dist, Node path) {
      this.node = node;
      this.dist = dist;
      this.path = path;
    }
  }

  static class Node {
    private final String name;
    private final Set<Edge> edges;

    public Node(String name) {
      this.name = name;
      this.edges = new HashSet<>();
    }

    @Override
    public String toString() {
      return name;
    }
  }

  static class Edge {
    private final Node from;
    private final Node to;
    private final int weight;

    public Edge(Node from, Node to, int weight) {
      this.from = from;
      this.to = to;
      this.weight = weight;
    }

    @Override
    public String toString() {
      return from.name + " => " + to.name + " :: " + weight;
    }
  }
}
