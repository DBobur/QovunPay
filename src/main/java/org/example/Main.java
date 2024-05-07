package org.example;

import org.example.model.BaseModel;
import org.example.model.User;
import org.example.service.CardService;
import org.example.service.UserService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import static org.example.controller.AuthController.*;
import static org.example.controller.UserController.*;
import static org.example.controller.TransactionController.*;

public class Main {
    public static Scanner scNum = new Scanner(System.in);
    public static Scanner scStr = new Scanner(System.in);
    public static UserService userService = UserService.getInstance();
    public static CardService cardService = CardService.getInstance();
    public static User currentUser;
    public static void main(String[] args) {
        welcomeMenu();
    }

    private static void welcomeMenu() {
        while (true) {
            System.out.print("""
                    1.Register
                    2.Login
                    0.Exit
                    """);
            int command = (Integer) inputNumber("command: ").intValue();
            switch (command) {
                case -1 -> System.out.println("Error entered?");
                case 1 -> register();
                case 2 -> login();
                case 0 -> {
                    return;
                }
                default -> System.out.println("Non command");
            }
        }
    }
    public static void userMenu(){
        while (true){
            System.out.print("""
                    1.Transaction
                    2.Pay
                    3.Accounts
                    0.Logout
                    """);
            int command = (Integer) inputNumber("command: ").intValue();
            switch (command){
                case -1 -> System.out.println("Error entered?");
                case 1 -> transaction();
                case 2 -> pay();
                case 3 -> accounts();
                case 0 -> {return;}
                default -> System.out.println("Non command");
            }
        }
    }

    public static String inputString(String message){
        System.out.print(message);
        return scStr.nextLine();
    }
    public static Number inputNumber(String message){
        System.out.print(message);
        try {
            return scNum.nextDouble();
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
            scNum = new Scanner(System.in);
            return -1;
        }
    }

    public static <T extends BaseModel> void readyList(ArrayList<T> list){
        list.stream().forEach(System.out::println);
    }
}