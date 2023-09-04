package Tekrar;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_PostRequest {


    @Test
    public void post01(){

        // 1- Request URL ve BODY olustur
        String url="https://jsonplaceholder.typicode.com/posts";
        JSONObject regBody = new JSONObject();

        regBody.put("title", "API");
        regBody.put("body", "API ögrenmek ne güzel");
        regBody.put("userId", 10);

        // 2- Expected Data olustur
        JSONObject expBody = new JSONObject();

        expBody.put("title", "API");
        expBody.put("body", "API ögrenmek ne güzel");
        expBody.put("userId", 10);

        // 3- Responsu kaydet
        Response response = given().
                contentType(ContentType.JSON).
                when().
                body(regBody.toString()).
                post(url);

        JsonPath actBody = response.jsonPath();

        // 4- Assertion

        response.
                then().
                assertThat().
                contentType(ContentType.JSON).
                statusCode(201);


        Assert.assertEquals(expBody.get("title"),actBody.get("title"));
        Assert.assertEquals(expBody.get("body"),actBody.get("body"));
        Assert.assertEquals(expBody.get("userId"),actBody.get("userId"));









    }
}
