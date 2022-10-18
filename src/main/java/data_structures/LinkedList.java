package data_structures;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedList {
  int size;
  private Node first;
  private Node last;

  public void addFirst(int num) {

    var node = new Node(num);
    // first node
    if (size == 0) {
      first = last = node;
    } else {
      node.setNext(first);
      first = node;
    }
    size++;
  }

  public void addLast(int num) {
    var node = new Node(num);
    // first node
    if (size == 0) {
      first = last = node;
    } else {
      last.setNext(node);
      last = node;
    }
    size++;
  }

  public void deleteFirst() {
    if (size == 1) {
      first = last = null;
    } else {
      var newFirst = first.getNext();
      var old = first;
      old.setNext(null);
      first = newFirst;
    }
    size--;
  }

  public void deleteLast() {
    if (size == 1) {
      first = last = null;
    } else {
      int count = 0;
      var current = first;
      while (count != size - 1) {
        current = current.getNext();
        count++;
      }
      current.setNext(null);
      last = current;
    }
    size--;
  }

  boolean contains(int num) {
    int count = 0;
    Node current = first;
    while (count != size) {
      if (current.getValue() == num) {
        return true;
      }
      current = current.getNext();
      count++;
    }
    return false;
  }

  int indexOf(int num) {
    int count = 0;
    Node current = first;
    while (count != size) {
      if (current.getValue() == num) {
        return count;
      }
      current = current.getNext();
      count++;
    }
    return -1;
  }

  void reverse() {
    int count = 0;
    var current = first;
    Node previous = null;

    while (count != size) {
      var next = current.getNext();
      current.setNext(previous);
      if (previous == null) last = current;
      previous = current;
      if (next == null) {
        first = current;
      } else {
        current = next;
      }

      count++;
    }
  }
//
//  int getKthNodeFromEnd(int k) {
//    int count = 0;
//    Node current = first;
//    while (count != size) {
//      if (size - count == k) return current.getValue();
//      current = current.getNext();
//      count++;
//    }
//    return -1;
//  }
//
//  int getKFromEnd(int k) {
//    var a = first;
//    var b = first;
//    for (var i = 0; i < k - 1; i++) {
//      b = b.getNext();
//    }
//    while (b != last) {
//      b = b.getNext();
//      a = a.getNext();
//    }
//    return a.getValue();
//  }

//  String getMiddle() {
//    var a = first;
//    var b = first;
//
//    var arr = new ArrayList<Integer>(2);
//
//    while (b != last && b.getNext() != last) {
//      b = b.getNext().getNext();
//      a = a.getNext();
//    }
//
//    if (b == last) {
//      arr.add(a.getValue());
//    }
//
//    if (b.getNext() != null) {
//      arr.add(a.getValue());
//      arr.add(a.getNext().getValue());
//    }
//    return Arrays.toString(arr.toArray());
//  }

  public static LinkedList createWithLoop() {
    var list = new LinkedList();
    list.addLast(10);
    list.addLast(20);
    list.addLast(30);

    // Get a reference to 30
    var node = list.first;

//    list.addLast(40);
//    list.addLast(50);

    // Create the loop
    list.last.setNext(  node);

    return list;
  }

 // [10 20 30 40 50 -> 30]

  boolean hasLoop(){
    var a = first;
    var b = first;
    for (int i = 0; i <2 ; i++) {
      b = b.getNext();
    }
    while( b !=null ){
      if(b.getNext() == a) return true;
      a = a.getNext();
      b = b.getNext();
    }

    return false;
  }

  void print() {
    int count = 0;
    Node current = first;
    int[] arr = new int[size];
    while (count != size) {
      arr[count++] = current.getValue();
      current = current.getNext();
    }
    System.out.println(Arrays.toString(arr));
  }


  int getkfromlast(int k){

    var f = first;
    var s = first;

    for (int i = 0; i < k-1; i++) {
      s= s.getNext();
    }

    while(s.getNext() != null){
      s = s.getNext();
      f= f.getNext();
    }
    return f.getValue();

  }


  int[] getmiddle(){
    var m = first;
    var n = first;

    while (n.getNext().getNext() != null){
     n =  n.getNext().getNext();
     m = m.getNext();
    }

    if(size%2 ==0){
      return new int[]{m.getValue(),m.getNext().getValue()};
    }
    return new int[]{m.getValue()};




  }

}
