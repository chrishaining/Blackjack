

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

    //get count of score (total value of cards in hand)
    public int getScore() {
        this.score = 0;
        if (this.countCardsInHand() > 0) {
            for (Card card : this.hand) {
                this.score += card.getValue();
            }
        }
        return this.score;
    }

    public void removeAllCards() {
        while (this.hand.size() > 0) {
            this.hand.remove(0);
        }
    }

// deal a card to a player. for this method, the dealer has access to a deck. I am uneasy that the dealer is able to use the getNextCard method - it sounds like the dealer can actually see the value of the card, which would be against the rules of blackjack. however, in the program the dealer does not actually see what the value of the card is).
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