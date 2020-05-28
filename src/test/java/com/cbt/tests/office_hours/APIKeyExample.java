package com.cbt.tests.office_hours;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APIKeyExample {
    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "https://www.zipcodeapi.com";
    }

    /*
    get distance between 2 zip codes
    verify status code 200
    verify distance field is not empty
    /rest/:api_key/distance.json/:zip_code1/:zip_code2/:units
     */
    @Test
    public void testDistance(){
        given().log().all().
                pathParam("api_key","tzrViKLgmbJFy1UpzX8EFzxXr63WTg5D4BgDUxWaIeswT8FPXv60qpykag6twfmB").
                pathParam("zip_code1","22031").
                pathParam("zip_code2", "22033").
                pathParam("units","mile").
        when().
                get("/rest/{api_key}/distance.json/{zip_code1}/{zip_code2}/{units}").
        then().
                statusCode(200).
                body("distance",not(emptyOrNullString()));

    }

}
