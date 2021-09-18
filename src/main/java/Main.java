import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


public class Main {
    public static void main(String[] args) throws IOException {
        String urlAddress="https://micropic.ru";
        String imageAddress="https://micropic.ru/api/view/";
        LinkGeneration linkGeneration = new LinkGeneration();
        URL url;
        HttpURLConnection httpURLConnection;
        InputStreamReader in = null;
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        JsonUrlParser jup = new JsonUrlParser();
        linkGeneration.generateSymbols(); //Генерируем алфавит
        try {
            while (true){
                url=new URL(imageAddress+linkGeneration.generateLink());
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

              //  httpURLConnection.setConnectTimeout(200);
              //  httpURLConnection.setReadTimeout(200);
                httpURLConnection.connect();
                if(HttpURLConnection.HTTP_OK == httpURLConnection.getResponseCode()){
                    in = new InputStreamReader(httpURLConnection.getInputStream());
                    br = new BufferedReader(in);
                    String line;
                    while ((line=br.readLine())!=null){
                        sb.append(line);
                    }
                }
                if(jup.checkPhoto(sb)){
                    jup.getUrl(sb);
                }
            }


            //jup.getUrl();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            in.close();
            br.close();

        }
    }


}