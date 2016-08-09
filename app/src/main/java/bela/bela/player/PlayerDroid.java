package bela.bela.player;

import java.util.ArrayList;
import java.util.List;

import bela.bela.cards.Card;
import bela.bela.game.Table;

/**
 * Created by dado on 16.04.16..
 * Player Droid
 */

public class PlayerDroid implements Player {

    private final static int MAX_NUMBER_OF_PLAYER_CARDS = 8;

    private String name;
    private Card cardOnTable;
    private ArrayList<Card> playerCards = new ArrayList<>(MAX_NUMBER_OF_PLAYER_CARDS);

    public PlayerDroid(String name){
        this.name = name;
    }

    public void addPlayerCard(Card card) {
        playerCards.add(card);
    }

    public void setCardsToPlayerButtons(ArrayList<PlayerButton> playerButtons){}

    public void setCardOnTable(Card card){
        this.cardOnTable = card;
    }

    @Override
    public List<PlayerButton> getPlayerButtons() {
        return null;
    }

    @Override
    public Card play(final Table table) {
        for(Card card:playerCards){
            if(table.getCardsOnTable().get(0).getCardColor()==card.getCardColor()){
                return card;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public List<Card> getPlayerCards(){
        return playerCards;
    }

    public Card getCardOnTable(){
        return cardOnTable;
    }

}
