package org.example.controller;
import org.example.Message;
import org.example.excetion.ModelNotFoundExcaption;
import org.example.excetion.PasswordWrongExcaption;
import org.example.excetion.UsernameAlreadyExistExcaption;
import org.example.model.User;


import static org.example.Main.*;

public class AuthController {
    public static void register(){
        String name = inputStr("Enter name :");
        String userName = inputStr("Enter UserName :");
        String password = inputStr("Enter password :");
        try {
            userService.add(new User(name,userName,password));
            System.out.println(Message.SUCCESSFULLY);
        }catch (UsernameAlreadyExistExcaption e){
            System.out.println(e.getMessage());
        }


    }
    public static void login(){
        String userName = inputStr("Enter UserName :");
        String password = inputStr("Enter password :");
        try {
            currentUser = userService.login(userName,password);
        }catch (ModelNotFoundExcaption | PasswordWrongExcaption e){
            System.out.println(e.getMessage());
        }
        userMenu();
    }
}
