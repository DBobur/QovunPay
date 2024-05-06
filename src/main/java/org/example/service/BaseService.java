package org.example.service;

import org.example.model.model.BaseModel;
import org.example.repository.BaseRepository;

public abstract class BaseService<T extends BaseModel, R extends BaseRepository<T>> {

}
