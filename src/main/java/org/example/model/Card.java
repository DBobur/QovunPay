package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Card extends BaseModel{
    private UUID owner;
    private CardType type;
    private String name;
    private String cardNumber;
    private double balance;

    public Card(UUID owner, CardType type, String name, String cardNumber, double balance) {
        this.owner = owner;
        this.type = type;
        this.name = name;
        this.cardNumber = cardNumber;
        this.balance = balance;
    }
}
