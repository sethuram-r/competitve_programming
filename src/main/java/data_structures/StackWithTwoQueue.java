package data_structures;

import java.util.ArrayDeque;

public class StackWithTwoQueue {


    private ArrayDeque<Integer> queue1 = new ArrayDeque<>();
    private ArrayDeque<Integer> queue2 = new ArrayDeque<>();
    private int count = 0;


    void push(int num){
        queue1.add( num );
        count++;
    }

    int pop(){
    for (int i = 0; i < count-1; i++) {
      queue2.add( queue1.remove() );
    }
    var element = queue1.remove();
    var temp = queue1;
    queue1 = queue2;
    queue2 = temp;
    count--;
    return element;
    }

    public static void main(String[] args){
//         ArrayDeque<Integer> queue1 = new ArrayDeque<>();
//        queue1.push( 1 );
//        queue1.push( 2 );
//        queue1.push( 3 );
//
//        queue1.add( 1 );
//        queue1.add( 2 );
//        queue1.add( 3 );
//
//        System.out.println(queue1.pop());
//        System.out.println(queue1.pop());
//        System.out.println(queue1.pop());
//
//        System.out.println(queue1.remove());
//        System.out.println(queue1.remove());
//        System.out.println(queue1.remove());

        StackWithTwoQueue stackWithTwoQueue = new StackWithTwoQueue();

        stackWithTwoQueue.push( 1 );
        stackWithTwoQueue.push( 2 );
        stackWithTwoQueue.push( 3 );

        System.out.println(stackWithTwoQueue.pop());
        System.out.println(stackWithTwoQueue.pop());
        System.out.println(stackWithTwoQueue.pop());
    }

}
