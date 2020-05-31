package com.cbt.tests.review;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import static io.restassured.RestAssured.*;

public class WheatherAPP {

    /*
     Can  you test web service and what will be your steps/ or how you do it?
     Endpoints information: where to connect? api.qa-bank.com or ec2-werq-2131.com/api
     Authentication information/credentials. Types of authentication: basic, oauth, oauth 2.0, api key, etc.
     I need to get an information about this web service, first of all documentation (like swagger).
     In swagger, we can see list of requests, how to perform them and list of status codes that are allowed.
     we need some kind of requirement documents to know what is expected, based on them we write test cases.
     */

    static {
        baseURI = "https://www.metaweather.com/api/location";
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter city name: ");
        String city = scanner.nextLine();
        String woeid = getWOEID(city);
        printWeatherInfo(woeid);
    }

    @Test
    public void test(){
        given().
                log().all().
                queryParam("query","London").
                //header("Accept","application/json").
        when().
                get("https://www.metaweather.com/api/location").prettyPeek();
    }

    public static String getWOEID(String city){
        Response response = given().
                                    queryParam("query", city).
                            when().
                                    get("/search");
        String woeid = response.jsonPath().getString("woeid");

        return woeid;
    }

    public static void printWeatherInfo(String woeid) {
        woeid = woeid.replaceAll("\\D", "");//to delete all non-digits
        Response response = get("{woeid}", woeid);
        List<String> weatherStateName = response.jsonPath().getList("consolidated_weather.weather_state_name");
        List<Float> temp = response.jsonPath().getList("consolidated_weather.the_temp");
        List<String> dates = response.jsonPath().getList("consolidated_weather.applicable_date");
        System.out.println("Here is the weather forecast for this week:");
        for (int i = 0; i < weatherStateName.size(); i++) {
            String date = dates.get(i);
            float tempF = temp.get(i) * 9/5 + 32;
            date = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
            System.out.printf("Date: %s, Weather state: %s, Temperature %.0f F\n", date, weatherStateName.get(i), tempF);
        }
    }
}
