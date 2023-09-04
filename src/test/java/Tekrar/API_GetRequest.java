package Tekrar;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class API_GetRequest {


    @Test

    public void get01(){

        // 1- Request URL ve BODY olustur
        String url="ttps://jsonplaceholder.typicode.com/posts/44";

        // 2- Expected Data olustur
        JSONObject expentedBody = new JSONObject();
        expentedBody.put("userId",5);
        expentedBody.put("title","optio dolor molestias sit");

        // 3- Responsu kaydet
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- Assertion
        response.then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON);

        JsonPath actualBody = response.jsonPath();
        Assert.assertEquals(expentedBody.get("userId"),actualBody.get("userId"));
        Assert.assertEquals(expentedBody.get("title"),actualBody.get("title"));
    }
}
