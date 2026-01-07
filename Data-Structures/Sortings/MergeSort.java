package Sortings;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void merge(int[] arr, int low, int mid, int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= high){
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                k++; i++;
            }else{
                temp[k] = arr[j];
                k++; j++;
            }
        }
        while (i <= mid){
            temp[k] = arr[i];
            k++; i++;
        }
        while (j <= high){
            temp[k] = arr[j];
            k++; j++;
        }
        for(int x = low; x <= high; x++){
            arr[x] = temp[x-low];
        }
    }
    public static void mergeSort(int[] arr, int low, int high){
        if(low >= high) return;
        int mid = (low+high)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter "+n+" elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        mergeSort(arr,0,n-1);
        System.out.println("Sorted array: "+ Arrays.toString(arr));
    }
}
