package bela.bela.game;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import bela.bela.R;
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

    public int getColorImage() {
        if (adut == CardColor.BUNDEVA) {
            return R.drawable.bucaadut;
        } else if (adut == CardColor.HERC) {
            return R.drawable.hercadut;
        } else if (adut == CardColor.ZELENA) {
            return R.drawable.zelenaadut;
        } else if (adut == CardColor.ZIR) {
            return R.drawable.ziradut;
        } else {
            return 0;
        }
    }
}
