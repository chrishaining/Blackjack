

import java.util.ArrayList;

public class Dealer {

    //instance variables
    private String name;
    private ArrayList<Card> hand;
    private int score;

    //constructor
    public Dealer() {
        this.name = "Der Dealer";
        this.hand = new ArrayList<Card>();
        this.score = 0;
    }

    //getter - get name (the dealer has a name to make it easier for the game to announce a winner
    public String getname() {
        return this.name;
    }

    //getter - count the number of cards in the dealer's hand
    public int countCardsInHand() {
        return this.hand.size();
    }

    //take a card
    public void takeCard(Card card) {
        this.hand.add(card);
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