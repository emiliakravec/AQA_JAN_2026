package org.prog.session16;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeWork16R {

    @Test
    public void getUserTest() {

        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users/1");

        System.out.println(response.getBody().asString());

        Assert.assertEquals(response.statusCode(), 200);
    }
}