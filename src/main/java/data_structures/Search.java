package data_structures;

public class Search {

  private final int[] data = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

  public int linear(int num) {
    for (int i = 0; i < data.length; i++) {
      if (data[i] == num) {
        return i;
      }
    }
    return -1;
  }

  public void binary(int target) {

    System.out.println(binary(target, 0, data.length - 1));
  }

  private int binary(int target, int left, int right) {

    int middleIndex = (left + right) / 2;

    if (data[middleIndex] == target) return target;

    if (left == right) return -1;

    if (target < data[middleIndex]) return binary(target, left, middleIndex - 1);

    return binary(target, middleIndex + 1, right);
  }

  public void ternary(int target) {

    System.out.println(ternary(target, 0, data.length - 1));
  }

  private int ternary(int target, int left, int right) {

    int partitionSize  = (right -left) / 3;
    var mid1 = left + partitionSize;
    var mid2 = right - partitionSize;

    if (data[mid1] == target || data[mid2] == target) return target;

    if (left == right) return -1;

    if (target < data[mid1] ) return ternary(target, left, mid1 - 1);
    if (target > data[mid1]) return ternary(target, mid1 +1, right);


    return ternary(target, mid2 +1, right);
  }
}
