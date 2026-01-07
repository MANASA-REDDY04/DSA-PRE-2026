package Sortings;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    public static void bubbleSort(int[] arr, int n){
        for(int i = n-1; i > 0; i--){
            boolean didSwap = false;
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    didSwap = true;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            if(!didSwap) return;
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
        bubbleSort(arr,n);
        System.out.println("Sorted array: "+Arrays.toString(arr));
    }
}
