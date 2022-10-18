package data_structures;

import java.util.Arrays;
import java.util.LinkedList;

public class Bucketsort {

  void sort(int... arr) {

    LinkedList<Integer>[] buckets = new LinkedList[arr.length];

    for (int i = 0; i <arr.length; i++) {
      if (buckets[arr[i] / buckets.length] == null) {
        var l = new LinkedList<Integer>();
        l.addLast(arr[i]);
        buckets[arr[i] / buckets.length] = l;
      } else {
        buckets[arr[i] / buckets.length].addLast(arr[i]);
      }
    }

    for (var bucket : buckets) {
      if(bucket != null) {
        System.out.println(bucket);
        bucket.sort(Integer::compareTo);
      }
    }

    int count = 0;
    for (var bucket : buckets) {
      if(bucket != null){
        while (!bucket.isEmpty()) {
          arr[count++] = bucket.remove();
        }
      }

    }

    System.out.println("bucket Sort "+Arrays.toString(arr));
  }
}
