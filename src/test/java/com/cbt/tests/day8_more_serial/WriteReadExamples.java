package com.cbt.tests.day8_more_serial;

import com.cbt.pojos.Donut;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteReadExamples {

    /*
    Gson --> library to serialize and de serialize
    GsonBuilder --> class that helps create Gson object with different options
    FileWriter --> write to the physical file
     */

    @Test
    public void writeToJsonFile() throws IOException {
        Donut donut = new Donut("cake donut", 12, true);
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        System.out.println("donut = " + donut);

        FileWriter fileWriter = new FileWriter("src/test/resources/new_donut.json");
        gson.toJson(donut,fileWriter);
        fileWriter.flush();
        fileWriter.close();
    }


    @Test
    public void readFromJsonFile() throws IOException {
        //read from file
        FileReader fileReader = new FileReader("src/test/resources/old_donut.json");

        //convert to object using gson
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

        Donut donut = gson.fromJson(fileReader,Donut.class);
        System.out.println("donut = " + donut);

        fileReader.close();
    }


    /*
    CUSTOM MAPPER EXAMPLE FOR REST ASSURED
    this is how you can coonfigure your rest assured to use Gson with
    excludeFieldsWithoutExposeAnnotation
     ObjectMapperConfig config = new ObjectMapperConfig(ObjectMapperType.GSON)
                .gsonObjectMapperFactory(
                        (type, s) -> new GsonBuilder()
                                .excludeFieldsWithoutExposeAnnotation()
                                .create());
        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(config);
        Response response = get("/student/{id}", 11613);
        // assume we have student pojo with @expose annotation
        Student student = response.jsonPath().getObject("students[0]", Student.class);
        System.out.println(student);
     */


}
