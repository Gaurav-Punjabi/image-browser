/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BackEnd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gauravpunjabi
 */
public class HtmlHandler {
    private static String linkPattern = "<link.*href=\"([\\w\\-\\d\\.:/_]*)\"\\s*/>";
    public ArrayList<URL> getImages(String key) {
        ArrayList<URL> images = null;
        try {
            images = new ArrayList<>();
            int count = 0;
            URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=" + key);
            URLConnection connection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            Pattern pattern = Pattern.compile(linkPattern);
            while((line = bufferedReader.readLine()) != null && count < 9) {
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()) {
                    String link = matcher.group(1);
                    if(link.matches(".*\\.jpg")) {
                        try {
                            images.add(new URL(link));
                            count++;
                        } catch(MalformedURLException murle) {
                            System.out.println("murle.getMessage() = " + murle.getMessage());
                        }
                    }
                }
            }
        } catch(MalformedURLException murle) {
            System.out.println("murle.getMessage() = " + murle.getMessage());
        } catch(Exception e) {
            System.out.println("Some exception caught. " + e.getMessage());
        }
        return images;
    }
    public static void main(String[] args) {
        new HtmlHandler().getImages("nature");
//        System.out.println(Pattern.compile("<link.*href=\"([\\w\\-\\d\\.:/_]*)\"\\s*/>").matcher("<link rel=\"enclosure\" type=\"image/jpeg\" href=\"https://farm1.staticflickr.com/981/40476847940_fb8e83a566_b.jpg\" />").find());
    }
}
