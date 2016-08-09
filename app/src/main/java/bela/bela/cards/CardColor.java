package bela.bela.cards;

import java.util.ArrayList;

import bela.bela.R;

public enum CardColor {

    BUNDEVA,
    HERC,
    ZELENA,
    ZIR;

    private static ArrayList<Integer> cardColor = new ArrayList<>(4);

    static {
        cardColor.add(R.drawable.bucaadut);
        cardColor.add(R.drawable.hercadut);
        cardColor.add(R.drawable.zelenaadut);
        cardColor.add(R.drawable.ziradut);
    }

    public int getImage(){

        int a = -1;

        switch(CardColor.values()[0]) {
            case BUNDEVA:
                a = 0;
                break;
            case HERC:
                a = 1;
                break;
            case ZELENA:
                a = 2;
                break;
            case ZIR:
                a = 3;
                break;
        }

        return cardColor.get(a);

    }
}
