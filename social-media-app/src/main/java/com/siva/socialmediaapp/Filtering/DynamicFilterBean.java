package com.siva.socialmediaapp.Filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonFilter("DynamicFilter")
public class DynamicFilterBean {
    private String field1;
    private String field2;
    private String field3;
}
