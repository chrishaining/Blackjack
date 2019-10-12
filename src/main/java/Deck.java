import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public int countCards() {
        return this.cards.size();
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void add52Cards() {
        for (SuitType s : SuitType.values()) {
            for (RankType r : RankType.values()) {
//               ArrayList<Card>[i] = new Card(RankType r, SuitType s);
//                this.cards.add(r, s);
//                ArrayList<Card>[i] = new Card(r, s);
//                i++;
                Card card = new Card(s,r);
                this.addCard(card);
            }
        }

    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    public void removeCard() {
        this.cards.remove(0);
    }

    //method to get the card at index 0 (i.e. the card that is next in line to be dealt. I can't think of a way to test this. The reason I want this method is so that I can I can create a dealtCard variable in the dealer class.
    public Card getNextCard() {
        return this.cards.get(0);
    }
}

