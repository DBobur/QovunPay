package org.example.controller;
import org.example.Message;
import org.example.excetion.ModelNotFoundExcaption;
import org.example.excetion.PasswordWrongExcaption;
import org.example.excetion.UsernameAlreadyExistExcaption;
import org.example.model.User;
import org.example.model.UserRole;


import java.util.List;

import static org.example.Main.*;

public class AuthController {
    public static void register(){
        String name = inputString("Enter name :");
        String userName = inputString("Enter UserName: ");
        String password = inputString("Enter password: ");
        try {
            userService.add(new User(name,userName,password, List.of(UserRole.USER)));
            System.out.println(Message.SUCCESSFULLY);
        }catch (UsernameAlreadyExistExcaption e){
            System.out.println(e.getMessage());
        }


    }
    public static void login(){
        String userName = inputString("Enter UserName: ");
        String password = inputString("Enter password: ");
        try {
            currentUser = userService.login(userName,password);
        }catch (ModelNotFoundExcaption | PasswordWrongExcaption e){
            System.out.println(e.getMessage());
        }
        userMenu();
    }
}
