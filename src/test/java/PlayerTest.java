import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    private Player player;
    private Card card;
    private Card card2;

    @Before
    public void before() {
        player = new Player("Mr Smith");
        card = new Card(SuitType.HEARTS, RankType.ACE);
        card2 = new Card(SuitType.CLUBS, RankType.ACE);

    }

    @Test
    public void hasName() {
        assertEquals("Mr Smith", player.getName());
    }

    @Test
    public void handIsEmptyAtStartOfGame() {
        assertEquals(0, player.countCardsInHand());
    }

    @Test
    public void takeCard() {
        player.takeCard(card);
        assertEquals(1, player.countCardsInHand());
    }

    @Test
    public void scoreStartsAtZero() {
        assertEquals(0, player.getScore());
    }

    @Test
    public void scoreIncreasesWhenCardIsAdded() {
        player.takeCard(card);
        player.takeCard(card2);

        assertEquals(12, player.getScore());
    }

    @Test
    public void handIsZeroAfterHandIsEmptied() {
        player.takeCard(card);
        player.removeAllCards();
        assertEquals(0, player.countCardsInHand() );
    }

    @Test
    public void scoreResetsToZeroWhenHandIsEmptied() {
        player.takeCard(card);
        player.removeAllCards();
        assertEquals(0, player.getScore());
    }

}