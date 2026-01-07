package Sortings;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void selectionSort(int[] arr,int n){
        for(int i = 0; i < n-1; i++){
            int min = i;
            for(int j = i+1; j < n; j++){
                if(arr[j] < arr[min]) min = j;
            }
            if(min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
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
        selectionSort(arr,n);
        System.out.println("Sorted array: "+ Arrays.toString(arr));
    }
}
