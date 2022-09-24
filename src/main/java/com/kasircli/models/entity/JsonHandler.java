package com.kasircli.models.entity;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kasircli.utils.InOutFiles;

public class JsonHandler implements InOutFiles {

    public static void main(String[] args) {

    }

    private Path root = Paths.get("files");
    public String jsonfile = "resource.json";

    @Override
    public void init() {
        try {
            if (Files.notExists(root)) {
                Files.createDirectory(root);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFile(String namefile) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveFile(Path namefile, Object data) {
        List<Object> datas = new ArrayList<>();
        ObjectMapper objmap = new ObjectMapper();

        if (Files.notExists(namefile)) {
            try {
                Files.createFile(namefile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            if (Files.readAllLines(namefile) == null) {
                datas.add(data);
                objmap.writeValue(namefile.toFile(), datas);
            } else {
                objmap.writeValue(namefile.toFile(), objmap.readValue(namefile.toFile(), List.class));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadAllFile() {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(String namefile) {
        // TODO Auto-generated method stub

    }

}
