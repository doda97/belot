package bela.bela.game;

import java.util.ArrayList;
import java.util.List;

import bela.bela.cards.Card;
import bela.bela.cards.CardColor;
import bela.bela.deck.Deck;
import bela.bela.player.Player;
import bela.bela.player.PlayerButton;

public class Table {

    private static final int NUMBER_OF_PLAYERS = 4;
    private static final int MAX_CARDS_ON_TABLE = 4;

    private Player playerOnMove;
    private Player lastFirstPlayerOnMove;
    private Player lastPlayerOnMove;

    private ArrayList<Player> players = new ArrayList<>(NUMBER_OF_PLAYERS);
    private ArrayList<Card> cardsOnTable = new ArrayList<>(MAX_CARDS_ON_TABLE);
    private ArrayList<CardImageView> cardsOnTableImage = new ArrayList<>(MAX_CARDS_ON_TABLE);

    private Deck deck;

    private CardColor currentAdut;

    private CardColor currentPlayedColor;

    public void addPlayer(Player player){
        players.add(player);
    }

    public void setDeck(Deck deck){
        this.deck = deck;
    }

    public void setCardOnTable(Card card){
        for (Player player : getPlayers()) {
            if (getPlayerOnMove() == player) {
                player.setCardOnTable(card);
            }
        }
        setCardOnTableImage(card);
    }

    public void setCardOnTableImage(Card card){
        this.cardsOnTableImage.get(0).setImageResource(card.getImage());
    }

    public void updateColorPlayed() {
        if (getCardsOnTable().size() > 0) {
            currentPlayedColor = getCardsOnTable().get(0).getCardColor();
        }
    }

    public void setCurrentAdut(CardColor adut){
        this.currentAdut = adut;
    }

    public void setPlayerOnMove(Player playerOnMove){
        this.playerOnMove = playerOnMove;
    }


    public void setLastFirstPlayerOnMove(Player player) {
        this.lastFirstPlayerOnMove = player;
    }

    public void setLastPlayerOnMove(Player player) {
        this.lastPlayerOnMove = player;
    }

    public Deck getDeck(){
        return deck;
    }

    public List<Player> getPlayers(){
        return players;
    }

    public List<Card> getCardsOnTable(){
        return cardsOnTable;
    }

    public CardColor getCurrentPlayedColor() {
        return currentPlayedColor;
    }

    public Player getPlayerOnMove(){
        return playerOnMove;
    }

    public Player getLastFirstPlayerOnMove() {
        return lastFirstPlayerOnMove;
    }

    public Player getLastPlayerOnMove() {
        return lastPlayerOnMove;
    }

    public CardColor getCurrentAdut(){
        return currentAdut;
    }

    public void addCardOnTableImage(CardImageView cardImageView) {
        cardsOnTableImage.add(cardImageView);
    }

}