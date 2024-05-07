package org.example.service;

import org.example.model.Card;
import org.example.repository.CardRepository;
import org.example.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public ArrayList<Card> getAllUserCards(UUID ownerId) {
        ArrayList<Card> cards = repository.readAll();
        List<Card> list = cards.stream().filter(card -> Objects.equals(card.getOwner(), ownerId)).toList();
        return new ArrayList<>(list);
    }
}
