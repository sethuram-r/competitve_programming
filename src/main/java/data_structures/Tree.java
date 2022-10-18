package data_structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class Tree {

  Node root;

  public Node getRoot() {
    return root;
  }

  void insert(int num) {

    if (this.root == null) {
      this.root = new Node(num, null, null);
      return;
    }

    var current = this.root;

    while (true) {

      if (num < current.value) {
        if (current.left == null) {
          current.left = new Node(num, null, null);
          return;
        } else current = current.left;
      }

      if (num > current.value) {
        if (current.right == null) {
          current.right = new Node(num, null, null);
          return;
        } else current = current.right;
      }
    }
  }

  boolean find(int num) {

    var current = this.root;

    while (current != null) {

      if (current.value == num) return true;
      if (num < current.value) current = current.left;
      if (num > current.value) current = current.right;
    }
    return false;
  }

  void traversePreOrder() {
    traversePreOrder(this.root);
  }

  private void traversePreOrder(Node root) {
    if (root == null) return;
    System.out.println(root.value);
    traversePreOrder(root.left);
    traversePreOrder(root.right);
  }

  void traverseInOrder() {
    traverseInOrder(this.root);
  }

  private void traverseInOrder(Node root) {
    if (root == null) return;
    traverseInOrder(root.left);
    System.out.println(root.value);
    traverseInOrder(root.right);
  }

  void traversePostOrder() {
    traversePostOrder(this.root);
  }

  private void traversePostOrder(Node root) {
    if (root == null) return;
    traversePostOrder(root.left);
    traversePostOrder(root.right);
    System.out.println(root.value);
  }

  void height() {
    System.out.println("Tree height " + height(this.root));
  }

  private int height(Node node) {
    if (node == null) return -1;
    return 1 + Math.max(height(node.left), height(node.right));
  }

  void min() {
    System.out.println(min(this.root));
  }

  private int min(Node node) {

    if (node == null) return MAX_VALUE;

    var left = min(node.left);
    var right = min(node.right);

    return Math.min(node.value, Math.min(left, right));
  }

  void equals(Tree t) {
    System.out.println(equals(root, t.root));
  }

  private boolean equals(Node root1, Node root2) {

    if (root1 == null && root2 == null) return true;

    if (root1 != null && root2 != null) {
      var root = root1.value == root2.value;
      var left = equals(root1.left, root2.left);
      var right = equals(root1.right, root2.right);
      return root && left && right;
    }
    return false;
  }

  void validate() {
    System.out.println(validate(root, MIN_VALUE, MAX_VALUE));
  }

  private boolean validate(Node node, int min, int max) {
    if (node == null) return true;

    if (node.value > max || node.value < min) {
      return false;
    }

    return validate(node.left, min, node.value - 1) && validate(node.right, node.value + 1, max);
  }

  void getNodesK(int k) {

    getknodes(this.root, 0, k);
  }

  private void getknodes(Node node, int currentDistance, int k) {

    if (node == null) return;
    if (currentDistance == k) {
      System.out.println(node.value);
    }

    currentDistance++;
    getknodes(node.left, currentDistance, k);
    getknodes(node.right, currentDistance, k);
  }

  void levelOrderTraversal() {
    for (int i = 0; i <= height(root); i++) {
      getNodesK(i);
    }
  }

  void size() {
    System.out.println(size(this.root));
  }

  private int size(Node root) {
    if (root == null) return 0;
    return 1 + size(root.left) + size(root.right);
  }

  private boolean isLeaf(Node node) {
    return node.left == null && node.right == null;
  }

  public void countLeaves() {
    System.out.println(countLeaves(root));
  }

  private int countLeaves(Node root) {
    if (root == null) return 0;

    if (isLeaf(root)) return 1;

    return countLeaves(root.left) + countLeaves(root.right);
  }

  void max() {
    System.out.println(max(root));
  }

  int max(Node root) {

    if (root == null) return MIN_VALUE;

    var lmax = max(root.left);
    var rmax = max(root.right);

    return Math.max(root.value, Math.max(lmax, rmax));
  }

  void contains(int num) {
    System.out.println(contains(root, num));
  }

  private boolean contains(Node node, int num) {
    if (node == null) return false;
    if (node.value == num) return true;

    return contains(node.left, num) || contains(node.right, num);
  }

  void siblings(int num, int num2) {
    System.out.println(siblings(root, num, num2));
  }

  private boolean siblings(Node node, int num, int num2) {

    if (node.left == null || node.right == null) return false;
    if ((node.left.value == num || node.left.value == num2)
        && ((node.right.value == num || node.right.value == num2))) return true;

    return siblings(node.left, num, num2) || siblings(node.right, num, num2);
  }

  public void getAncestors(int num) {
    getAncestors(root, num);
  }

  private boolean getAncestors(Node root, int num) {

    if (root == null) return false;

    if (root.value == num) {
      return true;
    }

    var res = getAncestors(root.left, num) || getAncestors(root.right, num);
    if (res) System.out.println(root.value);

    return res;
  }

  void listOfDepths() {

    ArrayList<java.util.LinkedList<Integer>> result = new ArrayList<>();
    listOfDepths(root, result, 0);

    for (var r : result) {
      for (var i : r) {
        System.out.println(i);
      }
    }
  }

  private void listOfDepths(Node root, ArrayList<java.util.LinkedList<Integer>> nodes, int depth) {
    if (root == null) return;

    if (nodes.size() == depth) {
      var ll = new LinkedList<Integer>();
      ll.addLast(root.value);
      nodes.add(ll);
    } else {
      nodes.get(depth).addLast(root.value);
    }

    listOfDepths(root.left, nodes, depth + 1);
    listOfDepths(root.right, nodes, depth + 1);
  }

  void isBalanced() {
    System.out.println("Is balanced " + isBalanced(root));
  }

  private boolean isBalanced(Node node) {

    if (root == null) return true;
    var bf = height(node.left) - height(node.right);
    if (Math.abs(bf) > 1) {
      return false;
    } else {
      return isBalanced(node.left) && isBalanced(node.right);
    }
  }

  void print() {
    print(root);
  }

  private void print(Node root) {
    if (root == null) return;
    System.out.println(root.value);
    print(root.left);
    print(root.right);
  }

  public void next(int target) {
    int result = next(root, target, 0);
    System.out.println("Next node " + result);
  }

  private int next(Node root, Integer target, int count) {
    if (root == null) return 0;
    int result = 0;
    result += next(root.left, target, count);
    count += result;
    if (root.value > target) count = count + 1;
    if (root.value > target && count == 1) result = root.value;
    result += next(root.right, target, count);
    return result;
  }

  public void getCommonAncestor(int n1, int n2) {
    String[] result = new String[1];
    getCommonAncestor(root, n1, n2, result);
    System.out.println("Result is " + result[0]);
  }

  private boolean getCommonAncestor(Node root, int node1, int node2, String[] ancestor) {

    if (root == null) return false;

    if (root.value == node1 || (root.value == node2)) {
      return true;
    }

    var lresult = getCommonAncestor(root.left, node1, node2, ancestor);
    var rresult = getCommonAncestor(root.right, node1, node2, ancestor);
    if (lresult && rresult) {
      ancestor[0] = String.valueOf(root.value);
      return false;
    }
    return lresult || rresult;
  }

  public void checkSubTree(Tree subTree) {
    System.out.println("Is sub tree " + checkSubTree(root, subTree.getRoot()));
  }

  private boolean checkSubTree(Node root1, Node root2) {
    if ((root1 == null && root2 == null)) {
      return true;
    } else if (root1 == null || root2 == null) {
      return false;
    }
    var result = root1.value == root2.value;

    if (result) {
      result = (checkSubTree(root1.left, root2.left) && checkSubTree(root1.right, root2.right));
    } else {
      result = checkSubTree(root1.left, root2) || checkSubTree(root1.right, root2);
    }
    return result;
  }

  public void sumPaths(){

  }

  private  int sumPath(Node root, int target ){
    if( root == null) return 0;

    int pcount = getRootSumPath(root,target,0);
    int lcount =  sumPath(root.left,target);
    int rcount =  sumPath(root.right,target);
    return pcount+lcount+rcount;
  }

  private int getRootSumPath(Node root, int target, int previous) {
    int count = 0;
    if( root == null) return 0;
    previous+=root.value;
    if(previous == target) count = count +1;

    count += getRootSumPath(root.left, target,  previous);
    count += getRootSumPath(root.right, target,  previous);
    return count;

  }

  public void insertRec(int value){
      root = insertRec(root,value);
  }

  private Node insertRec(Node node, int num){
    if(node == null){
      return new Node( num,null,null );
    }

    if(num < node.value) node.left =  insertRec( node.left,num );
    if(num > node.value ) node.right = insertRec( node.right,num );
    return node;
  }

  public void leftViewTree(){
    var result = new HashMap<Integer,Integer>() ;
    leftViewTree(root,0,result);
    for (var r : result.entrySet()) {
      System.out.println(r);
    }
  }

  private void leftViewTree(Node node, int depth, Map<Integer,Integer> result){
    if(node == null) return;

    result.putIfAbsent(depth,node.value);

    leftViewTree(node.left,depth+1,result);
    leftViewTree(node.right,depth+1,result);

  }

  public void rightViewTree(){
    var result = new HashMap<Integer,Integer>() ;
    rightViewTree(root,0,result);
    for (var r : result.entrySet()) {
      System.out.println(r);
    }
  }

  private void rightViewTree(Node node, int depth, Map<Integer,Integer> result){
    if(node == null) return;

    result.put(depth,node.value);

    rightViewTree(node.left,depth+1,result);
    rightViewTree(node.right,depth+1,result);

  }

  private static class Node {
    int value;

    Node left;
    Node right;

    public Node(int value, Node left, Node right) {
      this.value = value;
      this.left = left;
      this.right = right;
    }
  }

  public static void main(String[] args) {
    Tree tree = new Tree();
    tree.insertRec( 5 );
    tree.insertRec( 3 );
    tree.insertRec( 7 );
    tree.insertRec( 6 );

    tree.print();
    tree.leftViewTree();
    tree.rightViewTree();
  }
}