package Sortings;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high){
        if(low >= high) return;
        int pIndex = partition(arr,low,high);
        quickSort(arr,low,pIndex-1);
        quickSort(arr,pIndex+1,high);
    }
    public static int partition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;
        while (i < j){
            while (i <= high-1 && arr[i] <= pivot) i++;
            while (j >= low+1 && arr[j] > pivot) j--;
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        System.out.println("low: "+arr[low]+" pivot: "+pivot);
        System.out.println("i: "+i+ " j: "+j);
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter "+n+" elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        quickSort(arr,0,n-1);
        System.out.println("Sorted array: "+ Arrays.toString(arr));
    }
}
