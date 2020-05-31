package com.cbt.tests.day8_more_serial;

import com.cbt.pojos.Characters;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ThatHarryPotterQuestion {
    @Test
    public void getAllNames(){
        RestAssured.baseURI = "https://www.potterapi.com/v1";

        JsonPath jsonPath = given().
                queryParam("key","$2a$10$s8DSvL7pIZx4pTGdYYw8GeG/W/U9AbBCUvK1VJ/d2SX1hr0eM6Rnq").
            when().
                get("/characters").jsonPath();
        List<String> name = jsonPath.getList("name");
        System.out.println("name = " + name.size());
        //map
        List<Map<String,?>> people = jsonPath.getList("");
        System.out.println("people.size() = " + people.size());

        //pojo
        List<Characters> character = jsonPath.getList("");
        System.out.println("character.get(0) = " + character.get(0));
        System.out.println("character.get(0).getName() = " + character.get(0).getName());

    }
}
