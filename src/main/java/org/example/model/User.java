package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends BaseModel {
    private String name;
    private String username;
    private String password;
    private List<UserRole> roles;

    public User(String name, String username, String password, List<UserRole> roles) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }
}
