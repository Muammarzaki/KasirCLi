package com.kasircli.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.kasircli.utils.DataModel;
import com.kasircli.utils.InOutFiles;

public class JsonHandler implements InOutFiles<DataModel> {

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
    public void saveFile(String namefile, List<DataModel> data) {
        // List<DataModel> dataCollect = new ArrayList<>();

        root = root.resolve(namefile);

        System.out.println(root.toString());
        if (Files.notExists(root)) {
            try {
                Files.createFile(root);
            } catch (IOException e) {
                System.err.println("something wrong ");
            }
        }

        try {

            ObjectMapper objmap = new ObjectMapper();
            ObjectWriter writer = objmap.writer(new DefaultPrettyPrinter());

            // read to file
            List<DataModel> readValue = objmap.readValue(root.toFile(), new TypeReference<List<DataModel>>() {
            });
            readValue.addAll(data);

            // write to file
            writer.writeValue(root.toFile(), readValue);

        } catch (IOException e) {
            System.err.println(e);
            System.err.println("cant write at file");
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
