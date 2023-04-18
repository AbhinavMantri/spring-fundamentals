package com.mysocial.chat.filtering;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
    @GetMapping(path = "/filtering")
    public MappingJacksonValue filtering() {
        SomeBean beanx = new SomeBean("A", "B", "C");

        MappingJacksonValue mappingValue = new MappingJacksonValue(beanx);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1");

        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        mappingValue.setFilters(filters);
        
        return mappingValue;
    }

    @GetMapping(path = "/filtering/list")
    public List<SomeBean> filteringList() {
        return new ArrayList<SomeBean>(List.of(
            new SomeBean("A", "B", "C"),
            new SomeBean("filed1", "fieldB", "fieldC")
        ));
    }
}
