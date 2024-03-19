package com.demo.learnspringframework.helloworld;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

    public static void main(String[] args) {
        try(var context=new AnnotationConfigApplicationContext(HelloWorldConfiguration.class))
        {
            System.out.println(context.getBean("name"));

            System.out.println(context.getBean("age"));

            System.out.println(context.getBean("person"));

            System.out.println(context.getBean("address2"));

            System.out.println(context.getBean(Address.class));

//      System.out.println(context.getBean("getNameAge"));

            System.out.println(context.getBean("parameterized"));

            //get all bean managed by spring framework

//       Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        }


    }
}
