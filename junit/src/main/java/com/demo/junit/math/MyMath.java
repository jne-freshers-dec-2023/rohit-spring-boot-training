package com.demo.junit.math;

public class MyMath {

    public int calculateSum(int [] number)
    {
        int sum=0;

        for(int num:number)
        {
            sum+=num;
        }
        return sum;
    }
}
