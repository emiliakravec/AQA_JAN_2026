package org.prog.session18.steps;

import io.cucumber.java.en.Given;
import org.prog.session16.dto.PersonDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;

public class DBSteps {

    public static Connection connection;

    public static final List<String> randomNames = new ArrayList<>();

    @Given("I store these people in DB")
    public void storePeopleInDB() throws SQLException {
        //turn them to java list
        List<PersonDto> persons = ApiSteps.results.getResults();

        //for each element in list -> record to DB
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                        "VALUES (?, ?, ?, ?, ?)");

        for (PersonDto person : persons) {
            preparedStatement.setString(1, person.getName().getFirst());
            preparedStatement.setString(2, person.getName().getLast());
            preparedStatement.setString(3, person.getGender());
            preparedStatement.setString(4, person.getName().getTitle());
            preparedStatement.setString(5, person.getNat());
            try {
                preparedStatement.execute();
            } catch (SQLException e) {
                System.out.println("Failed to insert into DB " + person);
            }
        }
    }

    @Given("I pick {int} random person from DB")
    public void pickRandomPersonFromDB(int amount) throws SQLException {
        Statement stmt = connection.createStatement();
        ResultSet resultSet = stmt.executeQuery("select * from Persons ORDER BY RAND() LIMIT " + amount);

        randomNames.clear();
        while (resultSet.next()) {
            String firstName = resultSet.getString("FirstName");
            String lastName = resultSet.getString("LastName");
            randomNames.add(firstName + " " + lastName);
        }
    }
    public static boolean isPhoneExists(String name) throws SQLException {
        String query = "SELECT COUNT(*) FROM phones WHERE name = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, name);

        ResultSet rs = ps.executeQuery();
        rs.next();

        return rs.getInt(1) > 0;
    }
    public static void insertPhone(String name, String price) throws SQLException {
        String query = "INSERT INTO phones (name, price) VALUES (?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, name);
        ps.setString(2, price);

        ps.executeUpdate();
    }
    public static void checkPrice(String name, String price) throws SQLException {
        String query = "SELECT price FROM phones WHERE name = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, name);

        ResultSet rs = ps.executeQuery();
        rs.next();

        String dbPrice = rs.getString("price");

        Assert.assertEquals(price, dbPrice);
    }
}
