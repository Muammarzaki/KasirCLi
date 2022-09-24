package com.kasircli.utils;

import java.nio.file.Path;

public interface InOutFiles {

    public void init();

    public void loadFile(String namefile);

    public void saveFile(Path namefile, Object data);

    public void loadAllFile();

    public void delete(String namefile);

}
