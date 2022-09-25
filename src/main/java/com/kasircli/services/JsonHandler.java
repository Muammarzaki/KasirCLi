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

    ObjectMapper objmap = new ObjectMapper();
    ObjectWriter writer = this.objmap.writer(new DefaultPrettyPrinter());

    private Path root = Paths.get("files/resource.json");

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
    public void search(String namefile) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveFile(List<DataModel> data) {
        // List<DataModel> dataCollect = new ArrayList<>();

        System.out.println(root.toString());
        if (Files.notExists(root)) {
            try {
                Files.createFile(root);
            } catch (IOException e) {
                System.err.println("something wrong ");
            }
        }

        try {

            // read to file
            List<DataModel> readValue = this.objmap.readValue(root.toFile(), new TypeReference<List<DataModel>>() {
            });
            readValue.addAll(data);

            // write to file
            this.writer.writeValue(root.toFile(), readValue);

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
    public void delete(String key) {

        try {

            List<DataModel> readValue = this.objmap.readValue(root.toFile(), new TypeReference<List<DataModel>>() {
            });
            // todo ini belum sempurna pada pencarian atau key select oke jangan lupa
            // bangsat
            List<DataModel> afterRemove = readValue.stream().filter(x -> !x.getCreater().equals(key)).toList();

            this.writer.writeValue(root.toFile(), afterRemove);

        } catch (Exception e) {
            System.err.println(e);
        }
        // readValue.stream().dropWhile();
    }

}
