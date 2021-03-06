import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card>hand;
    private int score;

    public Player (String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.score = 0;
    }

    public String getName() {
        return this.name;
    }

    public int countCardsInHand() {
        return this.hand.size();
    }

    public void takeCard(Card card) {
        this.hand.add(card);
    }

    public ArrayList showHand() {
        return this.hand;
    }

    public int getScore() {
        if (this.countCardsInHand() > 0) {
            Card cardA = this.hand.get(0);
            Card cardB = this.hand.get(1);
            if (cardA.getRank() == RankType.ACE && cardB.getRank() == RankType.ACE) {
                int cardAScore = 1;
                int cardBScore = cardB.getValue();
                this.score = cardAScore + cardBScore;
            } else {
                this.score = cardA.getValue() + cardB.getValue();
            }
        }
        return this.score;
    }

    public String showCards() {
        String firstCard =  this.hand.get(0).showcardDetails();
        String secondCard = this.hand.get(1).showcardDetails();
        return String.format("Your first card is %s. Your second card is %s", firstCard, secondCard);
    }

    public void removeAllCards() {
        while (this.hand.size() > 0) {
            this.hand.remove(0);
        }
    }

}
