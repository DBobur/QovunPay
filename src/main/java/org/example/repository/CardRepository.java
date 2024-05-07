package org.example.repository;

import org.example.model.model.Card;

public class CardRepository extends BaseRepository<Card> {
    {
        path += "cards.json";
        type = Card.class;
    }
}
