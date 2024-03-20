package com.demo.mockito.mokitodemo.business;

import org.springframework.beans.factory.annotation.Autowired;

public class SomeBusinessImp{


    private  DataService dataService;

    public SomeBusinessImp(DataService dataService)
    {
        super();
        this.dataService=dataService;
    }

    public int  findTheGreatestFromAll()
    {
        int [] data=dataService.retrieveAllData();
        int greatestValue=Integer.MIN_VALUE;
        for(int num:data)
        {
            if(num>greatestValue)
            {
                greatestValue=num;
            }
        }
        return greatestValue;
    }
}