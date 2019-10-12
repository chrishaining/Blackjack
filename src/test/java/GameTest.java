import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private Game game;
    private Player player;

    @Before
    public void before() {
        player = new Player("Mr Smith");
        game = new Game(player);
    }

    //the game must have a player
    @Test
    public void hasPlayer() {
        assertEquals("Mr Smith", game.getPlayerName());
    }

    //the game must have a dealer
    @Test
    public void hasDealer() {
        assertTrue(game.checksThereIsADealer());
    }

    //the game must have a deck of cards, and this must start empty
    @Test
    public void deckStartsEmpty() {
        assertEquals(0, game.countCardsInDeck());
    }


    //the deck must have 52 cards upon filling the deck
@Test
    public void deckHas52CardsWhenFilled() {
        game.fillTheDeck();
        assertEquals(52, game.countCardsInDeck() );
}

    //the game must be able to get the dealer to deal two cards to the player, and two cards to himself/herself (the dealer)
    @Test
    public void dealsTwoCardsToEachParticipant() {
        game.fillTheDeck();
        game.deal();
        Dealer dealer = game.getDealer();
        assertEquals(2, player.countCardsInHand());
        assertEquals(2, dealer.countCardsInHand());
    }


//the game must be able to see the hands of the dealer and the player


    //the game must be able to count the value of the dealer's score, and the value of the player's score


    //the game must be able to decide who wins

}
