package org.example.service;

import org.example.excetion.ModelNotFoundExcaption;
import org.example.excetion.PasswordWrongExcaption;
import org.example.model.model.User;
import org.example.repository.UserRepository;

import java.util.Objects;
import java.util.Optional;

public class UserService extends BaseService<User, UserRepository>{
    private static final UserService userService = new UserService();
    private UserService() {
        super(new UserRepository());
    }

    public static UserService getInstance(){
        return userService;
    }

    @Override
    protected boolean checking(User user) {
        Optional<User> byUsername = repository.getByUsername(user.getUsername());
        return byUsername.isPresent();
    }

    public User login(String userName, String password) {
        Optional<User> byUsername = repository.getByUsername(userName);
        if (byUsername.isEmpty()) throw new ModelNotFoundExcaption("Model not fount");
        User user = byUsername.get();
        if(Objects.equals(user.getPassword(),password)) return user;
        throw new PasswordWrongExcaption("Password wrong");
    }
}
