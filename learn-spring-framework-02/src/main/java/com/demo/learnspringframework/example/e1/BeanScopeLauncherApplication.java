package com.demo.learnspringframework.example.e1;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
class Normal
{

}

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class ProtoTypeClass
{

}

@Configuration
@ComponentScan
public class BeanScopeLauncherApplication {

    public static void main(String[] args) {

        try(var context=new AnnotationConfigApplicationContext(BeanScopeLauncherApplication.class))
        {
            System.out.println("1"+context.getBean(Normal.class));
            System.out.println("2"+context.getBean(Normal.class));

            System.out.println(context.getBean(ProtoTypeClass.class));
            System.out.println(context.getBean(ProtoTypeClass.class));
            System.out.println(context.getBean(ProtoTypeClass.class));

        }
    }

}
