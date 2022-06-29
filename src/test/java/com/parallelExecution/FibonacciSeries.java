package com.parallelExecution;

public class FibonacciSeries {
    public static void main(String[] args) {
        int n1=0;
        int n2=1;
        int n3;
        for(int i=2;i<=10;i++){
            n3=n1+n2;
            n1=n2;
            n2=n3;
            System.out.println(n3);
        }

    }
}
