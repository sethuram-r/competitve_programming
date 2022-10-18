package data_structures;

import java.util.Arrays;

public class Heap {

  int[] data = new int[9];
  int count;

  private void bubbleUp(int currentIndex, int parentIndex) {

    if (data[currentIndex] < data[parentIndex] || (currentIndex == 0 && parentIndex == 0)) return;

    var parent = data[parentIndex];
    if (data[currentIndex] > parent) {
      // swap
      var temp = parent;
      data[parentIndex] = data[currentIndex];
      data[currentIndex] = temp;
    }

    bubbleUp(currentIndex, parentIndex);
    bubbleUp(parentIndex, (int) Math.floor(((parentIndex - 1) / 2)));
  }

  void insert(int num) {

    data[count++] = num;

    if (count != 0) {
      var currentIndex = count-1;
      var p = ((currentIndex - 1) / 2);
      var parentIndex = (int) Math.floor(p);
      bubbleUp(currentIndex, parentIndex);
    }
  }

  private void bubbleDown(int currentIndex) {
    var lc = (currentIndex * 2) + 1;
    var rc = (currentIndex * 2) + 2;

    if (lc > data.length || rc > data.length) return;
    var nextIndex = 0;
    if (data[lc] > data[rc]) {
      nextIndex = lc;
    } else {
      nextIndex = rc;
    }

    data[currentIndex] = Math.max(data[lc], data[rc]);
    bubbleDown(nextIndex);
  }

  int remove() {
    var removed = data[0];
    bubbleDown(0);
    data[count - 1] = 0;
    count--;
    return removed;
  }

  private int getLeftIndex(int i){
   return  (i * 2) + 1;
  }

  private int getLeftChild(int i,int[]num){
    var li = getLeftIndex( i );
    return (li<num.length-1)? num[li]:0;
  }

  private int getRightChild(int i,int[]num){
    var ri = getRightIndex( i );
    return (ri<num.length-1)? num[ri]:0;
  }

  private int getRightIndex(int i){
    return  (i * 2) + 2;
  }

  private void bubbleDown(int i,int[] num){

    while (getLeftIndex(i) < num.length-1 && getRightIndex(i) < num.length-1) {

      var lc = getLeftChild(i , num);
      var rc = getRightChild( i,num);
      var max = Math.max( lc,rc );
      var mi = 0;

      if(lc > rc) mi = getLeftIndex(i);
      if(rc > lc) mi = getRightIndex(i);

      if(num[i] < max){
        var temp = num[i];
        num[i] = max;
        num[mi] = temp;
        i = mi;
      }
    }
  }

  int[] heapify(int[] num){

    for (int i = 0; i < num.length; i++) {
      bubbleDown( i,num );
    }
    return num;
  }

  void print() {
    System.out.println(Arrays.toString(data));
  }
}
