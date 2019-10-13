import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Are you ready to play Blackjack. What is your name?");
        String playerName = scanner.next();
        Player player = new Player(playerName);
        Game game = new Game(player);

        //deal two cards to player and dealer
        game.playFirstPartOfGame();
        
        System.out.println(game.showPlayerHand());

        //show one of the dealer's cards
        System.out.println(game.showOneDealerCard());

        //ask user whether to stick or twist
        System.out.println(game.askForPlayerDecision());
        char playerDecision = scanner.next().charAt(0);

        game.loopPlayerTwists(playerDecision);
//        game.actOnPlayerDecision(playerDecision);
//        System.out.println(game.showNewPlayerCard(card));
        System.out.println(game.showPlayerHand());

//        System.out.println(game.getResult());


//        System.out.println("Do you want to stick or twist?");
//        System.out.println(game.showDealerHand());


        //will need user input to get the variable playerDecision

//        System.out.println(game.getResult());

    }

}
