package com.siva.jpademo.Repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepo {

    private static Connection con;
    private static Statement stmnt;
    static {
        try {
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection("jdbc:h2:mem:testdb", "SA", "");
            stmnt = con.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert() throws SQLException {
        stmnt.executeUpdate("INSERT INTO COURSE(ID,NAME,AUTHOR) VALUES(3,'Standard JDBC','in28Minutes')");
    }
}
