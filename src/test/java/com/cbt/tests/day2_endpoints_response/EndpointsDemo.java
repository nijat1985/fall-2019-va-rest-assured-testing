package com.cbt.tests.day2_endpoints_response;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class EndpointsDemo {
    //FULL URL --> http://api.openrates.io/latest
    //BASE --> http://api.openrates.io
    //endpoint --> /latest

    //rest assured will add the base to the path to create the final url

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://api.openrates.io";
    }

    @Test
    public void getLatest(){
        RestAssured.
                when().get("/latest").prettyPeek().
                then().statusCode(200);
    }


    @Test
    public void getHistoricRate(){
        RestAssured.given().
                when().get("/2000-01-03").prettyPeek().
                then().statusCode(200);
    }

}
