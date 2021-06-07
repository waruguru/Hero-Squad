import java.util.ArrayList;
import java.util.List;

public class HeroClass {
    private  String mName;
    private  int    mAge;
    private String mSpecialPowers;
    private  String mWeakness;
    private static List<HeroClass> instances = new ArrayList<>();

    public HeroClass(String mName, int mAge, String mSpecialPowers, String mWeakness) {
        this.mName = mName;
        this.mAge = mAge;
        this.mSpecialPowers = mSpecialPowers;
        this.mWeakness = mWeakness;
    }

    public String getmName() {
        return mName;
    }

    public int getmAge() {
        return mAge;
    }

    public String getmSpecialPowers() {
        return mSpecialPowers;
    }

    public String getmWeakness() {
        return mWeakness;
    }

    public static List<HeroClass> getInstances() {
        return instances;
    }
}
