package Sortings;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort(int[] arr,int n){
        for(int i = 1; i < n; i++){
            int j = i-1;
            int ele = arr[i];
            while (j >= 0 && arr[j] > ele){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = ele;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Enter "+n+" elements: ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        insertionSort(arr,n);
        System.out.println("Sorted array: "+ Arrays.toString(arr));
    }
}
