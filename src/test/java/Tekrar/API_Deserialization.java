package Tekrar;

import baseURLDeposu.JsonPlaceHolderBaseURL;
import io.restassured.http.ContentType;
import org.junit.Test;
import testDataDeposu.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class API_Deserialization<Response> extends JsonPlaceHolderBaseURL {

    @Test
    public void test01(){

        /*
        https://jsonplaceholder.typicode.com/posts/70
         */

        // 1- URL ve request body olustur

        specJsonPlace.pathParam("pp1", 70);

        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();

        Map<String,Override> reqBodyMap = jsonPlaceHolderTestData.requestBodyMapOlustur();

        System.out.println(reqBodyMap);

        // 2- Expected Data Olustur

        Map<String,Object> expDataMap = jsonPlaceHolderTestData.requestBodyMapOlustur();

        // 3- Response kaydet



    }
}
