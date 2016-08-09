package bela.bela;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import bela.bela.cards.Card;
import bela.bela.cards.CardColor;
import bela.bela.deck.Deck;
import bela.bela.game.AdutImageView;
import bela.bela.game.CardImageView;
import bela.bela.game.Table;
import bela.bela.player.Player;
import bela.bela.player.PlayerButton;
import bela.bela.player.PlayerDroid;
import bela.bela.player.PlayerHuman;

public class Igranje extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bela);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        final PlayerButton k1 = (PlayerButton) findViewById(R.id.K1);
        final PlayerButton k2 = (PlayerButton) findViewById(R.id.K2);
        final PlayerButton k3 = (PlayerButton) findViewById(R.id.K3);
        final PlayerButton k4 = (PlayerButton) findViewById(R.id.K4);
        final PlayerButton k5 = (PlayerButton) findViewById(R.id.K5);
        final PlayerButton k6 = (PlayerButton) findViewById(R.id.K6);
        final PlayerButton k7 = (PlayerButton) findViewById(R.id.K7);
        final PlayerButton k8 = (PlayerButton) findViewById(R.id.K8);

        final ArrayList<PlayerButton> playerButtons = new ArrayList<>();

        playerButtons.add(k1);
        playerButtons.add(k2);
        playerButtons.add(k3);
        playerButtons.add(k4);
        playerButtons.add(k5);
        playerButtons.add(k6);
        playerButtons.add(k7);
        playerButtons.add(k8);

        final Table table = new Table();

        final Player player1 = new PlayerHuman("Player 1");
        final Player player2 = new PlayerDroid("Player 2");
        final Player player3 = new PlayerDroid("Player 3");
        final Player player4 = new PlayerDroid("Player 4");

        table.addPlayer(player1);
        table.addPlayer(player2);
        table.addPlayer(player3);
        table.addPlayer(player4);
        table.setPlayerOnMove(player1);

        final AdutImageView zirAadut = (AdutImageView)findViewById(R.id.adutzir);
        final AdutImageView zelenaAdut = (AdutImageView)findViewById(R.id.adutzelena);
        final AdutImageView bucaAdut = (AdutImageView) findViewById(R.id.adutbundeva);
        final AdutImageView hercAdut = (AdutImageView) findViewById(R.id.adutherc);
        final AdutImageView currentAdut = (AdutImageView) findViewById(R.id.currentadut);

        final ArrayList<AdutImageView> adutImageViews = new ArrayList<>();
        adutImageViews.add(zirAadut);
        adutImageViews.add(zelenaAdut);
        adutImageViews.add(bucaAdut);
        adutImageViews.add(hercAdut);

        final Deck deck = new Deck();

        table.setDeck(deck);

        final CardImageView cardOne = (CardImageView) findViewById(R.id.p1b);
        final CardImageView cardTwo = (CardImageView) findViewById(R.id.p2b);
        final CardImageView cardThree = (CardImageView) findViewById(R.id.p3b);
        final CardImageView cardFour = (CardImageView) findViewById(R.id.p4b);

        table.addCardOnTableImage(cardOne);
        table.addCardOnTableImage(cardTwo);
        table.addCardOnTableImage(cardThree);
        table.addCardOnTableImage(cardFour);

        final Button b = (Button)findViewById(R.id.next);

        b.setVisibility(View.VISIBLE);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setClickable(false);
                b.setVisibility(View.INVISIBLE);
                shuffleCards(table, playerButtons, adutImageViews, currentAdut);
            }
        });

    }

    public void shuffleCards(final Table table, final ArrayList<PlayerButton> playerButtons, final ArrayList<AdutImageView> adutImageViews,final AdutImageView currentAdut){

        ArrayList<Card> deck = table.getDeck().getShuffledDeck();

        List<Player> players = table.getPlayers();

        for(Player player:players) {
            for(int i = 0;i<8;i++) {
                player.addPlayerCard(deck.get(i));
            }
        }

        addCardsToButtons(table, playerButtons, adutImageViews, currentAdut);

    }

    public void addCardsToButtons(final Table table, final ArrayList<PlayerButton> playerButtons, final ArrayList<AdutImageView> adutImageViews,final AdutImageView currentAdut){

        for(Player player:table.getPlayers()){
            sortCards(player.getPlayerCards());
        }

        for(int i = 0;i<8;i++) {
            playerButtons.get(i).setVisibility(View.VISIBLE);
            playerButtons.get(i).setCard(table.getPlayers().get(0).getPlayerCards().get(i));
            playerButtons.get(i).setBackground(getResources().getDrawable(table.getPlayers().get(0).getPlayerCards().get(i).getImage()));
        }

        callingAdut(table, playerButtons, adutImageViews, currentAdut);

    }

    public void callingAdut(final Table table, final ArrayList<PlayerButton> playerButtons, final ArrayList<AdutImageView> adutImageViews,final  AdutImageView currentAdut){

        for(final AdutImageView adutImageView:adutImageViews) {
            adutImageView.setVisibility(View.VISIBLE);
        }

        for(final AdutImageView adutImageView:adutImageViews){

            adutImageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    table.setCurrentAdut(adutImageView.getAdutColor());
                    setAdutsToPlayersCards(table, playerButtons, adutImageViews, currentAdut);

                }

            });

        }

    }

    public void setAdutsToPlayersCards(final Table table, final ArrayList<PlayerButton> playerButtons,final ArrayList<AdutImageView> adutImageViews, AdutImageView currentAdut){

        for (final AdutImageView adutImageView : adutImageViews){
            adutImageView.setVisibility(View.INVISIBLE);
        }

        for (Player player : table.getPlayers()) {
            for (Card card : player.getPlayerCards()) {
                if (card.getCardColor() == table.getCurrentAdut()) {
                    card.setAdut(true);
                }
            }
        }

        playWhileCardsLeft(table, playerButtons, adutImageViews, currentAdut);

    }

    public void playWhileCardsLeft(final Table table, final ArrayList<PlayerButton> playerButtons, final ArrayList<AdutImageView> adutImageViews, AdutImageView currentAdut){

        for(final PlayerButton playerButton:playerButtons){
            playerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    table.setCardOnTable(playerButton.getCard());
                }
            });
        }

        for(Player player:table.getPlayers()){
            if(player.getPlayerCards().size()==0){
                addScore(table,playerButtons, adutImageViews, currentAdut);
            }
        }

    }

    public void addScore(final Table table, final ArrayList<PlayerButton> playerButtons,final ArrayList<AdutImageView> adutImageViews, AdutImageView currentAdut){

    }

    public List<Card> sortCards(List<Card> playerCards){

        List<Card> list = new ArrayList<>(8);

        list.addAll(playerCards);

        Comparator<Card> comparator = new Comparator<Card>() {

            public int compare(Card c1, Card c2) {

                if(c1.getCardColor()== CardColor.BUNDEVA&&c2.getCardColor()==CardColor.HERC){
                    return 1;
                }else if(c1.getCardColor()==CardColor.BUNDEVA&&c2.getCardColor()==CardColor.ZELENA){
                    return 1;
                }else if(c1.getCardColor()==CardColor.BUNDEVA&&c2.getCardColor()==CardColor.ZIR){
                    return 1;
                }else if (c1.getCardColor()==CardColor.ZIR&&c2.getCardColor()==CardColor.HERC){
                    return 1;
                } else if(c1.getCardColor()==CardColor.ZIR&&c2.getCardColor()==CardColor.ZELENA){
                    return 1;
                } else if(c1.getCardColor()==CardColor.HERC&&c2.getCardColor()==CardColor.ZELENA){
                    return 1;
                }else{
                    return -1;
                }
            }
        };

        Collections.sort(list, comparator);

        return list;

    }
}