package com.codegaju;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Connect {
    private final String url = "jdbc:postgresql://localhost:5432/StudentManagementSystem";
    private final String user = "postgres";
    private final  String password = "esrsu";

    Connection connect() throws SQLException {
        return DriverManager.getConnection(url , user , password);

    }

    public abstract void create(Student stud);
}
