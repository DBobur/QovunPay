package org.example.controller;
import static org.example.Main.*;

public class UserController {
    public static void accounts(){
        while (true){
            System.out.print("""
                    1.Card CRUD
                    2.Update Profile
                    0.Back
                    """);
            int command = (Integer) inputNumber("command: ").intValue();
            switch (command){
                case -1 -> System.out.println("Error entered?");
                case 1 -> CardController.cardCRUD();
                case 2 -> updateAccount();
                case 0 -> {return;}
                default -> System.out.println("Non command");
            }
        }
    }

    private static void updateAccount() {
    }
}
