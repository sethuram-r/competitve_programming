package book;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ChapterThree {

  static class sortStack{

    private Stack<Integer> original = new Stack<>();
    private Stack<Integer> sorted = new Stack<>();

    void push(int num){
      original.push( num );
      if(sorted.isEmpty() || num < sorted.peek()) {
        sorted.push( num );
      }else{
        int tempCount = 0;
        while (!sorted.isEmpty() && num > sorted.peek()){
          original.push( sorted.pop() );
          tempCount++;
        }
        sorted.push( num );
        while (tempCount != 0){
          sorted.push( original.pop() );
          tempCount--;
        }
      }
      original.clear();
    }

    void popSorted(){
      if(!sorted.isEmpty())
        System.out.println( sorted.pop());
    }

  }

  static class QueueUsingStacks{

    private Stack<Integer> push = new Stack<>();
    private Stack<Integer> pop = new Stack<>();

    void enqueue(int num){
      push.push( num );
    }

    void dequeue(){
      if(pop.isEmpty()){
        while (!push.isEmpty()){
          pop.push(push.pop() );
        }
      }
      System.out.println(pop.pop());
    }

  }

  static class Plates{
    List<Stack<Integer>> racks = new ArrayList<>();
    int currentRack = 0;
    int threshold = 3;

    private void addNewRack(List<Stack<Integer>> racks, int rackIndex, int num) {
      var stack = new Stack<Integer>();
      stack.push(num);
      racks.add(rackIndex, stack);
    }

    void push(int num) {
      if (racks.isEmpty()) {
        addNewRack(racks, currentRack, num);
      } else {
        if (racks.get(currentRack).size() != threshold) {
          racks.get(currentRack).push(num);
        } else {
          addNewRack(racks, ++currentRack, num);
        }
      }
    }

    void pop() {

      System.out.println(racks.get(currentRack).pop());
      if(racks.get( currentRack ).isEmpty()){
        racks.remove( currentRack-- );
      }
    }

    void popAtIndex(int index) {
      if (racks.get(index) == null) throw new IllegalArgumentException();
      System.out.println(racks.get(index).pop());
    }

    void print() {
      StringBuilder builder = new StringBuilder();
      for (var r : racks) {
        builder.append("[");
        for (var i : r) {
          builder.append(i);
          builder.append(" ");
        }
        builder.append("]");
        System.out.println(builder);
      }
    }
  }

  public static void main(String[] args) {
    ChapterThree.Plates plates = new Plates();
    plates.push( 1 );
    plates.push( 2);
    plates.push( 3 );
    plates.push( 4 );
    plates.push( 5 );
    plates.push( 6 );
    plates.push( 7 );

    plates.print();

    plates.pop();
    plates.print();
    plates.pop();
    plates.print();
    plates.popAtIndex( 0 );
    plates.print();

    ChapterThree.QueueUsingStacks queueUsingStacks = new QueueUsingStacks();
    queueUsingStacks.enqueue( 1 );
    queueUsingStacks.enqueue( 2 );
    queueUsingStacks.enqueue( 3 );

    queueUsingStacks.dequeue();
    queueUsingStacks.dequeue();
    queueUsingStacks.dequeue();

    ChapterThree.sortStack sortStack = new sortStack();
    sortStack.push( 5 );
    sortStack.push( 7 );
    sortStack.push( 4 );

    sortStack.popSorted();
    sortStack.popSorted();
    sortStack.popSorted();

  }
}
