import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Main {
    public static void main(String[] args) throws IOException {
        String folderForImages = "C:\\image\\";//директория скачивания
        String imageAddress="https://micropic.ru/api/view/";
        LinkGeneration linkGeneration = new LinkGeneration();
        GetJson getJson = new GetJson();//Класс достающий информацию каждой фотографии в формате json
        JsonUrlParser jup = new JsonUrlParser(); //Парсер json
        linkGeneration.generateSymbols(); //Генерируем алфавит
        int cnt=1;
        while (true){
            JSONObject jsonObject = getJson.get(imageAddress+linkGeneration.generateLink());
            if(jup.checkPhoto(jsonObject)){
                URL image = new URL(jup.getUrl(jsonObject));
                System.out.println(image+" is being downloaded");
                try (InputStream in = image.openStream()) {
                    Files.copy(in, Paths.get(folderForImages+cnt+".jpg"));
                    System.out.println("Profit");
                }
                cnt++;
            }
        }
        }



}