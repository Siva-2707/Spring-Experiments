package com.siva.socialmediaapp.Filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StaticFilteringBean {
    private String field1;
    @JsonIgnore
    private String field2;
    private String field3;
}
