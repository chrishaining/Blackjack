import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DealerTest {

    private Dealer dealer;
    private Card card;
    private Deck deck;
    private Player player;

    @Before
    public void before() {
        dealer = new Dealer();
        card = new Card(SuitType.HEARTS, RankType.NINE);
        deck = new Deck();
        player = new Player("Mr Smith");

    }

    //test that the dealer has a hand of cards, and that the hand is empty to start
    @Test
    public void handIsEmptyAtStartOfGame() {
        assertEquals(0, dealer.countCardsInHand());
    }


    //test that the dealer can take a card, and this card is added to the hand
    @Test
    public void takeCard() {
        dealer.takeCard(card);
        assertEquals(1, dealer.countCardsInHand());
    }

    //test that the dealer has a score (the total value of cards in the player's hand) - starts at zero
    @Test
    public void scoreStartsAtZero() {
        assertEquals(0, dealer.getScore());
    }

    //test that the dealer's score matches the value of the cards in the dealer's hand
    @Test
    public void scoreIncreasesWhenCardIsAdded() {
        dealer.takeCard(card);
        assertEquals(9, dealer.getScore());
    }

    //test that the dealer's hand can be emptied
    @Test
    public void handIsZeroAfterHandIsEmptied() {
        dealer.takeCard(card);
        dealer.removeAllCards();
        assertEquals(0, dealer.countCardsInHand() );
    }

    //test that the score an be reset to zero - this doesn't need a new method, as emptying the hand should reset the score
    @Test
    public void scoreResetsToZeroWhenHandIsEmptied() {
        dealer.takeCard(card);
        dealer.removeAllCards();
        assertEquals(0, dealer.getScore());
    }

    //test that the dealer can deal a card from a deck of cards, to a player
    @Test
    public void canDealACard() {
        deck.add52Cards();
        dealer.dealCard(deck, player);
        assertEquals(51, deck.countCards());
        assertEquals(1, player.countCardsInHand());
    }

}

