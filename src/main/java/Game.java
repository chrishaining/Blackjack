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

//    public String showNewPlayerCard() {
//        return this.player.showNewCard();
//    }

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

    public void playFirstPartOfGame() {
        this.fillTheDeck();
        this.deck.shuffle();
        this.deal();
//        this.decideWinner();
    }

    //make a method that splits play into DEAL FIRST ROUND, ASSESS, DECIDE WINNER

    public void dealFirstHand() {
        this.fillTheDeck();
        this.deck.shuffle();
        this.deal();
    }

    public String askForPlayerDecision() {
        return "Do you want to twist? (Y or N)";
    }

    public void playerForfeitsGameForInvalidAnswer() {
        this.result = "You entered an invalid answer, so you lose!";
    }

    public void actOnPlayerDecision(char playerDecision) {
        if (Character.toUpperCase(playerDecision) != 'Y' && Character.toUpperCase(playerDecision) != 'N') {
            this.playerForfeitsGameForInvalidAnswer();
        }
        else if (Character.toUpperCase(playerDecision) == 'Y') {
            this.dealer.dealCardToPlayer(deck, player);
//            this.showPlayerHand();
        }
//        else if (Character.toUpperCase(playerDecision) == 'N') {
////            this.showPlayerHand();
//        }
    }
    
    public void loopPlayerTwists(char playerDecision) {
        while (Character.toUpperCase(playerDecision) == 'Y') {
            if (this.player.getScore() <= 21) {
                this.askForPlayerDecision();
                this.actOnPlayerDecision(playerDecision);
            } else if (this.player.getScore() > 21) {
                this.result = "You've gone bust! Dealer wins.";
            }
        }
    }

//    public String playerGoesBust() {
//        if (this.player.getScore() > 21) {
//            return "You're bust!";
//        }
//    }


    public void decideWhetherDealerTwists() {
        while (this.dealer.getScore() < 16) {
            this.dealer.dealCardToSelf(deck);
        }
    }

//    public void playSecondPartOfGame() {
//        this.askForPlayerDecision();
//        this.actOnPlayerDecision(char playerDecision);
//        this.decideWhetherDealerTwists();
//    }

//    public void play() {
//        this.playFirstPartOfGame();
//        this.playSecondPartOfGame();
//        this.decideWinner();
//    }

    public String showOneDealerCard() {
        return String.format("You can see one of the dealer's cards. It's the %s.", this.dealer.showRandomCardFromHand());
    }
}







