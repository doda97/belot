package bela.bela.player;

import java.util.ArrayList;
import java.util.List;

import bela.bela.R;
import bela.bela.cards.Card;
import bela.bela.game.CardImageView;
import bela.bela.game.Table;

/**
 * Created by dado on 16.04.16..
 * Player Human
 */

public class PlayerHuman implements Player {

    private final static int MAX_NUMBER_OF_PLAYER_CARDS = 8;

    private String name;
    private Card cardOnTable;

    private ArrayList<Card> playerCards = new ArrayList<>(MAX_NUMBER_OF_PLAYER_CARDS);
    private CardImageView cardImageView;


    public PlayerHuman(String name){
        this.name = name;
    }

    public void addPlayerCard(CardImageView cardImageView) {
        this.cardImageView = cardImageView;
    }

    public void setPlayedCard(Card card) {
        cardImageView.setCard(card);
    }

    public void setCardOnTable(Card card){
        this.cardOnTable = card;
    }

    @Override
    public void givePlayerCard(Card card) {
        playerCards.add(card);
    }

    public Card getPlayedCard() {
        return cardImageView.getCard();
    }

    @Override
    public List<PlayerButton> getPlayerButtons() {
        return null;
    }

    @Override
    public Card play(final Table table, final Player player) {
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
