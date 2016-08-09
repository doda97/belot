package bela.bela.logic;

import java.util.List;

import bela.bela.cards.Card;
import bela.bela.game.Table;
import bela.bela.player.Player;
import bela.bela.player.PlayerButton;

/**
 * Created by dado on 11.05.16..
 * if player card respect game set it clickable
 */

public class HumanRespecting {

    Table table = new Table();

    public void setClickableCards(Player player){
        for(PlayerButton playerButton: player.getPlayerButtons()){
            if(haveColor(player.getPlayerCards())){
                if(playerButton.getCard().getCardColor()==table.getCardsOnTable().get(0).getCardColor()){
                    playerButton.setClickable(true);
                    playerButton.setY(10);
                }
            } else if(!haveColor(player.getPlayerCards())&&haveAdut(player.getPlayerCards())){
                if(playerButton.getCard().isAdut()==table.getCardsOnTable().get(0).isAdut()){
                    playerButton.setClickable(true);
                    playerButton.setY(10);
                }
            } else {
                playerButton.setClickable(true);
                playerButton.setY(10);
            }
        }
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
}
