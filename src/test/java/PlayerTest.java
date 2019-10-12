import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class PlayerTest {

    private Player player;
    private Card card;

    @Before
    public void before() {
        player = new Player("Mr Smith");
        card = new Card(SuitType.HEARTS, RankType.NINE);
    }

    //test that the player has a name
    @Test
    public void hasName() {
        assertEquals("Mr Smith", player.getName());
    }

    //test that the player has a hand of cards, and that the hand is empty to start
    @Test
    public void handIsEmptyAtStartOfGame() {
        assertEquals(0, player.countCardsInHand());
    }

    //test that the player can take a card, and this card is added to the hand
    @Test
    public void takeCard() {
        player.takeCard(card);
        assertEquals(1, player.countCardsInHand());
    }

    //test that the player has a score (the total value of cards in the player's hand) - starts at zero
    @Test
    public void scoreStartsAtZero() {
        assertEquals(0, player.getScore());
    }

    //test that the player's score matches the value of the cards in the player's hand
    @Test
    public void scoreIncreasesWhenCardIsAdded() {
        player.takeCard(card);
        assertEquals(9, player.getScore());
    }

    //test that the player's hand can be emptied
    @Test
    public void handIsZeroAfterHandIsEmptied() {
        player.takeCard(card);
        player.removeAllCards();
        assertEquals(0, player.countCardsInHand() );
    }

    //test that the score an be reset to zero - this doesn't need a new method, as emptying the hand should reset the score
    @Test
    public void scoreResetsToZeroWhenHandIsEmptied() {
        player.takeCard(card);
        player.removeAllCards();
        assertEquals(0, player.getScore());
    }

}