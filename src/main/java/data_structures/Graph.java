package data_structures;

import java.util.LinkedList;
import java.util.*;

public class Graph {

  Map<String, Node> nodes = new LinkedHashMap<>();

  Map<Node, LinkedList<Node>> adjacencyList = new LinkedHashMap<>();

  public void addNode(String label) {

    var newNode = new Node(label);
    nodes.putIfAbsent(label, newNode);
    adjacencyList.putIfAbsent(newNode, new LinkedList<>());
  }

  public void removeNode(String label) {

    if (nodes.containsKey(label)) {

      var node = nodes.get(label);
      for (var entry : adjacencyList.entrySet()) {
        entry.getValue().remove(node);
      }
      adjacencyList.remove(node);
      nodes.remove(label);
    }
  }

  public void addEdge(String from, String to) {
    var fromNode = nodes.get(from);
    var toNode = nodes.get(to);
    if (fromNode != null && toNode != null) {
      var fromNodeEdges = adjacencyList.get(fromNode);
      fromNodeEdges.addLast(toNode);
    }
  }

  public void removeEdge(String from, String to) {
    var fromNode = nodes.get(from);
    var toNode = nodes.get(to);
    if (fromNode != null && toNode != null) {
      var fromNodeEdges = adjacencyList.get(fromNode);
      fromNodeEdges.remove(toNode);
    }
  }

  public void print() {
    System.out.println("-----------------------------------");
    for (var entry : adjacencyList.entrySet()) {
      StringBuilder builder = new StringBuilder();
      builder.append(entry.getKey().name);
      builder.append("[ ");
      for (var node : entry.getValue()) {
        builder.append(node.name);
        builder.append(" ");
      }
      builder.append("]");
      System.out.println(builder);
    }
    System.out.println("-----------------------------------");
  }

  public void depthFirstRec() {

    var startNode = nodes.get("A");
    Set<String> visited = new LinkedHashSet<>();
    depthFirstRec(startNode, visited);
    System.out.println(visited);
  }

  private void depthFirstRec(Node node, Set<String> visited) {

    visited.add(node.name);

    for (var n : adjacencyList.get(node)) {
      if (!visited.contains(n.name)) depthFirstRec(n, visited);
    }
  }

  public void depthFirst() {
    var stack = new Stack<Node>();
    Set<String> visited = new LinkedHashSet<>();

    stack.push(nodes.get("A"));

    while (!stack.isEmpty()) {
      var node = stack.pop();
      visited.add(node.name);
      for (var n : adjacencyList.get(node)) {
        if (!visited.contains(n.name)) {
          stack.push(n);
        }
      }
    }
    System.out.println(visited);
  }

  public void breadthFirst() {
    var queue = new ArrayDeque<Node>();
    Set<String> visited = new LinkedHashSet<>();

    queue.add(nodes.get("A"));

    while (!queue.isEmpty()) {
      var node = queue.remove();
      visited.add(node.name);
      for (var n : adjacencyList.get(node)) {
        if (!visited.contains(n.name)) {
          queue.add(n);
        }
      }
    }
    System.out.println(visited);
  }

  public void topologicalSort() {

    for (var node : nodes.values()) {
      var s = new Stack<Node>();
      var result = new ArrayList<String>();
      toplogicalSort(node, s);

      while (!s.isEmpty()) {
        result.add(s.pop().name);
      }
      System.out.println(Arrays.toString(result.toArray()));
    }
  }

  private void toplogicalSort(Node node, Stack<Node> stack) {

    for (var n : adjacencyList.get(node)) {
      if (!stack.contains(n)) toplogicalSort(n, stack);
    }
    stack.push(node);
  }

  public void hasCycle() {
    var all = new LinkedHashSet<Node>();
    var visiting = new LinkedHashSet<Node>();
    var visited = new LinkedHashSet<Node>();

    all.addAll(nodes.values());

    while (!all.isEmpty()){
      var current = all.iterator().next();
        System.out.println("Has Cycle "+hasCycle(current, all, visiting, visited ));
    }

 //   System.out.println("Has Cycle "+hasCycle(nodes.get("A"), all, visiting, visited ));

  }

  private boolean hasCycle(
      Node node,
      LinkedHashSet<Node> all,
      LinkedHashSet<Node> visiting,
      LinkedHashSet<Node> visited) {

    all.remove(node);
    visiting.add(node);

    boolean cycyleExist = false;
    for (var n : adjacencyList.get(node)) {

      if (visiting.contains(n)) cycyleExist =  true;
      if(!visited.contains( n ))
        cycyleExist = cycyleExist ||  hasCycle(n, all, visiting, visited);
    }
    visiting.remove(node);
    visited.add(node);
    return cycyleExist;
  }

  public void hasRoute(String from , String to){
    var fromNode = nodes.get( from );
    System.out.println("Has route " +hasRoute( fromNode,new HashSet<>(),to ));
  }

  private boolean hasRoute(Node root, Set<Node> visited, String to){

    visited.add( root );
    var isRoute = false;
    if(Objects.equals( root.name, to )) return true;

    for( var e : adjacencyList.get( root )){
      if(!visited.contains( e )){
       isRoute = isRoute || hasRoute( e,visited,to );
      }
    }
    return isRoute;
  }

  public void buildfirst(){
    Set<Node> visited = new LinkedHashSet<>();
    for (var node : nodes.values()) {
        buildfirst(node,visited);
    }
    for (var v :visited ) {
      System.out.println(v.name);
    }

  }

  private void buildfirst(Node node, Set<Node> visited){
    for (var e : adjacencyList.get( node )) {
        if(!visited.contains( e )){
          buildfirst(e,visited);
        }
    }
    visited.add( node );
  }



  static class Node {
    private final String name;

    public Node(String name) {
      this.name = name;
    }
  }
}
