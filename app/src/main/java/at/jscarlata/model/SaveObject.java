package at.jscarlata.model;

import java.io.*;

public class SaveObject implements SaveLoad {

    public void save(WortTrainer wt, String path) {
        if (wt == null) {
            throw new IllegalArgumentException("WortTrainer must not be null");
        }

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path))) {
            os.writeObject(wt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    public WortTrainer load(String path) {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(path))) {
            return (WortTrainer) is.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            return new WortTrainer(new WortListe(new String[]{"Dog", "Cat"}, new String[]{"https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Cat_November_2010-1a.jpg/800px-Cat_November_2010-1a.jpg"}));
        }
    }

}
