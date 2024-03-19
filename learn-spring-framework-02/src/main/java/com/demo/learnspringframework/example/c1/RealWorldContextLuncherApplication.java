package com.demo.learnspringframework.example.c1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan
public class RealWorldContextLuncherApplication {

    public static void main(String[] args) {

        try(var context=new AnnotationConfigApplicationContext(RealWorldContextLuncherApplication.class))
        {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            System.out.println(context.getBean(BusinessCalculationService.class).findMax());

        }
    }
}
