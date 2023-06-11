package com.siva.socialmediaapp.Bean;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Entity
public class Post {
    @Id
    @SequenceGenerator(name = "POST_SEQ", initialValue = 104)
    @GeneratedValue(generator = "POST_SEQ")
    private Integer id;
    @Size(min = 5, max = 65)
    @NotBlank(message = "Description should not be blank")
    private String desc;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
