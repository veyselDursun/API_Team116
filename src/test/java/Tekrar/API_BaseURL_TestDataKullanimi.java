package Tekrar;

import baseURLDeposu.JsonPlaceHolderBaseURL;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testDataDeposu.JsonPlaceHolderTestData;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class API_BaseURL_TestDataKullanimi extends JsonPlaceHolderBaseURL {


    @Test
    public void test01(){
        // 1- URL ve request Body olustur
        specJsonPlace.pathParam("pp1" , "22");

        // 2-Expected Data olustur
        JsonPlaceHolderTestData jsonPlaceHolder = new JsonPlaceHolderTestData();
        JSONObject expBody = jsonPlaceHolder.expectedDataOlusur();

       // 3-Response kaydet
        Response response = given().spec(specJsonPlace).when().get("{pp1}");

        // 4-Assertion
        JsonPath respJSPath = response.jsonPath();

        //Assert.assertEquals(jsonPlaceHolder.basariliStatusKod,response.getStatusCode());

        assertEquals(jsonPlaceHolder.basariliStatusKod,response.getStatusCode());

        assertEquals(expBody.getInt("userId"),respJSPath.getInt("userId"));
        assertEquals(expBody.getInt("id"),respJSPath.getInt("id"));
        assertEquals(expBody.getString("title"),respJSPath.getString("title"));
        assertEquals(expBody.getString("body"),respJSPath.getString("body"));


    }
}
