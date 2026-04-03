package org.prog.session17;

import org.testng.annotations.*;
import java.sql.*;

public class HomeWork17 {

    private Connection conn;

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db",
                "root",
                "Password123"
        );
    }

    @AfterSuite
    public void afterSuite() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    @Test
    public void testSelect() throws SQLException {
        Statement stmt = conn.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from Persons");

        while (resultSet.next()) {
            String firstName = resultSet.getString("FirstName");
            String lastName = resultSet.getString("LastName");
            String title = resultSet.getString("Title");

            System.out.println(title + " " + firstName + " " + lastName);
        }
    }
}
