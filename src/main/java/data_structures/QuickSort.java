package data_structures;

import java.util.Arrays;

public class QuickSort {

    void sort(int ...arr){
    sort(arr, 0, arr.length-1);
    System.out.println(Arrays.toString(arr));
    }

    private void sort(int[] arr,int left,int right){

        if(left >= right) return;

        // finding pivot

        var pivot = arr[(left+right)/2];
        var index = partition( arr,left,right,pivot );
        sort( arr,left,index-1 );
        sort( arr,index,right );

    }

    private int partition(int[] arr,int left,int right,int pivot){
        while (left <= right){
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;

            if(left <= right){
                // swap
                var temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
        return left;
    }


}
