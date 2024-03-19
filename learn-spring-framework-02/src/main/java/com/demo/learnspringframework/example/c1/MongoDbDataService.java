package com.demo.learnspringframework.example.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDbDataService implements DataService{

    public int[] retriveData()
    {
        return new int[] {11,21,45,654,65,75};
    }

}
