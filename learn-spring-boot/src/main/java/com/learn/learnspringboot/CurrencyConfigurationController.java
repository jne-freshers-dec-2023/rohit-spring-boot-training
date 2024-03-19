package com.learn.learnspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

    @Autowired
    CurrencyServiceConfiguration currencyServiceConfiguration;

    @GetMapping("/currency-service")
     public CurrencyServiceConfiguration retrive()
     {
         return currencyServiceConfiguration;

     }
}
