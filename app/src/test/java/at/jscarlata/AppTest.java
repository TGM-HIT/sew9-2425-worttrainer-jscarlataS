package at.jscarlata;

import at.jscarlata.model.SaveLoad;
import at.jscarlata.model.SaveObject;
import at.jscarlata.model.WortListe;
import at.jscarlata.model.WortTrainer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AppTest {

    private WortTrainer wt;

    @BeforeEach
    public void setup() {
        wt = new WortTrainer(new WortListe(new String[]{"Haus"}, new String[]{"https://www.haus.at"}));
    }

    @Test
    public void checkAnswer() {
        assertTrue(wt.checkSelectedWord("Haus"));
        assertFalse(wt.checkSelectedWord("Fasd"));
    }

    @Test
    public void checkAnswerIgnoreCase() {
        assertTrue(wt.checkSelectedWordIgnoreCase("haus"));
        assertFalse(wt.checkSelectedWordIgnoreCase("Fasd"));
    }

    @Test
    public void saveLoadTest() {
        SaveLoad saveLoad = new SaveObject();
        saveLoad.save(wt, "/home/wood/Downloads/worttrainer.save");
        wt.checkSelectedWord("ada");
        WortTrainer loaded = saveLoad.load("/home/wood/Downloads/worttrainer.save");
        assertNotEquals(wt, loaded);
    }
}
