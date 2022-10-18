package book;

import java.util.HashSet;
import java.util.Set;

public class ChapterTwo {

  public static void main(String[] args) {
    Node node = new Node(5);
    node.add(4);
    node.add(4);
    node.add(3);
//
//    node.print();
//    node.removeDuplicates();
//    node.print();

//    node.getKFromLast( 0 );
//    node.getKFromLast( 1 );
//    node.getKFromLast( 2 );

    Node node1 = new Node(7);
    node1.add(1);
//    node1.add(6);

    Node node2 = new Node(5);
//    node2.add(9);
//    node2.add(2);

    Node node3 = new Node(0);
    node3.add( 1 );
    node3.add( 2 );
    node3.add( 1 );
    node3.add( 1 );
    node.pallindrome(node3);


   // node.sumList(node1,node2);
  }

  static class Node {
    int value;
    Node next;

    public Node(int value) {
      this.value = value;
    }

    public Node(){

    }

    void add(int num) {
      var n = this;
      while (n.next != null) {
        n = n.next;
      }
      n.next = new Node(num);
    }

    void print() {
      var n = this;
      while (n != null) {
        System.out.println(n.value);
        n = n.next;
      }
    }

    void removeDuplicates(){
      var n = this;
      Node previous = null;
      Set<Integer> set= new HashSet<>();
      while (n.next != null) {
        if(!set.contains( n.value )){
          set.add( n.value );
          previous = n;
          n = n.next;
        }else{
          var temp = n.next;
          n.next = null;
          previous.next = temp;
        }
      }
    }

    void getKFromLast(int k){
      var a = this;
      var b = this;
      for (int i = 0; i < k; i++) {
        b = b.next;
      }
      while (b.next != null){
        a = a.next;
        b = b.next;
      }
      System.out.println("K th value : "+a.value);
    }

     void sumList(Node node1, Node node2){
      var n1 = node1;
      var n2 = node2;

      var n1Power =0;
      var value1=0;
      while (n1 != null){
        value1 += (int) (n1.value * Math.pow( 10,n1Power ));
        n1Power++;
        n1 = n1.next;

      }
      var n2Power =0;
      var value2=0;
      while (n2 != null){
        value2 += (int) (n2.value * Math.pow( 10,n2Power ));
        n2Power++;
        n2 = n2.next;
      }

      var result = value1 + value2;
      var temp = result;
      Node rn = null;
      while(temp/10 != 0){
        if(rn == null) rn = new Node(temp%10);
        temp = temp/10;
        rn.add( temp%10 );
      }

      rn.print();

    }

    void pallindrome(Node node){
      // reverse

      var original = node;
      Node previous = null;
      var n = node;

      while (n != null){
        var temp = n.next;
        n.next = previous;
        previous =n;
        if(temp != null) {
          n = temp;
        }else {
          break;
        }

      }

      n.print();

      while (node != null && n != null){
        if (node.value != n.value) {
          System.out.println("false");
          break;
        }
        node = node.next;
        n = n.next;
      }
      System.out.println("true");

    }
  }
}
