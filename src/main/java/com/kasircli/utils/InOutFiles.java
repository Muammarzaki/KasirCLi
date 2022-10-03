package com.kasircli.utils;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface InOutFiles<T extends Object> {

    /**
     * make directory for files
     */
    public void init();

    /**
     * search one data by key in file
     * 
     * @param key
     * @return
     */
    public Optional<T> search(String key);

    /**
     * save files in file
     * 
     * @param data
     */
    public Boolean saveFile(List<T> data);

    /**
     * load all of data
     * 
     * @return
     * @throws IOException
     */
    public List<T> loadAllFile();

    /**
     * delete one data by key
     * 
     * @param key
     */
    public Boolean delete(String key);

}
