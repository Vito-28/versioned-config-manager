package com.vitochianese.configmanager.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vitochianese.configmanager.exception.JsonFileNotFoundException;
import com.vitochianese.configmanager.model.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

    private final String pathname = "configs.json";

    public List<Configuration> loadFromFile() throws IOException {
        File file = new File(pathname);

        if(!file.exists()) {
            throw new JsonFileNotFoundException("File not found!");
        }

        if(file.exists() && file.length() == 0) {
            throw new JsonFileNotFoundException("File is empty!");
        }

        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = new FileInputStream(file);
        TypeReference<List<Configuration>> typeReference = new TypeReference<List<Configuration>>() {
        };

        List<Configuration> configurations = mapper.readValue(inputStream, typeReference);
        inputStream.close();;

        return configurations;
    }

    public void saveToFile(List<Configuration> configurations) throws IOException {

        File file = new File(pathname);

        ObjectMapper mapper = new ObjectMapper();

        if(!file.exists()) {
            mapper.writeValue(file, new ArrayList<Configuration>());
        }

        mapper.writeValue(file, configurations);

    }

}
