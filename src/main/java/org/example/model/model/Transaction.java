package org.example.model.model;

import java.util.UUID;

public class Transaction extends BaseModel{
    private UUID sender;
    private UUID recipient;
    private double amount;
}
