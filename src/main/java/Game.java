public class Game {

    //instance variables
    private Player player;
    private Dealer dealer;
    private Deck deck;
    private String result;

    //constructor
    public Game(Player player) {
        this.player = player;
        this.dealer = new Dealer();
        this.deck = new Deck();
        this.result = null;
    }

    //gets the name of the player
    public String getPlayerName() {
        return this.player.getName();
    }

    //checks there is a dealer. Seems a bit pointless to have this method, and I've created the method just so that I can test it.
    public boolean checksThereIsADealer() {
        return this.dealer != null;
    }

    //gets a dealer - again, this is only so I can test this.
    public Dealer getDealer() {
        return this.dealer;
    }

    //adds 52 cards to the deck
    public void fillTheDeck() {
        this.deck.add52Cards();
    }

    //getter - can count the cards in the deck
    public int countCardsInDeck() {
        return this.deck.countCards();
    }

    //deals cards
    public void deal() {
        Deck deck = this.deck;
        Player player = this.player;
        while (this.player.countCardsInHand() < 2 && this.dealer.countCardsInHand() < 2) {
            this.dealer.dealCardToPlayer(deck, player);
            this.dealer.dealCardToSelf(deck);
        }
    }

    public String showPlayerHand() {
        return this.player.showCards();
    }

    public String showDealerHand() {
        return this.dealer.showCards();
    }

    //gets dealer score
    public int getDealerScore() {
        return this.dealer.getScore();
    }




    //gets player and dealer scores, and calculates a winner.
//    public void announceWinner() {
//        int playerScore = this.player.getScore();
//        int dealerScore = this.dealer.getScore();
//        if (playerScore > dealerScore) {
//            return String.format("%s is the winner", this.player.getName());
//        } else if (dealerScore > playerScore) {
//            return String.format("%s is the winner", this.dealer.getname());
//        } else {return "It is a draw";}
//    }

    //decide what to do if the values of player's hand and dealer's hand are the same
//    public void checkForBlackJack() {
//        this.showDealerHand();
//        this.showPlayerHand();
//        if
//    }


    public void decideWinner() {
        int playerScore = this.player.getScore();
        int dealerScore = this.dealer.getScore();
        if (playerScore > dealerScore) {
//            this.result = String.format("%s is the winner", this.player.getName());
            this.result = "You won! Congratulations!";
        } else if (dealerScore > playerScore) {
            this.result = String.format("%s is the winner. Try again.", this.dealer.getname());
        } else {this.result = "It is a draw";}
    }

    public String getResult() {
        this.decideWinner();
        return this.result;
    }

    //overarching "play game" method that takes in several other methods
    // fill the deck
    // shuffle the deck
    // deal
    // announce winner


    public void play() {
        this.fillTheDeck();
        this.deck.shuffle();
        this.deal();
        this.decideWinner();
    }

}







