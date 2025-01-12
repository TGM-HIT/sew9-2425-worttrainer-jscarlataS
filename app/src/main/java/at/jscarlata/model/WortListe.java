package at.jscarlata.model;

import java.io.Serializable;

public class WortListe implements Serializable {

    private WortEintrag[] words;

    public WortListe(String[] words, String[] urls) {

        if(words.length != urls.length) {
            throw new IllegalArgumentException("Words and urls must be the same length");
        }

        this.words = new WortEintrag[words.length];
        for (int i = 0; i < words.length; i++) {
            if (WortEintrag.checkUrl(urls[i])) {
                this.words[i] = new WortEintrag(words[i], urls[i]);
            }
        }
    }

    public boolean removeWord(String word) {
        boolean contained = false;
        WortEintrag[] newWords = new WortEintrag[words.length -1];
        for (int i = 0; i < this.words.length; i++) {
           if(!this.words[i].getWord().equals(word)) {
               newWords[i] = new WortEintrag(this.words[i].getWord(), this.words[i].getUrl());
           } else {
                contained = true;
           }
        }

        if (contained) {
            this.words = newWords;
        }

        return contained;
    }

    public void addWord(String word, String url) {
        WortEintrag we = new WortEintrag(word, url);
        WortEintrag[] newWords = new WortEintrag[words.length + 1];
        for (int i = 0; i < this.words.length; i++) {
            newWords[i] = this.words[i];
        }
        newWords[words.length] = we;
        this.words = newWords;
    }

    public int getLength() {
        return this.words.length ;
    }

    public String getUrl(int index) {
        return words[index].getUrl();
    }

    public String getWord(int index) {
        return words[index].getWord();
    }

}
