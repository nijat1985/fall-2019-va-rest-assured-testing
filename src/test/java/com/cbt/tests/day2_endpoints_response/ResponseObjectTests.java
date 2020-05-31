package com.cbt.tests.day2_endpoints_response;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ResponseObjectTests {
    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://api.cybertektraining.com/";
    }

    @Test
    public void verifyStudentInfrmation(){
        //response -> represents the response that we get from the server
        Response response = when().get("/student/11721");
        System.out.println(response.statusLine());
        System.out.println(response.statusCode());
        System.out.println(response.header("Content-Type"));
        System.out.println(response.headers());

        response.print();

        //verify status
        response.then().statusCode(200);
        //verify response contains Audrey
        String resString = response.asString();
        assertThat(resString,containsString("Audrey"));
    }

    @Test
    public void verifyTeacherInfromation(){
        Response response = get("/teachers/4712");
        response.prettyPeek();

        assertThat(response.asString(), containsString("Darleen"));
    }

}
