package data_structures;

public class AvlTree {

  private Node root;

  public void insert(int num) {
    root = insert(this.root, num);
  }

  private Node insert(Node node, int num) {

    if (node == null) {
      node = new Node(num);
    }

    if (num < node.value) node.left = insert(node.left, num);
    if (num > node.value) node.right = insert(node.right, num);


    node.height = 1 + Math.max(height(node.left), height(node.right));
    node.bf = height(node.left) -  height(node.right);
    if (node.bf > 1) {
       // System.out.println("left heavy");
        System.out.println("right rotation");
        if(node.left.bf <0 ){
            System.out.println("right rotation");
            var temp = node.left;
            node.left = node.left.right;
            temp.right = null;
            node.left.left = temp;
            recalibrateHeightAndBf(node.left);
            recalibrateHeightAndBf(node.left.left);

        }

        var temp = node;
        node = node.left;
        temp.left = null;
        node.right = temp;
        recalibrateHeightAndBf(node);
        recalibrateHeightAndBf(node.right);
    }
    if (node.bf < -1) {
       // System.out.println("right heavy");
        System.out.println("right rotation");
        if(node.right.bf >0 ){
            System.out.println("left rotation");
            var temp = node.right;
            node.right = node.right.left;
            temp.left =null;
            node.right.right = temp;

            recalibrateHeightAndBf(node.right);
            recalibrateHeightAndBf(node.right.right);
        }

        var temp = node;
        node = node.right;
        temp.right = null;
        node.left = temp;

        recalibrateHeightAndBf(node);
        recalibrateHeightAndBf(node.left);
    }
      node.height = 1 + Math.max(height(node.left), height(node.right));
      node.bf = height(node.left) -  height(node.right);
    return node;
  }

  private void recalibrateHeightAndBf(Node node){
      node.height = 1 + Math.max(height(node.left), height(node.right));
      node.bf = height(node.left) -  height(node.right);
  }
  private int height(Node node){
      return node == null ?0:node.height;
  }

  public void height() {
    System.out.println("hielght : "
            + this.root.height);
  }

  public void bf() {
    System.out.println("balance factor : " + this.root.bf);
  }

  public void print() {
    print(this.root);
  }

  private void print(Node node) {
    if (node == null) return;

    print(node.left);
      System.out.println(node.value);
    print(node.right);

  }

   void isBalanced(){
    System.out.println("Balanced :" +
    isBalanced(this.root));
  }

  private boolean isBalanced(Node node){

      if(node == null) return true;
      if(node.bf > 1 || node.bf < -1){
          return false;
      }

      return isBalanced(node.left) && isBalanced(node.right);

  }

    void isPerfect(){
        System.out.println("Perfect :" +
                isPerfect(this.root));
    }

    private boolean isPerfect(Node node){

        if(node == null) return true;
        if(node.bf != 0){
            return false;
        }

        return isPerfect(node.left) && isPerfect(node.right);

    }

  static class Node {
    private int value;
    private Node left;
    private Node right;
    private int height;
    private int bf;

    Node(int num) {
      this.value = num;
    }
  }
}
