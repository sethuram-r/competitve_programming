package data_structures;

import java.util.Stack;

public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> min;

    public MinStack() {

        this.stack = new Stack<>();
        this.min = new Stack<>();
    }


    void push(int num){
        stack.push( num );
        if(min.isEmpty()) {
            min.push( num );
        }else{
            if(num < min.peek()) min.push( num );
        }
    }

    int pop(){
        var top = stack.pop();
        if(top == min.peek()) {
           return min.pop();
        }
        return top;
    }

    int min(){
        return min.peek();
    }
}
