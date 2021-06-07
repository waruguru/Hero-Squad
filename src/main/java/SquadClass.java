import java.util.ArrayList;
import java.util.List;

public class SquadClass {

    private  String mName;
    private Integer mMaxSize;
    private static  ArrayList<SquadClass>instances =new ArrayList<>();
    private int mID;
    private List<HeroClass> mHeros;

    public SquadClass(String mName, Integer mMaxSize, int mID, List<HeroClass> mHeros) {
        this.mName = mName;
        this.mMaxSize = mMaxSize;
        this.mID = mID;
        this.mHeros = mHeros;
    }
}
