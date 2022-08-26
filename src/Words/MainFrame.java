package Words;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainFrame extends JFrame {
    //import
    Gson gson = new Gson();
    private JPanel mainPanel;
    private JTextField tfId;
    private JTextField tfSwahili;
    private JTextField tfEnglish;
    private JTextField tfFrench;
    private JButton btnSave;
    private JButton btnNext;
    private JButton btnBack;
    //private JButton btnTrack;


    public MainFrame(String title) {
        setContentPane(mainPanel);
        setTitle(title);
        setSize(800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);


        Word[] wordList;
        final int[] index = {0};
        try{
            Reader reader = Files.newBufferedReader(Paths.get("WordList.json"));

            //import to a vector
            wordList = gson.fromJson(reader, Word[].class);

            index[0] = Track(wordList, index);
            String id = Integer.toString(wordList[index[0]].id);
            String Sw = wordList[index[0]].sw;
            String En = wordList[index[0]].en;
            String Fr = wordList[index[0]].fr;

            fillFields(id,Sw,En,Fr);

            System.out.println("file readen");


            btnNext.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    /*for (int i=0; i<wordList.length;i++){
                        if (wordList[i].fr == "1"){
                            console("found");
                            break;
                        }
                    }*/
                    index[0]++;
                    String id = Integer.toString(wordList[index[0]].id);
                    String Sw = wordList[index[0]].sw;
                    String En = wordList[index[0]].en;
                    String Fr = wordList[index[0]].fr;

                    fillFields(id,Sw,En,Fr);

                }
            });

            btnBack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    index[0]--;
                    String id = Integer.toString(wordList[index[0]].id);
                    String Sw = wordList[index[0]].sw;
                    String En = wordList[index[0]].en;
                    String Fr = wordList[index[0]].fr;

                    fillFields(id,Sw,En,Fr);

                }
            });

            btnSave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //console(tfFrench.getText());
                    wordList[index[0]].fr = tfFrench.getText();
                    SaveWordlist(wordList);
                    btnNext.doClick();
                }
            });


            /*btnTrack.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    for (int i=index[0]; i<wordList.length;i++) {
                        if (wordList[i].fr.contains("undefined")) {
                            console("found");
                            index[0] = i;
                            break;
                        }
                    }
                }
            });*/
        } catch (Exception e) {
            console("An error occurred while reading file.");
            e.printStackTrace();
        }


    }

    //display word
    public void fillFields(String id, String Sw, String En, String Fr){
        tfId.setText(id);
        tfSwahili.setText(Sw);
        tfEnglish.setText(En);
        tfFrench.setText(Fr);
    }

    //save wordlist in the JSON file

    public void SaveWordlist(Word[] wordList){
        try {
            FileWriter myWritter = new FileWriter("WordList.json");
            myWritter.write(gson.toJson(wordList));
            myWritter.close();
            console("Saved");
        } catch (Exception e) {
            console("An error occurred while writing file.");
            e.printStackTrace();
        }
    }

    //Track undefinded

    public int Track(Word[] wordList, int[] index){
        int in = 0;
        for (int i=index[0]; i<wordList.length;i++) {
            if (wordList[i].fr.contains("undefined")) {
                console("found");
                in = i;
                break;
            }
        }
        return in;
    }

    public static void main(String[] args) {
        //loading
        MainFrame myFrame =  new MainFrame("French Adding");

    }
    public void console(String a){
        System.out.println(a);
    }
    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
