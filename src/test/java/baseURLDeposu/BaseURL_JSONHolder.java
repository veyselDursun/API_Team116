package baseURLDeposu;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class BaseURL_JSONHolder {

    // BaseURL olustururken RequestSpecification interface inden bir specobje olusturduk

    protected RequestSpecification specJSONHolder;

    @Before
    public void setUP(){

         specJSONHolder = new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com").
                build();

    }

}
