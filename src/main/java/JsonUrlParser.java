import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;

public class JsonUrlParser {
    JSONObject jsonObject;
    public boolean checkPhoto(StringBuilder link){
        String baba = String.valueOf(link);
        jsonObject=new JSONObject(baba);
         return jsonObject.get("status").equals("success");

    }
    public String getUrl(StringBuilder link){
       try {
           JSONObject jsonObject = new JSONObject(link);
           System.out.println(jsonObject);
           String url = (String) jsonObject.getJSONObject("image").get("full_adress");
           System.out.println(url);
           return url;
        } catch (JSONException e) {
           e.printStackTrace();
       }
        return null;
    }
}
