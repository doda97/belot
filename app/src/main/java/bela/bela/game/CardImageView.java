package bela.bela.game;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import bela.bela.cards.Card;

/**
 * Created by dado on 02.05.16..
 * Card addable ImageView
 */

public class CardImageView extends ImageView {

    private Card card;

    public CardImageView(Context context) {
        super(context);
    }

    public CardImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CardImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setCard(Card card){
        setImageResource(card.getImage());
        this.card = card;
    }

    public Card getCard() {
        return card;
    }
}
