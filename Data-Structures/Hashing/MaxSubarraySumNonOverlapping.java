package Hashing;

import java.util.Arrays;

public class MaxSubarraySumNonOverlapping {
    public static int maxSubarraySumNonOverlapping(int[] arr, int n){
        int ans = 0;

        int[] prefixMaxSum = calculatePrefixMax(arr,n);
        int[] suffixMaxSum = calculateSuffixMax(arr,n);

//        int[] prefixBest = new int[n];
//        prefixBest[0] = prefixMaxSum[0];
//        for(int i=1; i < n; i++){
//            prefixBest[i] = Math.max(prefixBest[i-1],prefixMaxSum[i]);
//        }
//
//        int[] suffixBest = new int[n];
//        suffixBest[n-1] = suffixMaxSum[n-1];
//        for(int i = n-2; i >= 0; i--){
//            suffixBest[i] = Math.max(suffixBest[i+1],suffixMaxSum[i]);
//        }
        System.out.println("Prefix sum max: "+Arrays.toString(prefixMaxSum));
        System.out.println("Suffix sum max: "+Arrays.toString(suffixMaxSum));
//        System.out.println("Prefix sum best: "+Arrays.toString(prefixBest));
//        System.out.println("Suffix sum best: "+Arrays.toString(suffixBest));
        for(int i = 0; i < n-1; i++){
            ans = Math.max(prefixMaxSum[i]+suffixMaxSum[i+1],ans);
        }
        return ans;
    }
    public static int[] calculatePrefixMax(int[] arr,int n){
        int[] prefixMaxSum = new int[n];
        int curr = arr[0];
        prefixMaxSum[0] = arr[0];
        for(int i = 1; i < n; i++){
            curr = Math.max(arr[i],curr+arr[i]);
            prefixMaxSum[i] = Math.max(prefixMaxSum[i-1],curr);
        }
        return prefixMaxSum;
    }
    public static int[] calculateSuffixMax(int[] arr,int n){
        int[] suffixMaxSum = new int[n];
        int curr = arr[n-1];
        suffixMaxSum[n-1] = arr[n-1];
        for(int i = n-2; i >= 0; i--){
            curr = Math.max(curr+arr[i],arr[i]);
            suffixMaxSum[i] = Math.max(suffixMaxSum[i+1],curr);
        }
        return suffixMaxSum;
    }

    public static void main(String[] args) {
        int[] arr = {3, -2, 5, -1, 6, -3, 2, 7};
        System.out.println(maxSubarraySumNonOverlapping(arr,arr.length));
    }
}
