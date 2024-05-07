package org.example.model;

import java.util.UUID;

public class Transaction extends BaseModel{
    private UUID sender;
    private UUID recipient;
    private double amount;
}
