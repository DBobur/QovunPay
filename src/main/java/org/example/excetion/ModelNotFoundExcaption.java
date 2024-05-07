package org.example.excetion;

public class ModelNotFoundExcaption extends RuntimeException{
    public ModelNotFoundExcaption(String message) {
        super(message);
    }
}
