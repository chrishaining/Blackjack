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

    @Test
    public void hasPlayer() {
        assertEquals("Mr Smith", game.getPlayerName());
    }

    @Test
    public void hasDealer() {
        assertTrue(game.checksThereIsADealer());
    }

    @Test
    public void deckStartsEmpty() {
        assertEquals(0, game.countCardsInDeck());
    }

    @Test
    public void deckHas52CardsWhenFilled() {
        game.fillTheDeck();
        assertEquals(52, game.countCardsInDeck() );
    }

    @Test
    public void dealsTwoCardsToEachParticipant() {
        game.fillTheDeck();
        game.deal();
        Dealer dealer = game.getDealer();
        assertEquals(2, player.countCardsInHand());
        assertEquals(2, dealer.countCardsInHand());
    }

    @Test
    public void canGetScores() {
        game.fillTheDeck();
        game.deal();
        assertEquals(6, player.getScore());
        assertEquals(8, game.getDealerScore());

    }

    @Test
    public void canAnnounceWinner() {
        game.fillTheDeck();
        game.deal();;
//        game.play();
        assertEquals("Der Dealer is the winner. Try again.", game.getResult());
    }

}
