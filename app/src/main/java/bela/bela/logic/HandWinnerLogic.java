package bela.bela.logic;

import java.util.ArrayList;
import java.util.List;

import bela.bela.cards.Card;
import bela.bela.game.Table;
import bela.bela.player.Player;

/**
 * Created by dado on 03.05.16..
 * Some of logic
 */
public class HandWinnerLogic {

    private boolean hasAdut;
    private ArrayList<Card> aduts = new ArrayList<>();

    public Player handWinner(List<Card> cards){
        for(Card card : cards){
            if(card.isAdut()){
                hasAdut(true);
            }
        }
        if(hasAdut){
            for(Card card: cards){
                if(card.isAdut()){
                    aduts.add(card);
                }
            }
            for(int i = 0;i < aduts.size(); i++){
                for(int j = 0; i < 4;i++) {
                    if(j!=i) {
                        if(aduts.get(i).getValue() > aduts.get(j).getValue()) {
                            return setPlayerFromWinnedHand(aduts.get(i));
                        }
                    }
                }
            }
        } else {
            for(int i = 0;i < cards.size(); i++){
                for(int j = 0; i < 4;i++) {
                    if(j!=i) {
                        if(cards.get(i).getValue() > cards.get(j).getValue()) {
                            return setPlayerFromWinnedHand(cards.get(i));
                        }
                    }
                }
            }
        }
        return null;
    }

    public Player setPlayerFromWinnedHand(Card card){

        Table table = new Table();

        if(table.getCardsOnTable().get(0) == card){
            return table.getPlayers().get(0);
        } else if(table.getCardsOnTable().get(1) == card){
            return table.getPlayers().get(1);
        } else if(table.getCardsOnTable().get(2) == card){
            return table.getPlayers().get(2);
        } else if(table.getCardsOnTable().get(3) == card){
            table.getPlayers().get(3);
        }
        return null;
    }

    public void hasAdut(boolean hasAdut){
        this.hasAdut = hasAdut;
    }
}
