package org.example.controller;

import org.example.model.Card;
import org.example.model.CardType;

import java.util.ArrayList;

import static org.example.Main.*;

public class CardController {
    public static void cardCRUD(){
        while (true){
            System.out.print("""
                    1.Create
                    2.Read
                    3.Update
                    4.Delete
                    0.Back
                    """);
            int command = (Integer) inputNumber("command: ").intValue();
            switch (command){
                case -1 -> System.out.println("Error entered?");
                case 1 -> createCard();
                case 2 -> {
                    ArrayList<Card> cards = cardService.getAllUserCards(currentUser.getId());
                    readyList(cards);
                }
                case 3 -> updateCard();
                case 4 -> deleteCard();
                case 0 -> {return;}
                default -> System.out.println("Non command");
            }
        }
    }

    public static void deleteCard() {
    }

    public static void updateCard() {
    }

    public static void createCard() {
        CardType type = getCardType();
        String name = inputString("Enter card number: ");
        String number = inputString("Enter number: ");
        Double balance = (Double) inputNumber("Enter balance: ");

        cardService.add(new Card(currentUser.getId(),type,name,number,balance));
    }

    private static CardType getCardType() {
        CardType[] cardTypes = CardType.values();
        int i = 0;
        for (CardType cardType : cardTypes) {
            System.out.println(i++ + " : " + cardType.name());
        }
        int choice = (Integer) inputNumber("choice: ").intValue();
        return cardTypes[choice];
    }
}
