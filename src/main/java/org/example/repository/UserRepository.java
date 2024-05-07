package org.example.repository;

import org.example.model.User;

import java.util.Objects;
import java.util.Optional;

public class UserRepository extends BaseRepository<User> {
    {
        path += "users.json";
        type = User.class;
    }

    public Optional<User> getByUsername(String username){
        return readAll().stream().filter(user -> Objects.equals(user.getUsername(),username)).findAny();
    }
}
