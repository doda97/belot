package bela.bela.logic;

import java.util.List;

import bela.bela.cards.Card;
import bela.bela.game.Table;

/**
 * Created by dado on 03.05.16..
 * Respect is what its all about
 * Respect your partner with your best card
 * Respect other with right card
 */

public class Respecting {

    /* public boolean respecting(Table table){
        boolean respect = false;

            for(Card card : table.get.getPlayerCards()) {
                if (table.getCardsOnTable().size() != 0) {
                    if (haveColor(player.getPlayerCards())) {
                        if (card.getCardColor() == table.getCardsOnTable().get(0).getCardColor()) {
                            cardOnTable.setCard(card);
                            cardOnTable.setBackgroundResource(card.getImage());
                            respect = true;
                        }
                    } else if (!haveColor(player.getPlayerCards()) && haveAdut(player.getPlayerCards())) {
                        if (card.isAdut()) {
                            cardOnTable.setCard(card);
                            cardOnTable.setBackgroundResource(card.getImage());
                            respect = true;
                        }
                    } else if (!haveColor(player.getPlayerCards()) && !haveAdut(player.getPlayerCards())) {
                        cardOnTable.setCard(card);
                        cardOnTable.setBackgroundResource(card.getImage());
                        respect = true;
                    }
                } else {
                    cardOnTable.setCard(card);
                    cardOnTable.setBackgroundResource(card.getImage());
                    respect = true;
                }
            }
        return respect;
    }

    public boolean haveColor(List<Card> playerCards){

        boolean haveColor = false;

        Table table = new Table();

        for(Card card1:playerCards){
            if(card1.getCardColor() == table.getCardsOnTable().get(0).getCardColor()){
                haveColor = true;
            }
        }

        return haveColor;
    }

    public boolean haveAdut(List<Card> playerCards){

        boolean haveColor = false;

        for(Card card1:playerCards){
            if(card1.isAdut()){
                haveColor = true;
            }
        }

        return haveColor;
    }
    */
}
