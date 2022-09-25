package com.kasircli.utils;

import java.util.List;

public interface InOutFiles<T extends Object> {

    public void init();

    public void loadFile(String namefile);

    public void saveFile(String namefile, List<T> data);

    public void loadAllFile();

    public void delete(String namefile);

}
