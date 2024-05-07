package org.example;

import org.example.model.model.User;
import org.example.service.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;
import static org.example.controller.AuthController.*;
import static org.example.controller.UserController.*;
import static org.example.controller.BlockController.*;
import static org.example.controller.CardController.*;
import static org.example.controller.MessageController.*;
import static org.example.controller.OrganizationController.*;
import static org.example.controller.TransactionController.*;

public class Main {
    public static Scanner scNum = new Scanner(System.in);
    public static Scanner scStr = new Scanner(System.in);
    public static UserService userService = UserService.getInstance();
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
            int command = inputInt("command: ");
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
                    2.Accounts
                    0.Logout
                    """);
            int command = inputInt("command: ");
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

    public static String inputStr(String message){
        System.out.print(message);
        return scStr.nextLine();
    }
    public static int inputInt(String message){
        System.out.print(message);
        try {
            return scNum.nextInt();
        }catch (InputMismatchException e){
            System.out.println(e.getMessage());
            scNum = new Scanner(System.in);
            return -1;
        }
    }
}