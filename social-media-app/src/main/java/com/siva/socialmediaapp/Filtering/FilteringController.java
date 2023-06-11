package com.siva.socialmediaapp.Filtering;

import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

    @GetMapping("/static/filter")
    public StaticFilteringBean getBean() {
        return new StaticFilteringBean("F1", "F2", "F3");
    }

    @GetMapping("static-list/filter")
    public List<StaticFilteringBean> getListOfBeans() {
        return List.of(new StaticFilteringBean("F1", "F2", "F3"),
                new StaticFilteringBean("F4", "F5", "F6"));
    }

    @GetMapping("/dynamic/filter-1")
    public MappingJacksonValue getDynamicFilteredBean() {
        DynamicFilterBean bean = new DynamicFilterBean("F1", "F2", "F3");
        return filter1Logic(bean);
    }

    private MappingJacksonValue filter1Logic(DynamicFilterBean bean) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(bean);
        SimpleBeanPropertyFilter filterOutAllExcept = SimpleBeanPropertyFilter.serializeAllExcept("field1");
        FilterProvider simpleFilter = new SimpleFilterProvider().addFilter("DynamicFilter", filterOutAllExcept);
        mappingJacksonValue.setFilters(simpleFilter);
        return mappingJacksonValue;
    }
}
