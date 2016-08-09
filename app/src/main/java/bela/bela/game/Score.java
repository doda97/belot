package bela.bela.game;

/**
 * Created by dado on 29.04.16..
 * asd
 */

public class Score {

    private int weScore;
    private int youScore;

    public Score(int weScore, int youScore){
        this.weScore = this.weScore + weScore;
        this.youScore = this.youScore + youScore;
    }

    public int getWeScore(){
        return weScore;
    }

    public int getYouScore(){
        return youScore;
    }
}
