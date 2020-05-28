package com.cbt.tests.day2_endpoints_response;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoginInRestAssured {
    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://api.openrates.io";
    }


    @Test
    public void test1(){
        RestAssured.
                given().log().all().
                when().get("latest").
                then().statusCode(200);
    }

    @Test
    public void test2(){
        RestAssured.
                when().get("latest").
                then().log().ifValidationFails().
                statusCode(200);
    }



}
