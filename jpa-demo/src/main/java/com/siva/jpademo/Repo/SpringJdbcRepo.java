package com.siva.jpademo.Repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.siva.jpademo.Model.Course;

@Repository
public class SpringJdbcRepo {
    @Autowired
    private JdbcTemplate template;

    //Inserting a single row using defaut query
    public void insert() {
        template.update("INSERT INTO COURSE(ID,NAME,AUTHOR) VALUES(1,'Micoservices','in28Minutes')");
    }

    //Inserting a single row using prepared statements
    private static final String PREPARED_STRING = "INSERT INTO COURSE(ID,NAME,AUTHOR) VALUES(?,?,?)";

    public void insert(Course course) {
        template.update(PREPARED_STRING, course.getId(), course.getName(), course.getAuthor());
    }

    // Select a single row using prepared statement
    private static String SELECT_QUERY = "SELECT * FROM COURSE WHERE ID = ?";

    public Course findById(long id) {
        return template.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }

}
