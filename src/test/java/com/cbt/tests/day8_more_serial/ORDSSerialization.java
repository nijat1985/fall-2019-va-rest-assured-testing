package com.cbt.tests.day8_more_serial;

import com.cbt.Utilities.ConfigurationReader;
import com.cbt.pojos.Employee;
import com.cbt.pojos.Link;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ORDSSerialization {
    @BeforeAll
    public static void setup(){
        RestAssured.baseURI = ConfigurationReader.getProperty("ords_base_url");
    }

    @Test
    public void getSteven(){
        Response response = given().
                log().all().
                pathParam("id", 100).
            when().
                get("/employees/{id}").
                prettyPeek();

        Employee emp = response.as(Employee.class);

        System.out.println("emp = " + emp);

        response.then().
                statusCode(200);

        List<Link> links = emp.getLinks();
        System.out.println("links = " + links.get(0).getRel());

    }

    @Test
    public void getAllOfTheEmployees(){
        Response response = given().queryParam("limit",1000).when().get("/employees");
        List<Employee> items = response.jsonPath().getList("items", Employee.class);
        System.out.println("employees = " + items.size());
        System.out.println(items.get(0).getFirstName());
    }


}

//Student
//    String admissionNo
//    int batch
//    String birthDate
//    Company company
//    Contact contact
//    String firstName
//    String gender
//    String joinDate
//    String lastName
//    String major
//    String password
//    String section
//    int studentId
//    String subject
//
//Company
//        Address address
//        int companyId
//        String companyName
//        String startDate
//        String title
//
//Contact
//    int contactId
//    String emailAddress
//    String phone
//    String permanenetAddress
//
//Address
//        int addressId;
//        String street;
//        String city;
//        String state;
//        int zipcode;



