package com.cbt.tests.day5_authontication_authorization;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class TokenBasedAuthentication {
    /*
    Authentication —> Do I have right username/password?  Do I have right login credentials. Who are you?
If we try use any api without authentication we get status code 401 Not authorized. It means we did not provide valid credentials
Authorization —> it comes after authentication. It means do I have right use user specific endpoint. What rights do you have?
When we have right authentication but do not have permission to make certain request, we get 403 Forbidden
There are different types of authentication we can do using rest assured.
Basic authentication
This is logging in using username/password. There are 2 types of basic auth.
    Preemptive: in preemptive authentication, rest will send the username/password first in one request. Once authenticated,
    It will send the second request with our query.
    Challenged: rest will send username/password together with the request.
API key
    it is type of authentication we send a secret key in as part of the query. It can be in the header or as a query parameter.
    This information can be found in the api documentation. We usually need to sign up for the api key.
Form based authentication
    it is practically username/password authentication.
    In order to authenticate using form based authentication we need pass the username password in the form parameters.
Token based authentication
In token based authentication, to login and use any web service, we first ask the server to give us a token that recognizes us.
Then we take the token and show it the api.

oauth1/oauth2
We can use 3rd party tools to be get authenticated. Many websites we can login using google accounts, Facebook etc. we login canvas using okta.
—-
Ssl certificates

     */

    @BeforeAll
    public static void setUp(){
        RestAssured.baseURI = "http://library2.cybertekschool.com/rest/v1";
    }

    @Test
    public void tokenAuthentication(){

        //get token from the login method
        String token = given().
                log().all().
                formParam("email", "librarian16@library").
                formParam("password", "8BzUhhaU").
        when().post("/login").jsonPath().getString("token");


        //use the token to get all book categories
        given().
                header("x-library-token",token).
                log().all().
        when().
                get("/get_book_categories").
                prettyPeek().
        then().statusCode(200);
    }

    /*
    get token as student
    add a new book
    verify status code is 403
     */
    @Test
    public void getTokenAddBook(){
        String token = given().
                formParam("email", "student27@library").  //librarian16@library
                formParam("password", "kkMksO2i").  //8BzUhhaU
        when().
                post("/login").
                jsonPath().getString("token");
        System.out.println("token = " + token);

        given().
                header("x-library-token",token).
        when().
                post("/add_book").
                prettyPeek().
        then().statusCode(403);

    }

    //this token is temporary. After sometime this code may not work
    @Test
    public void oauth2(){
        given().
                auth().oauth2("06d395e2eabddd0ab67e7573b65fe640c469226f").
        when().
                get("https://api.github.com/repos/marufjont/secret-repository").
                prettyPeek().
        then().statusCode(200);
    }

}
