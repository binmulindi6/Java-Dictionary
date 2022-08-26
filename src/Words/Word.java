package Words;

public class Word {

    protected int  id;
    protected String sw;
    protected String en;
    protected String fr = "undefined";

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
        //this.fr = "";
    }

    public void getWord(){
        System.out.println("id: "+this.id);
        System.out.println("sw: "+this.sw);
        System.out.println("en: "+this.en);
        System.out.println("fr: "+this.fr);
    }

}
