package com.cbt.tests.day3_path_query_params;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GitHubTests {
    /*
    * get user from github from /users/:username
    * base url https://api.github.com
    * */

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "https://api.github.com";
    }

    /*
    * get github info for selimpcf
    * */

    @Test
    public void testselimpcf(){
        given().
                log().all().
                pathParam("username", "selimpcf").
        when().
                get("/users/{username}").
                prettyPeek().
        then().statusCode(200);
    }


    /*
    *
    * same test but for scarlet
    * */

    @Test
    public void testScarlet(){
        //some api's accept more than one parameters. In this case we create a map and use pathParams() method and pass map inside ()
        Map<String, String> params = new HashMap<>();
        params.put("username", "scarlet");
        given().
                log().all().
                pathParams(params).
        when().
                get("/users/{username}").
                prettyPeek().
        then().statusCode(200);
    }

    /*
    how to provide multiple path params
    1. param
    2. params
     */

    @Test
    public void paramsExample(){
        //1. param
        given().
                log().all().
                pathParam("endpoint", "users").
                pathParam("username", "marufjont").
        when().
                get("{endpoint}/{username}").
                prettyPeek().
        then().statusCode(200);

        //2. params
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put("username", "marufjont");
        pathParams.put("endpoint", "users");

        given().
                log().all().
                pathParams(pathParams).
        when().get("{endpoint}/{username}").
                prettyPeek().
        then().statusCode(200);
    }


}
