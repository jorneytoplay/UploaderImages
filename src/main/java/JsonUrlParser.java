import org.json.JSONException;
import org.json.JSONObject;



public class JsonUrlParser {
    public boolean checkPhoto(JSONObject jsonObject){
        boolean havePhoto = jsonObject.get("status").equals("success");
         return havePhoto;

    }
    public String getUrl(JSONObject jsonObject){
       try {
           String url = (String) jsonObject.getJSONObject("image").get("full_adress");
           return url;
        } catch (JSONException e) {
           e.printStackTrace();
       }
        return null;
    }
}
