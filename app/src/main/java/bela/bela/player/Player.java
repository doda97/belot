package bela.bela.player;

import java.util.ArrayList;
import java.util.List;

import bela.bela.cards.Card;
import bela.bela.game.CardImageView;
import bela.bela.game.Table;

/**
 * Created by dado on 16.04.16..
 * Player interface for Human and Droid
 */

public interface Player {

    String getName();

    List<Card> getPlayerCards();

    void addPlayerCard(Card card);

    void setCardOnTable(Card card);

    void setCardsToPlayerButtons(ArrayList<PlayerButton> playerButtons);

    List<PlayerButton> getPlayerButtons();

    Card play(final Table table);

    Card getCardOnTable();
}
