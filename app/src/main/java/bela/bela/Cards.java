package bela.bela;

import java.util.ArrayList;

public class Cards {

    private static final int BROJ_KARTI = 32;

    private static ArrayList<Integer> karta = new ArrayList<>(BROJ_KARTI);

    static {
        karta.add(0, R.drawable.bucasedam);
        karta.add(1, R.drawable.bucaosam);
        karta.add(2, R.drawable.bucadevet);
        karta.add(3, R.drawable.bucadeset);
        karta.add(4, R.drawable.bucadecko);
        karta.add(5, R.drawable.bucababa);
        karta.add(6, R.drawable.bucakralj);
        karta.add(7, R.drawable.bucaas);
        karta.add(8, R.drawable.zelenasedmica);
        karta.add(9, R.drawable.zelenaosmica);
        karta.add(10, R.drawable.zelenadeva);
        karta.add(11, R.drawable.zelenacenka);
        karta.add(12, R.drawable.zelenidecko);
        karta.add(13, R.drawable.zelenababa);
        karta.add(14, R.drawable.zelenikralj);
        karta.add(15, R.drawable.zelenias);
        karta.add(16, R.drawable.hercsedmica);
        karta.add(17, R.drawable.hercosmica);
        karta.add(18, R.drawable.hercdeva);
        karta.add(19, R.drawable.srcedesetka);
        karta.add(20, R.drawable.hercdecko);
        karta.add(21, R.drawable.srcebaba);
        karta.add(22, R.drawable.herckralj);
        karta.add(23, R.drawable.hercas);
        karta.add(24, R.drawable.zirsedmica);
        karta.add(25, R.drawable.zirosmica);
        karta.add(26, R.drawable.zirdeva);
        karta.add(27, R.drawable.zircener);
        karta.add(28, R.drawable.zirdecko);
        karta.add(29, R.drawable.zirbaba);
        karta.add(30, R.drawable.zirkralj);
        karta.add(31, R.drawable.ziras);
    }

    public static int getKarte(int broj){
        return karta.get(broj);
    }
}
