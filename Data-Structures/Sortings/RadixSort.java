package Sortings;

import java.util.Arrays;

public class RadixSort {
    public static void countingSort(int[] arr,int n,int exp){
        int[] count = new int[10]; // 0-9
        int[] output = new int[n];

        for(int i = 0; i < n; i++){
            int digit = (arr[i]/exp)%10;
            count[digit]++;
        }
        // freq to position array
        for(int i = 1; i < 10; i++){
            count[i] += count[i-1];
        }
        for(int i = n-1; i >= 0; i--){
            int digit = (arr[i]/exp)%10;
            output[count[digit]-1] = arr[i];
            count[digit]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
    public static void radixSort(int[] arr,int n){
        int max = Integer.MIN_VALUE;
        for(int i : arr) max = Math.max(max,i);
        for(int exp = 1; max/exp > 0; exp*=10)
            countingSort(arr,n,exp);
    }
    public static void main(String[] args) {
        int[] arr = {10,4,5,18,3,6,43};
        radixSort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
