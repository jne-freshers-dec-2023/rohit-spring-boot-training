package com.demo.learnspringframework.example.c1;

import org.springframework.stereotype.Component;

@Component
public class MySQLDataService implements DataService{
    public int[] retriveData()
    {
        return new int[] {1,2,3,4,5,6,7};

    }
}
