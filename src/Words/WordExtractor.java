package Words;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WordExtractor {


    public static void main(String[] args) {
        // Gson importation
        Gson gson = new Gson();

        //extraction
        try {
            // create reader
            Reader reader = Files.newBufferedReader(Paths.get("wordSwEn.json"));

            // convert Json file to Vector (Array) Word object

            Word[] wordList = gson.fromJson(reader, Word[].class);
            //wordList[0].fr = "comme";
            //wordList[0].getWord();
            System.out.println("file readen");

            // Extract WordList update to a new JSON file

            try {
                FileWriter myWritter = new FileWriter("WordList.json");
                myWritter.write(gson.toJson(wordList));
                myWritter.close();
                System.out.println("JSON File Written");
            } catch (Exception e) {
                System.out.println("An error occurred while writing file.");
                e.printStackTrace();
            }


        } catch (Exception e) {
            System.out.println("An error occurred while reading file.");
            e.printStackTrace();
        }

    }
}
