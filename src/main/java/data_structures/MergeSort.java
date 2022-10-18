package data_structures;

public class MergeSort {

  int[] sort(int... arr) {

    if (arr.length == 1) return arr;

    var middle = (arr.length / 2);
    var remaining = arr.length - middle;
    var left = new int[middle];
    var right = new int[remaining];

    for (int i = 0; i < middle; i++) left[i] = arr[i];
    for (int j = middle; j < arr.length; j++) right[j % right.length] = arr[j];

    var sortedLeft = sort(left);
    var sortedRight = sort(right);

    // merge

    int count = 0;
    int leftIndex = 0;
    int rightIndex = 0;

    while (leftIndex != sortedLeft.length && rightIndex != sortedRight.length) {
      arr[count++] =
          (sortedLeft[leftIndex] < sortedRight[rightIndex])
              ? sortedLeft[leftIndex++]
              : sortedRight[rightIndex++];
    }
    if (count != arr.length) {
      if (leftIndex == sortedLeft.length)
        while (rightIndex != sortedRight.length) arr[count++] = sortedRight[rightIndex++];

      if (rightIndex == sortedRight.length)
        while (leftIndex != sortedLeft.length) arr[count++] = sortedLeft[leftIndex++];
    }
    return arr;
  }
}
