package at.jscarlata.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

@Setter
@Getter
public class WortEintrag implements Serializable {

    private String word;
    private String url;

    public WortEintrag(String word, String url) {
        this.word = word;
        if(checkUrl(url)) {
            this.url = url;
        } else {
            throw new IllegalArgumentException("URL is invalid");
        }
    }

    public static boolean checkUrl(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "WortEintrag{" +
                "word='" + word + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
