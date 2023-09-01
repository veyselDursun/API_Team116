package API_Testing;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C6_Put_ResponseBilgilerAssertion {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url’ine asagidaki Json formatindaki body ile
    bir PUT request gonderdigimizde
    {
    “title”: “Ahmet”,
    “body”: “Merhaba”,
    “userId”: 10,
    “id”: 70
    }
    donen Response’un,
    status code’unun 200,
    ve content type’inin application/json; charset=utf-8,
    ve Server isimli Header’in degerinin cloudflare,
    ve status Line’in HTTP/1.1 200 OK
     */
    @Test
    public void put01(){

        // 1- Endpoint ve RegquestBody hazirlama
        String url = "https://jsonplaceholder.typicode.com/posts/70";
        JSONObject regBody = new JSONObject();
        regBody.put("title", "Ahmet");
        regBody.put("body", "Merhaba");
        regBody.put("userId", 10);
        regBody.put("id", 70);

        // 2- Expected Data hazirlama
        // (istenmemis)
        // 3- Response Kaydetme
        // NOT:Sorgumuzda eger bir request body gönderiyorsak, datanin formatini belrtmemiz gerekir.
        // bunu response objesindeki given metodundan hemen sonra pr-condition olarak girmeliyiz

        Response response = given().
                                   contentType(ContentType.JSON).
                            when().
                                   body(regBody.toString()).put(url);

        // regBody obje oldugu icin toString ile yaziya donusturduk


        response.prettyPrint(); // gonderdigimiz requestin response ni yazdiriyor

        // 4- Assertion Islemi
        response.
                then().
                assertThat().
                statusCode(200).
                contentType("application/json; charset=utf-8").
                header("Server","cloudflare").
                statusLine("HTTP/1.1 200 OK");

    }
}
