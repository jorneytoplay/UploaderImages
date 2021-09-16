import org.json.JSONObject;

import java.io.*;

public class JsonUrlParser {

    String jsonURL = "C:\\Users\\71376160\\IdeaProjects\\UploaderImages\\src\\main\\resources\\link.json";
    public void writeFile(StringBuilder sb){
        try {
            FileWriter fw = new FileWriter(jsonURL);
            fw.write(String.valueOf(sb));
            fw.flush();
        }  catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getUrl(){
        try {
            FileReader fr = new FileReader(jsonURL);
         //   String mama = fr.toString();
         //   System.out.println(mama);
         //   JSONObject jsonObject = new JSONObject(jsonURL);
         //   System.out.println(jsonObject);
         //   String url = (String) jsonObject.get("full_adress");
         //   System.out.println(url);
         //   return url;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
