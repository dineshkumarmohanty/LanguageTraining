package singlepageapp.mohanty.dinesh.com.languagetraining;

/**
 * Created by debashish on 10-06-2017.
 */
public class Word {

    private static final int VALUE_INTI = -1;
    private String english;
    private String mewaki;
    private int id = VALUE_INTI;
    private int idsound ;

    public Word(String English , String Mewaki , int soundid)
    {
        english  = English;
        mewaki = Mewaki;
        idsound = soundid;
    }
    public Word(String English , String Mewaki , int id, int soundid)
    {
        english  = English;
        mewaki = Mewaki;
        this.id = id;
        idsound = soundid;
    }


    public String getEnglish()
    {
        return english;
    }
    public String getMewaki()
    {
        return mewaki;
    }
    public int getId()
    {
       return id;
    }
    public boolean hasImage()
    {
        return id !=VALUE_INTI;
    }
    public int getIdsound()
    {
        return idsound;
    }

}
