package API_Testing;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C3_APISorgulamaTesti {

        /*
        https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
    gonderdigimizde donen Response’un,

    status code’unun 200,
    content type’inin application/json;
    charset=utf-8,
    Server isimli Header’in degerinin Cowboy,
    status Line’in HTTP/1.1 200 OK

    oldugunu test edin....
         */

    @Test
    public void getAssert(){
        String url="https://restful-booker.herokuapp.com/booking/83";
        Response response = given().when().get(url);
        response.
                then().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                statusLine("HTTP/1.1 200 OK");

    }
}
