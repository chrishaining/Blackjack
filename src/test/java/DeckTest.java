import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    private Deck deck;
    private Card card;

    @Before
    public void before(){
        deck = new Deck();
        card = new Card(SuitType.SPADES, RankType.ACE);
    }

    @Test
    public void deckStartsEmpty(){
        assertEquals(0, deck.countCards());
    }

    @Test
    public void canAddOneCard() {
        deck.addCard(card);
        assertEquals(1, deck.countCards());
    }

    @Test
    public void canAdd52Cards() {
        deck.add52Cards();
        assertEquals(52, deck.countCards());
    }

    @Test
    public void canRemoveCardFromDeck() {
        deck.add52Cards();
        deck.removeCard();
        assertEquals(51, deck.countCards());
    }

}
