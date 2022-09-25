package com.kasircli.utils;

import java.util.List;

public interface InOutFiles<T extends Object> {

    public void init();

    public void search(String key);

    public void saveFile(List<T> data);

    public void loadAllFile();

    public void delete(String key);

}
