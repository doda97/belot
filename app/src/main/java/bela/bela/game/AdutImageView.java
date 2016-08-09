package bela.bela.game;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import bela.bela.cards.CardColor;

/**
 * Created by dado on 12.05.16..
 * Image view with adut image, and card color.
 */

public class AdutImageView extends ImageView {

    private CardColor adut;

    public AdutImageView(Context context) {
        super(context);
    }

    public AdutImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AdutImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setAdutColor(CardColor adut){
        this.adut = adut;
    }

    public CardColor getAdutColor(){
        return adut;
    }
}
