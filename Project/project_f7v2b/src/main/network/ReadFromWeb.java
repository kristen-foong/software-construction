package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

// taken from Deliverable 10 ReadFromWebEx
//shamelessly quoting from: http://zetcode.com/articles/javareadwebpage/

public class ReadFromWeb {

    public ReadFromWeb() throws MalformedURLException, IOException {
        BufferedReader br = null;
        try {
            String key = "2a6d16aade3b8b3c173d48ac0217bc57";
            key = "QXFRMFZmRmNPTlZHbUxvNkVyWFZEQT09";
            String link = "https://api.openweathermap.org/data/2.5/weather?q=Vancouver,ca&APPID=";
//            link = "https://trefle.io/some-url?token=";
            String theURL = link + key; //this can point to any URL
            theURL = "https://trefle.io";
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
            System.out.println(sb);
        } finally {
            if (br != null) {
                br.close();
            }
        }
    }
}
