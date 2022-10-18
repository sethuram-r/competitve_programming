package data_structures;

import java.util.Arrays;

public class InsertionSort {

  void sort(int... arr) {

    for (int i = 0; i < arr.length; i++) {

      for (int j = i; j != 0; j--) {

        if (arr[j] < arr[j - 1]) {
          var temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;
        }
      }
    }
    System.out.println(Arrays.toString(arr));
  }
}
