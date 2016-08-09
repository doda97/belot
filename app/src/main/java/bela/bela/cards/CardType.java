package bela.bela.cards;

/**
 * Created by dado on 16.04.16..
 */
public enum CardType {

    SEDMICA(1),
    OSMICA(2),
    DEVETKA(3),
    DESETKA(4),
    DECKO(5),
    BABA(6),
    KRALJ(7),
    AS(8);

    private final int rank;

    CardType(int rank){
        this.rank = rank;
    }

    public int getRank(){
        return rank;
    }
}
