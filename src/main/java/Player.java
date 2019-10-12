import java.util.ArrayList;

public class Player {

    //declare instance variables
    private String name;
    private ArrayList<Card>hand;
    private int score;


    //constructor
    public Player (String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.score = 0;
    }

    //get name
    public String getName() {
        return this.name;
    }

    //get count of number of cards in hand
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

    public ArrayList showHand() {
        return this.hand;
    }

    //remove all cards from the player's hand - THIS METHOD PASSES THE TEST, BUT I'M NOT SURE IF IT IS ACTUALLY REMOVING THE CARDS. I LIKE LESS CODE, SO I WILL KEEP IT LIKE THIS UNLESS IT BREAKS OTHER PARTS OF THE PROGRAM. (other option is to have a for/while loop that removes the card at index position 0, and only stops when the array is empty and/or index 0 is null. SO, IT DID CAUSE SOMETHING ELSE TO BREAK - THE SCORE DIDN'T RETURN TO ZERO. SO I HAVE CHANGED THE CODE
//    public int removeAllCards() {
//        this.hand.size() = 0;
//        return this.countCardsInHand();
//    }
    public void removeAllCards() {
        while (this.hand.size() > 0) {
            this.hand.remove(0);
        }
    }

}
