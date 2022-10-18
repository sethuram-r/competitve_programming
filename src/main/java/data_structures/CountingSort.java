package data_structures;

import java.util.Arrays;

public class CountingSort {

  void sort(int... arr) {

    var max = 0;
    for (int k : arr) if (k > max) max = k;

    var occurance = new int[max+1];

    for (int k : arr) occurance[k]++;

    int count =0;
    for (int j = 0; j < occurance.length; j++) {
      if(occurance[j] != 0){

       while (occurance[j]!=0){
         arr[count++] =j;
         occurance[j]--;
       }

      }
    }
    System.out.println(Arrays.toString(arr));
  }
}
