package bela.bela.player;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

import bela.bela.cards.Card;

public class PlayerButton extends ImageButton {

    private Card card;

    public PlayerButton(Context context) {
        super(context);
    }

    public PlayerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PlayerButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setCard(Card card) {
        setBackground(getResources().getDrawable(card.getImage()));
        this.card = card;
    }

    public Card getCard(){
        return card;
    }

}

