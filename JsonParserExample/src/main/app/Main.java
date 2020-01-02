package app;

import org.json.JSONException;
import parser.LibraryParser;
import java.io.*;

/**
 * Simple demo application.
 */
public class Main {
    public static void main(String[] args) {
        (new Main()).parse();
    }

    /**
     * Parse JSON library file and print data to console
     */
    private void parse() {
        try {
            InputStream is = new FileInputStream("./library.json");
            String jsonData =  readSource(is);
            LibraryParser libParser = new LibraryParser();
            libParser.parseLibrary(jsonData);
        } catch (IOException e) {
            System.out.println("Error reading file...");
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("Error parsing JSON data");
            e.printStackTrace();
        }

    }

    /**
     * Read source data from input stream as string
     *
     * @param is  input stream connected to source data
     * @return  source data as string
     * @throws IOException  when error occurs reading data from file
     */
    private String readSource(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;

        while((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }

        br.close();

        return sb.toString();
    }
}
