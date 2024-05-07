package org.example.excetion;

public class UsernameAlreadyExistExcaption extends RuntimeException {
    public UsernameAlreadyExistExcaption(String message) {
        super(message);
    }
}
