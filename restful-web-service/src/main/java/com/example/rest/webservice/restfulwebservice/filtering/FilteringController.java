package com.example.rest.webservice.restfulwebservice.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {


    //dynamic filtering for perticular api
    @GetMapping("/fields")
    public MappingJacksonValue filtering()
    {
        SomeBean someBean =new SomeBean("value1","value2","value3");
        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(someBean);
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filterProvider=new SimpleFilterProvider().addFilter("filtersomebean",filter);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    @GetMapping("/listField")
    public MappingJacksonValue filteringList()
    {
        List<SomeBean> someBeans=Arrays.asList(new SomeBean("field3","field4","field5"),
                new SomeBean("field5","field6","field7"));

        MappingJacksonValue mappingJacksonValue=new MappingJacksonValue(someBeans);
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("field1");
        FilterProvider filterProvider=new SimpleFilterProvider().addFilter("filtersomebean",filter);
        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }
}
