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

    private ArrayList<Player> players = new ArrayList<>(NUMBER_OF_PLAYERS);
    private ArrayList<Card> cardsOnTable = new ArrayList<>(MAX_CARDS_ON_TABLE);
    private ArrayList<CardImageView> cardsOnTableImage = new ArrayList<>(4);

    private Deck deck;

    private ArrayList<PlayerButton> playerButtons = new ArrayList<>(8);

    private ArrayList<AdutImageView> adutImageViews = new ArrayList<>(4);

    private CardColor currentAdut;

    private AdutImageView currentAdutImage;

    public void addPlayer(Player player){
        players.add(player);
    }

    public void setDeck(Deck deck){
        this.deck = deck;
    }

    public void setCardOnTable(Card card){
        cardsOnTable.add(card);
        setCardOnTableImage(card);
    }

    public void setCardOnTableImage(Card card){
        this.cardsOnTableImage.get(0).setImageResource(card.getImage());
    }

    public void setCurrentAdut(CardColor adut){
        this.currentAdut = adut;
    }

    public void setCurrentAdutImage(AdutImageView adut){
        this.currentAdutImage = adut;
    }

    public void setPlayerOnMove(Player playerOnMove){
        this.playerOnMove = playerOnMove;
    }

    public void addAdutImageView(AdutImageView adutImageView){
        adutImageViews.add(adutImageView);
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

    public Player getPlayerOnMove(){
        return playerOnMove;
    }

    public CardColor getCurrentAdut(){
        return currentAdut;
    }

    public List<AdutImageView> getAdutImageView(){
        return adutImageViews;
    }

    public AdutImageView getCurrentAdutImage() {
        return currentAdutImage;
    }

    public void addCardOnTableImage(CardImageView cardImageView) {
        cardsOnTableImage.add(cardImageView);
    }

    public ArrayList<CardImageView> getCardsOnTableImage() {
        return cardsOnTableImage;
    }
}