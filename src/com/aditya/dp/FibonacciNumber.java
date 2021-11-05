package com.aditya.dp;

public class FibonacciNumber {
    public  static int findNthFibonacciNumber(int n){
        int [] table = new int[n+1];
        if(n<1){
            throw new IllegalArgumentException();
        }
        table[1]=0;
        table[2]=1;
        for(int i=3;i<=n;i++){
            table[i]=table[i-1]+table[i-2];
        }
        return table[n];
    }

    public static void main(String[] args) {
        System.out.println("Nth fib number is : "+findNthFibonacciNumber(5));
    }
}
