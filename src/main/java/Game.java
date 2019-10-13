public class Game {

    private Player player;
    private Dealer dealer;
    private Deck deck;
    private String result;

    public Game(Player player) {
        this.player = player;
        this.dealer = new Dealer();
        this.deck = new Deck();
        this.result = null;
    }

    public String getPlayerName() {
        return this.player.getName();
    }

    public boolean checksThereIsADealer() {
        return this.dealer != null;
    }

    public Dealer getDealer() {
        return this.dealer;
    }

    public void fillTheDeck() {
        this.deck.add52Cards();
    }

    public int countCardsInDeck() {
        return this.deck.countCards();
    }

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

    public int getDealerScore() {
        return this.dealer.getScore();
    }


    public void decideWinner() {
        int playerScore = this.player.getScore();
        int dealerScore = this.dealer.getScore();
        if (playerScore > dealerScore) {
            this.result = "You won! Congratulations!";
        } else if (dealerScore > playerScore) {
            this.result = String.format("%s is the winner. Try again.", this.dealer.getname());
        } else {this.result = "It is a draw";}
    }

    public String getResult() {
        this.decideWinner();
        return this.result;
    }

    public void play() {
        this.fillTheDeck();
        this.deck.shuffle();
        this.deal();
        this.decideWinner();
    }

}







