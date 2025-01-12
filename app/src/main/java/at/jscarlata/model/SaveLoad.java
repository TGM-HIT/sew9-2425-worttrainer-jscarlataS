package at.jscarlata.model;

public interface SaveLoad {
    public void save(WortTrainer wt, String path);
    public WortTrainer load(String path);

}
