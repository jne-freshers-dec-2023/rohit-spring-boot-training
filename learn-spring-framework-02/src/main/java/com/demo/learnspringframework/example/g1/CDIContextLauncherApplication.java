package com.demo.learnspringframework.example.g1;

import jakarta.persistence.NamedEntityGraph;
import jdk.jfr.Name;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class BusinessService
{
    private DataService dataService;

//    @Autowired
//    public BusinessService(DataService dataService) {
//        this.dataService = dataService;
//    }

    public DataService getDataService() {
        return dataService;
    }

    @Autowired
    public void setDataService(DataService dataService) {
        System.out.println("Setter injection");
        this.dataService = dataService;
    }
}

@Component
class DataService
{

}

@Configuration
@ComponentScan
public class CDIContextLauncherApplication {
    public static void main(String[] args) {

        try(var context=new AnnotationConfigApplicationContext(CDIContextLauncherApplication.class))
        {
//            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
            System.out.println(context.getBean(BusinessService.class).getDataService());
        }
    }
}
