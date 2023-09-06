package API_Testing;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C16_Get_SoftAssertIleExpectedDataTesti {

    /*
          C16_Get_SoftAssertIleExpectedDataTesti
      http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request gonderdigimizde
      donen response’un asagidaki gibi oldugunu test edin.

      Response Body
      {
      "status": "success",
      "data": {
            "id": 3,
            "employee_name": "Ashton Cox",
            "employee_salary": 86000,
            "employee_age": 66,
            "profile_image": ""
            },
      "message": "Successfully! Record has been fetched."
      }
     */


    @Test
    public void softTest01(){

        // 1- EndPoint Hazilama

        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        // 2- Expected Data Hazirlama

        JSONObject data = new JSONObject();
        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        JSONObject expData = new JSONObject();
        expData.put("status","success");
        expData.put("data",data);
        expData.put("message","Successfully! Record has been fetched.");

        // 3-Response kayit

        Response response = given().when().get(url);

        // 4-Assertion

        SoftAssert softassert = new SoftAssert();
        JsonPath resJP = response.jsonPath();

        // Soft assert isleminde kosul siralamasi (actual,expected)

        softassert.assertEquals(resJP.get("status"),expData.get("status"));
        softassert.assertEquals(resJP.get("message"),expData.get("message"));
        softassert.assertEquals(resJP.get("data.id"),expData.getJSONObject("data").get("id"));
        softassert.assertEquals(resJP.get("data.id"),expData.getJSONObject("data").get("employee_name"));
        softassert.assertEquals(resJP.get("data.id"),expData.getJSONObject("data").get("employee_salary"));
        softassert.assertEquals(resJP.get("data.id"),expData.getJSONObject("data").get("employee_age"));
        softassert.assertEquals(resJP.get("data.id"),expData.getJSONObject("data").get("profile_image"));


        //softassert.assertAll();



    }

}
