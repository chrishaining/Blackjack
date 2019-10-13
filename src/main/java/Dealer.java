import java.util.ArrayList;

import java.util.Random;

public class Dealer {

    private String name;
    private ArrayList<Card> hand;
    private int score;
    private Random randomGenerator;

    public Dealer() {
        this.name = "Der Dealer";
        this.hand = new ArrayList<Card>();
        this.score = 0;
        this.randomGenerator = new Random();
    }



    public String getname() {
        return this.name;
    }

    public int countCardsInHand() {
        return this.hand.size();
    }

    public void takeCard(Card card) {
        this.hand.add(card);
    }

    //randomly choose one of the dealer's cards to show - I don't think I can test this very effectively, as I wont know what value to expect. I could possibly check that the result is the correct data type.
    public String showRandomCardFromHand() {
        int index = randomGenerator.nextInt(this.hand.size());
        Card faceUpCard = this.hand.get(index);
        String faceUpCardDetails = faceUpCard.showcardDetails();
        return faceUpCardDetails;
    }

    public String showCards() {
        String firstCard =  this.hand.get(0).showcardDetails();
        String secondCard = this.hand.get(1).showcardDetails();
        return String.format("The dealer's first card is %s ... The dealer's second card is %s", firstCard, secondCard);
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
//
        }
        return this.score;
    }

    public void removeAllCards() {
        while (this.hand.size() > 0) {
            this.hand.remove(0);
        }
    }

    public void dealCardToPlayer(Deck deck, Player player) {
        Card dealtCard = deck.getNextCard();
        deck.removeCard();
        player.takeCard(dealtCard);
    }

    public void dealCardToSelf(Deck deck) {
        Card dealtCard = deck.getNextCard();
        deck.removeCard();
        this.takeCard(dealtCard);
    }

    public ArrayList showHand() {
        return this.hand;
    }

}