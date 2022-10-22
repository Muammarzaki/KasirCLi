package com.kasircli.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.kasircli.models.Product;
import com.kasircli.utils.InOutFiles;

public class JsonHandler implements InOutFiles<Product> {

    private ObjectMapper objmap = new ObjectMapper();
    private ObjectWriter writer = this.objmap.writer(new DefaultPrettyPrinter());
    Properties properties = new Properties();
    private Path root;

    /*
     * (non-Javadoc)
     * 
     * @see com.kasircli.utils.InOutFiles#init()
     */
    public JsonHandler() {
        try {
            this.properties.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
            setRoot(Paths.get(this.properties.getProperty("data.dir"))
                    .resolve(this.properties.getProperty("data.product")));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void init() {
        try {
            if (Files.notExists(this.root)) {
                Files.createDirectories(root.getParent());
                Files.createFile(this.root);
                this.writer.writeValue(root.toFile(), new ArrayList<>());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.kasircli.utils.InOutFiles#search(java.lang.String)
     */
    @Override
    public Optional<Product> search(String key) {
        try {
            return this.objmap.readValue(root.toFile(), new TypeReference<List<Product>>() {
            }).stream().filter(x -> x.getName().equals(key)).findAny();
        } catch (StreamReadException e) {
        } catch (DatabindException e) {
        } catch (IOException e) {
        }
        return null;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.kasircli.utils.InOutFiles#saveFile(java.util.List)
     */
    @Override
    public Boolean saveFile(List<Product> data) {

        init();
        try {

            List<Product> readValue = new ArrayList<>();
            // read to file
            if (Files.lines(root) != null) {
                readValue.addAll(this.objmap.readValue(root.toFile(), new TypeReference<List<Product>>() {
                }));
            }
            readValue.addAll(data);

            // write to file
            writeToFile(readValue);
            return true;
        } catch (IOException e) {
            System.err.println(e);
            System.err.println("cant write at file");
            return false;
        }
    }

    public void writeToFile(List<Product> readValue) throws IOException, StreamWriteException, DatabindException {
        this.writer.writeValue(root.toFile(), readValue);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.kasircli.utils.InOutFiles#loadAllFile()
     */
    @Override
    public List<Product> loadAllFile() {
        try {
            List<com.kasircli.models.Product> readValue = this.objmap.readValue(root.toFile(),
                    new TypeReference<List<Product>>() {
                    });
            return readValue;
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.kasircli.utils.InOutFiles#delete(java.lang.String)
     */
    @Override
    public Boolean delete(String key) {

        try {

            List<Product> readValue = this.objmap.readValue(root.toFile(), new TypeReference<List<Product>>() {
            });
            // todo ini belum sempurna pada pencarian atau key select oke jangan lupa
            // bangsat
            List<Product> afterRemove = readValue.stream().filter(x -> !x.getId().equals(key)).toList();

            writeToFile(afterRemove);

            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }
        // readValue.stream().dropWhile();
    }

    public void setObjmap(ObjectMapper objmap) {
        this.objmap = objmap;
    }

    public void setWriter(ObjectWriter writer) {
        this.writer = writer;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setRoot(Path root) {
        this.root = root;
    }

    public ObjectMapper getObjmap() {
        return objmap;
    }

    public ObjectWriter getWriter() {
        return writer;
    }

    public Properties getProperties() {
        return properties;
    }

    public Path getRoot() {
        return root;
    }

}
