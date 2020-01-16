package com.example.mtgtokensuggester.TokenStructure.Card;


import com.example.mtgtokensuggester.TokenStructure.Token.Token;

public class Card {

    private final Token token;
    private final QuantityType quantityType;

    public Card (Token token, QuantityType quantityType){
        this.token = token;
        this.quantityType = quantityType;
    }
}
