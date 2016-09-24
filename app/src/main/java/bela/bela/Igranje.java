package bela.bela;

import android.content.pm.ActivityInfo;
import android.os.Handler;
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
        table.setLastPlayerOnMove(player1);
        table.setLastFirstPlayerOnMove(player1);

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
        adutImageViews.get(0).setAdutColor(CardColor.ZIR);
        adutImageViews.get(1).setAdutColor(CardColor.HERC);
        adutImageViews.get(2).setAdutColor(CardColor.BUNDEVA);
        adutImageViews.get(3).setAdutColor(CardColor.ZELENA);

        final Deck deck = new Deck();

        table.setDeck(deck);

        final CardImageView cardOne = (CardImageView) findViewById(R.id.p1b);
        final CardImageView cardTwo = (CardImageView) findViewById(R.id.p2b);
        final CardImageView cardThree = (CardImageView) findViewById(R.id.p3b);
        final CardImageView cardFour = (CardImageView) findViewById(R.id.p4b);

        final ArrayList<CardImageView> cardImageView = new ArrayList<>(4);
        cardImageView.add(cardOne);
        cardImageView.add(cardTwo);
        cardImageView.add(cardThree);
        cardImageView.add(cardFour);
        table.getPlayers().get(0).addPlayerCard(cardOne);
        table.getPlayers().get(1).addPlayerCard(cardTwo);
        table.getPlayers().get(2).addPlayerCard(cardThree);
        table.getPlayers().get(3).addPlayerCard(cardFour);

        final Button b = (Button)findViewById(R.id.next);

        b.setVisibility(View.VISIBLE);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b.setClickable(false);
                b.setVisibility(View.INVISIBLE);
                shuffleCards(table, playerButtons, adutImageViews, currentAdut, cardImageView);
            }
        });

    }

    public void shuffleCards(final Table table, final ArrayList<PlayerButton> playerButtons, final ArrayList<AdutImageView> adutImageViews, final AdutImageView currentAdut, final ArrayList<CardImageView> cardImageView) {

        ArrayList<Card> deck = table.getDeck().getShuffledDeck();

        List<Player> players = table.getPlayers();

        for(Player player:players) {
            for (int j = 0; j < 32; j = j + 8) {
                for (int i = 0; i < 8; i++) {
                    player.givePlayerCard(deck.get(i + j));
                }
            }
        }

        addCardsToButtons(table, playerButtons, adutImageViews, currentAdut, cardImageView);

    }

    public void addCardsToButtons(final Table table, final ArrayList<PlayerButton> playerButtons, final ArrayList<AdutImageView> adutImageViews, final AdutImageView currentAdut, final ArrayList<CardImageView> cardImageView) {

        for(Player player:table.getPlayers()){
            sortCards(player.getPlayerCards());
        }

        for(int i = 0;i<8;i++) {
            playerButtons.get(i).setVisibility(View.VISIBLE);
            playerButtons.get(i).setCard(table.getPlayers().get(0).getPlayerCards().get(i));
            playerButtons.get(i).setBackground(getResources().getDrawable(table.getPlayers().get(0).getPlayerCards().get(i).getImage()));
        }

        callingAdut(table, playerButtons, adutImageViews, currentAdut, cardImageView);

    }

    public void callingAdut(final Table table, final ArrayList<PlayerButton> playerButtons, final ArrayList<AdutImageView> adutImageViews, final AdutImageView currentAdut, final ArrayList<CardImageView> cardImageView) {

        for(final AdutImageView adutImageView:adutImageViews) {
            adutImageView.setVisibility(View.VISIBLE);
        }

        for(final AdutImageView adutImageView:adutImageViews){

            adutImageView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    table.setCurrentAdut(adutImageView.getAdutColor());
                    currentAdut.setAdutColor(adutImageView.getAdutColor());
                    currentAdut.setImageResource(adutImageView.getColorImage());
                    setAdutsToPlayersCards(table, playerButtons, adutImageViews, currentAdut, cardImageView);
                }

            });

        }

    }

    public void setAdutsToPlayersCards(final Table table, final ArrayList<PlayerButton> playerButtons, final ArrayList<AdutImageView> adutImageViews, final AdutImageView currentAdut, final ArrayList<CardImageView> cardImageView) {

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

        playWhileCardsLeft(table, playerButtons, adutImageViews, currentAdut, cardImageView);

    }

    public void playWhileCardsLeft(final Table table, final ArrayList<PlayerButton> playerButtons, final ArrayList<AdutImageView> adutImageViews, final AdutImageView currentAdut, final ArrayList<CardImageView> cardImageView) {

        table.updateColorPlayed();

        final Handler mHandler = new Handler();

        mHandler.postDelayed(new Runnable() {
            public void run() {
                doNothing();
            }
        }, 1000);

        for(final PlayerButton playerButton:playerButtons){
            playerButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (table.getPlayerOnMove() == table.getPlayers().get(0)) {
                        table.getPlayers().get(0).setPlayedCard(playerButton.getCard());
                        playerButton.setCard(null);
                        playerButton.setClickable(false);
                        if (table.getPlayers().get(1).getCardOnTable() == null) {
                            addScore(table, playerButtons, adutImageViews, currentAdut, cardImageView);
                            table.setPlayerOnMove(table.getPlayers().get(1));
                            othersPlay(table, playerButtons, adutImageViews, currentAdut, cardImageView);
                        } else {
                            addScore(table, playerButtons, adutImageViews, currentAdut, cardImageView);
                            if (table.getPlayerOnMove().getPlayerCards().size() > 0) {
                                int a = 0;
                                for (int i = 0; i < 4; i++) {
                                    for (Player player : table.getPlayers()) {
                                        if (table.getLastPlayerOnMove() == player) {
                                            a = i;
                                        }
                                    }
                                }
                                if (a > 3) {
                                    a = a - 4;
                                }
                                table.setPlayerOnMove(table.getPlayers().get(a));

                                if (table.getPlayerOnMove() == table.getPlayers().get(0)) {
                                    playWhileCardsLeft(table, playerButtons, adutImageViews, currentAdut, cardImageView);
                                } else {
                                    othersPlay(table, playerButtons, adutImageViews, currentAdut, cardImageView);
                                }
                            } else {
                                int a = 0;
                                for (int i = 0; i < 4; i++) {
                                    for (Player player : table.getPlayers()) {
                                        if (table.getLastFirstPlayerOnMove() == player) {
                                            a = i;
                                        }
                                    }
                                }
                                if (a > 3) {
                                    a = a - 4;
                                }
                                table.setPlayerOnMove(table.getPlayers().get(a));

                                if (table.getPlayerOnMove() == table.getPlayers().get(0)) {
                                    playWhileCardsLeft(table, playerButtons, adutImageViews, currentAdut, cardImageView);
                                } else {
                                    othersPlay(table, playerButtons, adutImageViews, currentAdut, cardImageView);
                                }
                            }
                        }
                    } else {
                        othersPlay(table, playerButtons, adutImageViews, currentAdut, cardImageView);
                    }
                }
            });
        }
    }

    public void othersPlay(final Table table, final ArrayList<PlayerButton> playerButtons, final ArrayList<AdutImageView> adutImageViews, AdutImageView currentAdut, final ArrayList<CardImageView> cardImageView) {

        final Handler mHandler = new Handler();

        mHandler.postDelayed(new Runnable() {
            public void run() {
                doNothing();
            }
        }, 1000);

        table.updateColorPlayed();

        Player thisTimePlayerOnMove = table.getPlayerOnMove();

        Card card = table.getPlayerOnMove().play(table, thisTimePlayerOnMove);

        for (Card playedCard : table.getPlayerOnMove().getPlayerCards()) {
            if (playedCard == card) {
                playedCard = null;
            }
        }

        table.getPlayerOnMove().setPlayedCard(card);

        boolean bool = false;

        for (Player player : table.getPlayers()) {
            if (player == table.getPlayers().get(3)) {
                table.setPlayerOnMove(table.getPlayers().get(0));
                break;
            }
            if (bool) {
                table.setPlayerOnMove(player);
                break;
            } else {
                if (player == thisTimePlayerOnMove) {
                    bool = true;
                }
            }
        }

        playWhileCardsLeft(table, playerButtons, adutImageViews, currentAdut, cardImageView);

    }

    public int addScore(final Table table, final ArrayList<PlayerButton> playerButtons, final ArrayList<AdutImageView> adutImageViews, AdutImageView currentAdut, final ArrayList<CardImageView> cardImageView) {
        return 1;
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

    public void doNothing() {
    }
}