package data_structures;

public class SethuArray {

  private int[] arr;
  private int count = 0;

  public SethuArray(int index) {
    this.arr = new int[index];
  }


  private void resize(){
    if (count == this.arr.length) {
      int[] newArr = new int[2 * arr.length];
      for (int i = 0; i < count; i++) newArr[i] = arr[i];
      this.arr = newArr;
    }
  }
  void insert(int num) {
    resize();
    this.arr[count++] = num;
  }

//  [10,20]
  void insertAt(int num , int index){

    if(index >= arr.length || index <0) throw new IllegalArgumentException();

    resize();
    for (int j = count -1; j != index-1 ; j--) {
      arr[j+1] = arr[j];
    }
    arr[index] = num;
    count++;
  }

  void removeAt(int index) {
    for (int i = index; i < count; i++) {
      arr[i] = arr[i + 1];
    }
    count--;
  }

  int max() {
    int max = arr[0];
    for (int i = 0; i < count; i++) {

      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }

  void intersect(int... brr) {
    var crr = new SethuArray(count);
    for (int i : arr) {
      for (int j : brr) {

        if (i == j) {
          crr.insert(i);
          break;
        }
      }
    }
    crr.print();
  }

  void reverse(){
    var temp = new SethuArray(count);
    for (int i = count-1; i!=-1; i--) {
      temp.insert( arr[i] );
    }
    temp.print();
  }

  void swap(int first, int second){
    var temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }

  void print() {
    for (int i = 0; i < count; i++) {
      System.out.println(arr[i]);
    }
  }
}
