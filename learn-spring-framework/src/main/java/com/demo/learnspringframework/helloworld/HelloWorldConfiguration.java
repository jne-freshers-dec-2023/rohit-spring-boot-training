package com.demo.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name,int age){};

record Address(String city,String State){};

record GetNameAndAge(String name,int age){};

@Configuration
public class HelloWorldConfiguration {

    @Bean(name="name")
    public String name()
    {
        return "Rohit";
    }

    @Bean(name="age")
    public int age()
    {
        return 23;
    }

//    @Bean
//    public GetNameAndAge getNameAge()
//    {
//        return new GetNameAndAge(name(),age());
//    }

    @Bean(name="parameterized")
    public GetNameAndAge getNameAge(@Qualifier("qualifername") String name,int age)
    {
        return new GetNameAndAge(name,age);
    }

    @Bean
    @Primary
    public Person person()
    {
        return new Person("Ravi",12);
    }

    @Bean(name = "address2")
    public Address address()
    {
        return new Address("Pune","maharashtra");
    }

    @Bean(name="name2")
    @Qualifier("qualifername")
    public String name2()
    {
        return "Athrav";
    }

}
