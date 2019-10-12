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


    //the game should be able to see the hands of the dealer and the player. If we shuffle the cards, I don't think I can test this. So, what I can do is test it on an unshuffled pack. ACTUALLY, IT IS NOT NECESSARY TO SEE THE HANDS. ONLY THE SCORES.
//    @Test
//    public void canViewTheHandsOfDealerAndPlayer() {
//        game.fillTheDeck();
//        game.deal();
//        assertEquals(SuitType.HEARTS, player.showHand());
//    }

    //the game must be able to count the value of the dealer's score, and the value of the player's score. Again, I will test this on an unshuffled pack. We have separate methods for getScore in the player and dealer class, so the game can use those.
    @Test
    public void canGetScores() {
        game.fillTheDeck();
        game.deal();
        assertEquals(6, player.getScore());
        assertEquals(8, game.getDealerScore());

    }

    //the game must be able to decide who wins.
    @Test
    public void canAnnounceWinner() {
        game.fillTheDeck();
        game.deal();
        assertEquals("Der Dealer is the winner", game.announceWinner());
    }

}
