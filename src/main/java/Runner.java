import java.sql.SQLOutput;
import java.util.Scanner;

//import static java.lang.Integer.parseInt;

public class Runner {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        System.out.println("Are you ready to play Blackjack. What is your name?");
        String playerName = scanner.next();
        Player player = new Player(playerName);
        Game game = new Game(player);
        game.play();


        //tells the user their cards
        System.out.println(game.showPlayerHand());

        //tells user their first card
//        System.out.println(String.format("Your first card is ... the %s", game.showPlayerHand()));

//        tells user their second card
//        System.out.println(String.format("Your second card is ... the %s", game.showPlayerHand()));

        System.out.println();

        //tells user what the dealer's cards are
        System.out.println(game.showDealerHand());

        // tells user what the dealer's second card is
        System.out.println();

        //announce winner
        System.out.println(game.getResult());


    }

}
