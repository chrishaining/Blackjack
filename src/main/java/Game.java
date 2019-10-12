public class Game {

    //instance variables
    private Player player;
    private Dealer dealer;
    private Deck deck;

    //constructor
    public Game(Player player) {
        this.player = player;
        this.dealer = new Dealer();
        this.deck = new Deck();
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

//gets dealer score
    public int getDealerScore() {
        return this.dealer.getScore();
    }


    //gets player and dealer scores, and calculates a winner.
    public String announceWinner() {
        int playerScore = this.player.getScore();
        int dealerScore = this.dealer.getScore();
        if (playerScore > dealerScore) {
            return String.format("%s is the winner", this.player.getName());
        } else if (dealerScore > playerScore) {
            return String.format("%s is the winner", this.dealer.getname());
        } else {return "It is a draw";}
    }


}

//overarching "play game" method that takes in several other methods





