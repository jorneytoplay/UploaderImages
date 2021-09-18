import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class GetJson {
    JSONObject get(String url){
        JSONObject json = null;
        try {
            InputStream in = new URL(url).openStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(in, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            json = new JSONObject(jsonText);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
    }

