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
        Card newCard = card;
    }

    public ArrayList showHand() {
        return this.hand;
    }

//    public int getScore() {
//        if (this.countCardsInHand() > 0) {
//            Card cardA = this.hand.get(0);
//            Card cardB = this.hand.get(1);
//            if (cardA.getRank() == RankType.ACE && cardB.getRank() == RankType.ACE) {
//                int cardAScore = 1;
//                int cardBScore = cardB.getValue();
//                this.score = cardAScore + cardBScore;
//            } else {
//                this.score = cardA.getValue() + cardB.getValue();
//            }
//        }
//        return this.score;
//    }

    public int getScore() {
        for (Card card : this.hand) {

        }
    }


//    public String showCards() {
//        String firstCard = this.hand.get(0).showcardDetails();
//        String secondCard = this.hand.get(1).showcardDetails();
//        return String.format("Your first card is %s. Your second card is %s", firstCard, secondCard);
//    }

    public String removeLastCharacters(String string) {
        return (string == null || string.length() == 0)
                ? null
                : (string.substring(0, string.length() - 2));
    }

    public String showCards() {
        String totalString = "Your cards are: ";
        for (Card card : this.hand) {
            totalString += String.format("%s, ", card.showCardDetails());
//            return String.format("%s", card.showCardDetails();
        }
        return this.removeLastCharacters(totalString);
    }




    public String showNewCard(Card card ) {
        return String.format("Your new card is %s", card.showCardDetails());
    }


    public void removeAllCards() {
        while (this.hand.size() > 0) {
            this.hand.remove(0);
        }
    }


}
