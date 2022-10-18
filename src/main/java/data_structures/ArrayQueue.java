package data_structures;

import java.util.Arrays;

public class ArrayQueue {
    private static int DEFAULTSIZE = 5;
    private int[] arr;
    private int first = 0;
    private int last =  0;
    private int count = 0;

    public ArrayQueue() {
        this.arr = new int[DEFAULTSIZE];
    }


    void enqueue(int num){

        if(count !=DEFAULTSIZE ){
            arr[last++] = num;
            count++;
        }else{
            throw new IllegalStateException("queue full");
        }

        if(last == DEFAULTSIZE){
            last = 0;
        }


    }

    int dequeue(){

        if(count != 0){
            var pop =  arr[first++];
            if(first == DEFAULTSIZE){
                first = 0;
            }
            count--;
            return pop;
        }
        else{
            throw new IllegalStateException("queue empty");
        }

    }

    boolean isEmpty(){
        return (count == 0);
    }


    void print(){
    System.out.println( Arrays.toString(arr));
    }
}
