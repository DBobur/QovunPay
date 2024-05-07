package org.example.service;

import org.example.model.Card;
import org.example.repository.CardRepository;
import org.example.repository.UserRepository;

public class CardService extends BaseService<Card, CardRepository> {
    private static final CardService cardService = new CardService();
    private CardService() {
        super(new CardRepository());
    }

    public static CardService getInstance(){
        return cardService;
    }

    @Override
    protected boolean checking(Card card) {
        return false;
    }
}
