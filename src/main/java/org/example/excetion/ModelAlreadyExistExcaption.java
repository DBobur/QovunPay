package org.example.excetion;

public class ModelAlreadyExistExcaption extends RuntimeException {
    public ModelAlreadyExistExcaption(String message) {
        super(message);
    }
}
