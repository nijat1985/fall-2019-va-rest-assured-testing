package com.cbt.tests.day3_path_query_params;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class QueryParamsExample {
    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "https://api.exchangeratesapi.io";
    }

    /*
    call the exchangeratesapi with query param base=PHP
     */

    @Test
    public void testPHP(){
        given().
                log().all().
                queryParam("base","PHP").
        when().
                get("/latest").
                prettyPeek().
        then().statusCode(200);
    }

    /*
    get the rates for base currency PHP against USD only
    base = PHP
    symbols
     */

}
