package com.siva.starterdemo.Configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.siva.starterdemo.Model.Player;

@Configuration
@ConfigurationProperties(prefix = "com.siva.player")
public class PlayerDefaultConfiguration {

    private String name;
    private int age;
    private String description;

    @Bean
    public Player getPlayer() {
        return new Player(name, age, description);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
