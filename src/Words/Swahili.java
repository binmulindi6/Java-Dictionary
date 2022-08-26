package Words;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Swahili {

    static class Word{
        private int  id;
        private String sw;
        private String en;
        private String fr;

        public Word(){}

        public Word(int id,String sw,String en, String fr){
            this.id = id;
            this.sw = sw;
            this.en = en;
            this.fr = fr;
        }

        public Word(int id,String sw,String en){
            this.id = id;
            this.sw = sw;
            this.en = en;
        }

        public void getWord(){
            System.out.println("id: "+this.id);
            System.out.println("sw: "+this.sw);
            System.out.println("en: "+this.en);
            System.out.println("fr: "+this.fr);
        }

//        public Word(int id,String sw,String en){
//            this.id = id;
//            this.sw = sw;
//            this.en = en;
//            this.fr = "";
//        }
    }

    public static void main(String[] args) {
        /*Word a = new Word(1,"mimi","i/me");
        a.fr = "moi";

        a.getWord();*/
        Gson gson = new Gson();/*



        Word word = new Word(1,"mimi","me");

        String json = gson.toJson(word);
        System.out.println(json);*/

        //try {
            //Gson gson = new Gson();

            //Reader reader = Files.newBufferedReader(Paths.get("D:/word.json"));

            //List<Word> words = new Gson().fromJson(reader, new TypeToken<List<Word>>() {}.getType());

            //Word word1 = gson.fromJson(reader,Word.class);

            /*ArrayList<String> words = new ArrayList<>();

            File obj = new File("wordSwEn.json");

            Scanner myReader = new Scanner(obj);

            while(myReader.hasNext()) {
                String word = myReader.nextLine();
                words.add(word);
            }

//            System.out.println(gson.toString(words.get(1)));

            myReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

            try {
                // create Gson instance
                //Gson gson = new Gson();

                // create a reader
                Reader reader = Files.newBufferedReader(Paths.get("wordSwEn.json"));

                // convert JSON string to User object
                //Word word = gson.fromJson(reader,Word.class);

                Word[] wordsList = gson.fromJson(reader, Word[].class);

                wordsList[0].getWord();



                //Words.get(1).getWord();


                /*word.getWord();
                word.fr = "moi";
                ArrayList<Word> Words = new ArrayList<Word>();
                Words.add(word);
                word.id++;
                Words.add(word);
                word.id++;
                Words.add(word);
                reader.close();*/

                /*try {
                    FileWriter myWriter = new FileWriter("word1.json");
                    myWriter.write(gson.toJson(Words));
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (Exception e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }*/


                //gson.toJson(word, new FileWriter("word1.json"));
                // close reader


            } catch (Exception ex) {
                ex.printStackTrace();
            }




    }

}
//System.out.println("KISWAHILI BABY");

        /*JSONObject obj = new JSONObject();

        obj.put("name", "tommy");
        obj.put("sex","extralarge");
        obj.put("age", "15");*/

//System.out.println(obj);
//JSONArray Arr = new JSONArray();