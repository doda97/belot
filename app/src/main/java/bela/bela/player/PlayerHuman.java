package bela.bela.player;

import java.util.ArrayList;
import java.util.List;

import bela.bela.cards.Card;
import bela.bela.game.Table;

/**
 * Created by dado on 16.04.16..
 * Player Human
 */

public class PlayerHuman implements Player {

    private final static int MAX_NUMBER_OF_PLAYER_CARDS = 8;
    private final static int MAX_NUMBER_OF_PLAYER_BUTTONS = 8;

    private String name;
    private Card cardOnTable;

    private ArrayList<Card> playerCards = new ArrayList<>(MAX_NUMBER_OF_PLAYER_CARDS);
    private ArrayList<PlayerButton> playerButtons = new ArrayList<>(MAX_NUMBER_OF_PLAYER_BUTTONS);

    public PlayerHuman(String name){
        this.name = name;
    }

    public void addPlayerCard(Card card) {
        playerCards.add(card);
    }

    @Override
    public void setCardsToPlayerButtons(ArrayList<PlayerButton> playerButtonIndustry) {
        for(int i = 0; i<8; i++){
            playerButtonIndustry.get(i).setCard(getPlayerCards().get(i));
        }
        playerButtons.addAll(playerButtonIndustry);
    }

    public void setCardOnTable(Card card){
        this.cardOnTable = card;
    }

    public List<PlayerButton> getPlayerButtons(){
        return playerButtons;
    }

    @Override
    public Card play(final Table table) {
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
