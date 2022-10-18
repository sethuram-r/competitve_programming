package data_structures;

import java.util.Arrays;

public class SelectionSort {

  void sort(int... arr) {

    for (int i = 0; i < arr.length; i++) {

      int minIndex = 0;
      int min = Integer.MAX_VALUE;
      for (int j = i; j < arr.length ; j++) {
        if(arr[j] < min ){
          min = arr[j];
          minIndex = j;
        }
      }
      var temp = arr[i];
      arr[i] = arr[minIndex];
      arr[minIndex] = temp;
    }
    System.out.println(Arrays.toString(arr));
  }
}
