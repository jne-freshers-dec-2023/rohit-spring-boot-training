package com.demo.learnspringframework.example.f1;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class SomeClass
{
    private SomeDependancy someDependancy;

    public SomeClass(SomeDependancy someDependancy) {
        this.someDependancy = someDependancy;
        System.out.println("All Dependancy Added");
    }

    @PostConstruct
    public void postConstructs()
    {
        someDependancy.someDependancym1();
    }

    @PreDestroy
    public void cleanUp()
    {
        System.out.println("Do Something before Application is terminated");
    }


}

@Component
class SomeDependancy
{
    public void someDependancym1()
    {
        System.out.println("From Some Dependancy");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {

    public static void main(String[] args) {
        try(var context=new AnnotationConfigApplicationContext(PrePostAnnotationContextLauncherApplication.class))
        {

            System.out.println(context.getBean(SomeClass.class));
        }
    }
}
