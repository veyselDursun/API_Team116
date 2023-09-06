package testDataDeposu;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    public int basariliStatusKod = 200;

    public JSONObject expectedDataOlusur(){

        JSONObject body = new JSONObject();
        body.put("userId",3);
        body.put("id",22);
        body.put("title","dolor sint quo a velit explicabo quia nam");
        body.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

return body;
    }

    public Map requestBodyMapOlustur() {
        Map<String,Object> requestBodyMap = new HashMap<>();
        requestBodyMap.put("title", "Ahmet");
        requestBodyMap.put("body", "Merhaba");
        requestBodyMap.put("userId", 10);
        requestBodyMap.put("id", 70);


        return requestBodyMap;
    }

}
