package org.example.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.example.model.model.BaseModel;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public abstract class BaseRepository<T extends BaseModel> {

    protected String path = "src/main/resources/";
    protected Class<T> type;
    private final ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    public void write(T t){
        ArrayList<T> ts = readAll();
        ts.add(t);
        try {
            objectMapper.writeValue(new File(path),ts);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void delete(UUID id){

    }
    public void update(UUID id){

    }
    public ArrayList<T> readAll(){
        try {
            return objectMapper.readValue(new File(path),TypeFactory.defaultInstance().constructCollectionType(ArrayList.class,type));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
