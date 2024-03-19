package com.demo.learnspringframework.example.c1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {

    private DataService dataService;


    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax()
    {
        return Arrays.stream(dataService.retriveData()).max().orElse(0);
    }
}
