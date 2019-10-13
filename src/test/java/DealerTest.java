import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Card card;
    private Card card2;
    private Deck deck;
    private Player player;

    @Before
    public void before() {
        dealer = new Dealer();
        card = new Card(SuitType.HEARTS, RankType.NINE);
        card2 = new Card(SuitType.HEARTS, RankType.ACE);
        deck = new Deck();
        player = new Player("Mr Smith");

    }

    @Test
    public void hasName() {
        assertEquals("Der Dealer", dealer.getname());
    }

    @Test
    public void handIsEmptyAtStartOfGame() {
        assertEquals(0, dealer.countCardsInHand());
    }

    @Test
    public void takeCard() {
        dealer.takeCard(card);
        assertEquals(1, dealer.countCardsInHand());
    }

    @Test
    public void scoreStartsAtZero() {
        assertEquals(0, dealer.getScore());
    }

    @Test
    public void scoreIncreasesWhenCardIsAdded() {
        dealer.takeCard(card);
        dealer.takeCard(card2);
        assertEquals(20, dealer.getScore());
    }

    @Test
    public void handIsZeroAfterHandIsEmptied() {
        dealer.takeCard(card);
        dealer.removeAllCards();
        assertEquals(0, dealer.countCardsInHand() );
    }

    @Test
    public void scoreResetsToZeroWhenHandIsEmptied() {
        dealer.takeCard(card);
        dealer.removeAllCards();
        assertEquals(0, dealer.getScore());
    }

    @Test
    public void canDealACard() {
        deck.add52Cards();
        dealer.dealCardToPlayer(deck, player);
        assertEquals(51, deck.countCards());
        assertEquals(1, player.countCardsInHand());
    }

    @Test
    public void canDealACardToSelf() {
        deck.add52Cards();
        dealer.dealCardToSelf(deck);
        assertEquals(51, deck.countCards());
        assertEquals(1, dealer.countCardsInHand());
    }

}

