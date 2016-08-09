package bela.bela.deck;

import java.util.ArrayList;
import java.util.Collections;

import bela.bela.cards.Card;
import bela.bela.cards.CardColor;
import bela.bela.cards.CardType;

/**
 * Created by dado on 16.04.16..
 */
public class Deck {

    private static final int BROJ_KARTI = 32;

    private final ArrayList<Card> deck = new ArrayList<Card>(BROJ_KARTI);

    public Deck(){
        init();
    }

    private void init(){

        deck.add(new Card(CardColor.BUNDEVA, CardType.SEDMICA));
        deck.add(new Card(CardColor.BUNDEVA, CardType.OSMICA));
        deck.add(new Card(CardColor.BUNDEVA, CardType.DEVETKA));
        deck.add(new Card(CardColor.BUNDEVA, CardType.DESETKA));
        deck.add(new Card(CardColor.BUNDEVA, CardType.DECKO));
        deck.add(new Card(CardColor.BUNDEVA, CardType.BABA));
        deck.add(new Card(CardColor.BUNDEVA, CardType.KRALJ));
        deck.add(new Card(CardColor.BUNDEVA, CardType.AS));
        deck.add(new Card(CardColor.ZELENA, CardType.SEDMICA));
        deck.add(new Card(CardColor.ZELENA, CardType.OSMICA));
        deck.add(new Card(CardColor.ZELENA, CardType.DEVETKA));
        deck.add(new Card(CardColor.ZELENA, CardType.DESETKA));
        deck.add(new Card(CardColor.ZELENA, CardType.DECKO));
        deck.add(new Card(CardColor.ZELENA, CardType.BABA));
        deck.add(new Card(CardColor.ZELENA, CardType.KRALJ));
        deck.add(new Card(CardColor.ZELENA, CardType.AS));
        deck.add(new Card(CardColor.HERC, CardType.SEDMICA));
        deck.add(new Card(CardColor.HERC, CardType.OSMICA));
        deck.add(new Card(CardColor.HERC, CardType.DEVETKA));
        deck.add(new Card(CardColor.HERC, CardType.DESETKA));
        deck.add(new Card(CardColor.HERC, CardType.DECKO));
        deck.add(new Card(CardColor.HERC, CardType.BABA));
        deck.add(new Card(CardColor.HERC, CardType.KRALJ));
        deck.add(new Card(CardColor.HERC, CardType.AS));
        deck.add(new Card(CardColor.ZIR, CardType.SEDMICA));
        deck.add(new Card(CardColor.ZIR, CardType.OSMICA));
        deck.add(new Card(CardColor.ZIR, CardType.DEVETKA));
        deck.add(new Card(CardColor.ZIR, CardType.DESETKA));
        deck.add(new Card(CardColor.ZIR, CardType.DECKO));
        deck.add(new Card(CardColor.ZIR, CardType.BABA));
        deck.add(new Card(CardColor.ZIR, CardType.KRALJ));
        deck.add(new Card(CardColor.ZIR, CardType.AS));
    }

    public ArrayList<Card> getShuffledDeck() {
        Collections.shuffle(deck);
        return deck;
    }
}
