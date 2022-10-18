package data_structures;

import java.util.Arrays;

public class Array {

  public static void main(String[] args) {

      int[] arr = new int[5];
      arr[0]  = 1;
      arr[1]  = 2;
      arr[2]  = 3;
      arr[3]  = 4;
    System.out.println( Arrays.toString( arr ) );

    int[] arr2 = {1,2,3,4,5};
      System.out.println( Arrays.toString( arr2 ) );

    System.out.println("length : "+ arr2.length);
  }
}
