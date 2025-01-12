package at.jscarlata.model;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveJson implements  SaveLoad{

    public void save(WortTrainer wt, String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File(path), wt);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public WortTrainer load(String path) {
        ObjectMapper om = new ObjectMapper();

        try {
            return om.readValue(new File(path), WortTrainer.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
