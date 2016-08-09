package bela.bela.cards;

import bela.bela.Cards;

public class Card {

    private CardColor cardColor;

    private CardType cardType;

    private boolean adut;

    public Card(CardColor cardColor, CardType cardType) {
        this.cardColor = cardColor;
        this.cardType = cardType;
    }

    public CardColor getCardColor() {
        return cardColor;
    }

    public CardType getCardType() {
        return cardType;
    }

    public boolean isAdut() {
        return adut;
    }

    public void setAdut(boolean adut) {
        this.adut = adut;
    }

    public int getValue(){

        final int result;

        switch(cardType){
            case SEDMICA:
            case OSMICA:
                result = 0;
                break;
            case DEVETKA:
                if(adut) {
                    result = 14;
                } else {
                    result = 0;
                }
                break;
            case DESETKA:
                result = 10;
                break;
            case DECKO:
                if(adut) {
                    result = 20;
                } else {
                    result = 2;
                }
                break;
            case BABA:
                result = 3;
                break;
            case KRALJ:
                result = 4;
                break;
            case AS:
                result = 11;
                break;
            default:
                result = 0;
                break;
        }

        return result;
    }

    public int getImage(){

        final int cC;

        final int result;

        switch (cardColor){
            case BUNDEVA:
                cC = 0;
                break;
            case ZELENA:
                cC = 8;
                break;
            case HERC:
                cC = 16;
                break;
            case ZIR:
                cC = 24;
                break;
            default:
                cC = 0;
                break;
        }

        switch (cardType){
            case SEDMICA:
                result = cC;
                break;
            case OSMICA:
                result = cC + 1;
                break;
            case DEVETKA:
                result = cC + 2;
                break;
            case DESETKA:
                result = cC + 3;
                break;
            case DECKO:
                result = cC + 4;
                break;
            case BABA:
                result = cC + 5;
                break;
            case KRALJ:
                result = cC + 6;
                break;
            case AS:
                result = cC + 7;
                break;
            default:
                result = 0;
                break;
        }

        return Cards.getKarte(result);
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardColor=" + cardColor +
                ", cardType=" + cardType +
                ", adut=" + adut +
                '}';
    }
}