package org.example.service;

import org.example.excetion.UsernameAlreadyExistExcaption;
import org.example.model.BaseModel;
import org.example.repository.BaseRepository;

import java.util.ArrayList;

public abstract class BaseService<T extends BaseModel, R extends BaseRepository<T>> {
    protected R repository;

    public BaseService(R repository) {
        this.repository = repository;
    }

    public void add(T t){
        if(checking(t)) throw new UsernameAlreadyExistExcaption("Username already exist");
        repository.write(t);
    }
    public ArrayList<T> getAll(){
        return repository.readAll();
    }

    protected abstract boolean checking(T t);
}
