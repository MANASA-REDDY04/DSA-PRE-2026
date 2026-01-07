package Sortings;

import java.util.Arrays;

public class CountingSort {
    public static void countingSort(int[] arr,int n){
        int max = Integer.MIN_VALUE;
        for(int i : arr) max = Math.max(max,i);
        int[] count = new int[max+1];

        //freq map
        for(int i = 0; i < n; i++){
            count[arr[i]]++;
        }
        int j = 0;
        for(int i = 0; i <= max; i++){
            while (count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {10,4,5,18,3,6,43};
        countingSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
