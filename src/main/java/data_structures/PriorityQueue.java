package data_structures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Queue;

public class PriorityQueue {

  public static final int DEFAULT_SIZE = 5;
  int[] arr;
  int count = 0;

  public PriorityQueue() {
    this.arr = new int[DEFAULT_SIZE];
  }

  private void resize() {
    var newArr = new int[count + DEFAULT_SIZE];

    for (int i = 0; i < count; i++) {
      newArr[i] = arr[i];
    }
    this.arr = newArr;
  }

  void enqueue(int num) {
    if (count == arr.length) resize();
    if(count == 0) {
      arr[count] = num;
    }else{
      if( num > arr[count -1]) arr[count] = num;
      for (int i = count-1; i >=0; i--) {
        if(num < arr[i]){
          arr[i+1] = arr[i];
          arr[i] = num;
        }
      }
    }
    count++;
  }

  int dequeue(){
    var first = arr[0];
    for(int i = 0; i < count; i++) {
      arr[i] = arr[i+1];
    }
    count--;
    return first;
  }

  void print(){
    System.out.println( Arrays.toString( arr ));
  }



  public static void main(String[] args) {
    Student student = new Student( 1,"apple" );
    Student student2 = new Student( 2,"baby" );
    Student student3 = new Student( 3,"cat" );


    Queue<Student>  students = new java.util.PriorityQueue<>( (o1, o2) -> Integer.compare( o2.rank, o1.rank ) );
    students.add( student );
    students.add( student2 );
    students.add( student3 );

    System.out.println(students.poll());


//    Queue<Integer>  priorityQueue = new java.util.PriorityQueue<>( Comparator.reverseOrder() );
//    priorityQueue.add( 1 );
//    priorityQueue.add( 2 );
//    priorityQueue.add( 3 );
//
//    System.out.println(priorityQueue.poll());
  }
}

class Student{
  int rank;
  String name;

  public Student(int rank, String name) {
    this.rank = rank;
    this.name = name;
  }

  @Override
  public String toString() {
    return "{" +
            "rank=" + rank +
            ", name='" + name + '\'' +
            '}';
  }
}