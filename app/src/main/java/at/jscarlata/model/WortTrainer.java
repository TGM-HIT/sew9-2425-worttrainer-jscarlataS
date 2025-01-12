package at.jscarlata.model;

import lombok.Getter;

import java.io.Serializable;
import java.util.Random;

@Getter
public class WortTrainer implements Serializable {

    private WortListe wl;
    private int selectedIndex;
    private int richtig = 0;
    private int eingaben = 0;

    public WortTrainer(WortListe wl) {
        if (wl == null) {
            throw new IllegalArgumentException("WortListe cannot be null");
        }
        this.wl = wl;
    }

    public String pickRandomWord() {
        this.selectedIndex = new Random().nextInt(wl.getLength());
        return this.wl.getWord(selectedIndex);
    }

    public boolean checkSelectedWord(String input) {
        eingaben++;
        if(this.wl.getWord(selectedIndex).equals(input)) {
            richtig++;
            return true;
        }
        return false;
    }

    public boolean checkSelectedWordIgnoreCase(String input) {
        eingaben++;
        if(this.wl.getWord(selectedIndex).equalsIgnoreCase(input)) {
            richtig++;
            return true;
        }
        return false;
    }

    public void addWord(String word, String url) {
        this.wl.addWord(word, url);
    }
}
