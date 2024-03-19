package com.example.rest.webservice.restfulwebservice.HelloWorld;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

   private MessageSource messageSource;

    public HelloWorldController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping  ("/hello-world")
    public String getString()
    {
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorld getHelloWorldBean()
    {
        return new HelloWorld("Hello World");
    }

    @GetMapping("/hello-world-path-variable/{name}")
    public HelloWorld helloWorldPathVariable(@PathVariable String name)
    {
        return new HelloWorld("Hello World "+name);
    }

    @GetMapping(value = "/hello-world-internationalized")
    public String helloWorldInternationalized()
    {
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null,"default message",locale);
//        return "Hello World v2";
    }

}
