package data_structures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class QueueReverser {

    private final Stack<Integer> revStack = new Stack<>();
    private final Deque<Integer> queue;

    public QueueReverser(Deque<Integer> queue) {
        this.queue = queue;
    }

    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add( 10 );
        queue.add( 20 );
        queue.add( 30 );

        System.out.println( queue );

        QueueReverser queueReverser = new QueueReverser( queue );
        queueReverser.reverse();
        queueReverser.print();
    }

    void reverse() {
        while (!queue.isEmpty()) {
            revStack.push( queue.remove() );
        }
        while (!revStack.isEmpty()) {
            queue.add( revStack.pop() );
        }

    }

    void print() {
        System.out.println( this.queue.poll() );
    }
}
