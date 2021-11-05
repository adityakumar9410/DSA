package com.aditya.array;

import java.util.*;

public class PairSum {
    public static List<List<Integer>>pairSum(int[] arr, int sum){
        Set<Integer>trackSet=new HashSet<>();
        List<List<Integer>>allPair=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            int target= sum-arr[i];
            if(trackSet.contains(target)){
                allPair.add(Arrays.asList(Math.min(arr[i],target), Math.max(arr[i], target)));
            }else {
                trackSet.add(arr[i]);
            }
        }
        return allPair;
    }
    public static void main(String[] args) {
        int[]arr={1,3,2,2};
        System.out.println(pairSum(arr,4));
    }
}
