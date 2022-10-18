package data_structures;

import java.util.Arrays;

public class SethuStack {

  public static final int DEFAULT_SIZE = 5;
  private int[] arr;
  private int count = 0;

  public SethuStack() {
    this.arr = new int[DEFAULT_SIZE];
  }

  void push(int num) {
    if (count == arr.length) resize(arr.length + DEFAULT_SIZE);
    this.arr[count++] = num;
  }

  int pop(){
      if(count == 0) throw new IllegalStateException();
      if(arr.length - count > DEFAULT_SIZE) resize(arr.length - DEFAULT_SIZE);
      int num = arr[count-1];
      count--;
      return num;
  }


    int peek(){
        return arr[count-1];
    }

  boolean isEmpty(){
      return count == 0;
  }

  void print(){
    System.out.println( Arrays.toString( this.arr ));
  }

  private void resize(int size){
      var newArr = new int[size];
      for (int i = 0; i < count; i++) {
          newArr[i] = arr[i];
      }
      this.arr = newArr;
  }


}
