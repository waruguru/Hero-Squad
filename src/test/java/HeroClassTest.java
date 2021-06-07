import org.junit.*;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
public class HeroClassTest {
    @Test
    public void Hero_instantiatesCorrectly_true() {
        Hero myHero = new Hero("Superman", 1, "SuperStrength", "Kyrypton");
        assertEquals(true, myHero instanceof Hero);
    }

    @Test
    public void Hero_instantiatesWithName_String() {
            HeroClassTest heroClassTest = new HeroClassTest("Superman", 1, "SuperStrength", "Kyrypton");
        assertEquals("Superman", myHer.getName());
    }


    @Test
    public void all_returnsAllInstancesOfHero_true() {
        Hero firstHero = new Hero("Superman", 1, "SuperStrength", "Kyrypton");
        Hero secondHero = new Hero("Superman", 1, "SuperStrength", "Kyrypton");
        assertEquals(true, Hero.all().contains(firstHero));
        assertEquals(true, Hero.all().contains(secondHero));
    }

    @Test
    public void clear_emptiesAllHerosFromArrayList_0() {
        Hero myHero = new Hero("Superman", 1, "SuperStrength", "Kyrypton");
        Hero.clear();
        assertEquals(Hero.all().size(), 0);
    }

    @Test
    public void getId_herosInstantiateWithAnID_1() {
        Hero.clear();
        Hero myHero = new Hero("Superman", 1, "SuperStrength", "Kyrypton");
        assertEquals(1, myHero.getId());
    }

    @Test
    public void find_returnsHeroWithSameId_secondHero() {
        Hero firstHero = new Hero("Superman", 1, "SuperStrength", "Kyrypton");
        Hero secondHero = new Hero("SpiderMan", 35, "Spiderstuff", "Mary Jane");
        assertEquals(Hero.find(secondHero.getId()), secondHero);
    }
    @Test
    public void find_returnsNullWhenNoTaskFound_null() {
        assertTrue(Hero.find(999) == null);
    }

}
}
