package org.example.controller;
import org.example.Message;
import org.example.model.model.User;

import static org.example.Main.*;

public class AuthController {
    public static void register(){
        String name = inputStr("Enter name :");
        String userName = inputStr("Enter UserName :");
        String password = inputStr("Enter password :");

        userService.add(new User(name,userName,password));
        System.out.println(Message.SUCCESSFULLY);

    }
    public static void login(){
        String userName = inputStr("Enter UserName :");
        String password = inputStr("Enter password :");
        currentUser = userService.login(userName,password);
        if(currentUser == null){
            System.out.println("😢");
        }else {
            userMenu();
        }
    }
}
