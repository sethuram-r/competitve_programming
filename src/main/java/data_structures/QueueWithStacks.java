package data_structures;

import java.util.Stack;

public class QueueWithStacks {

    private Stack<Integer> pushStack = new Stack<>();
    private Stack<Integer> popStack = new Stack<>();

    void enqueue(int num){
        pushStack.push( num );
    }

    int dequeue(){
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push( pushStack.pop() );
            }
        }
           return popStack.pop();
    }
}
