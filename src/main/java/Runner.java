import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Are you ready to play Blackjack. What is your name?");
        String playerName = scanner.next();
        Player player = new Player(playerName);
        Game game = new Game(player);
        game.play();

        System.out.println(game.showPlayerHand());

        System.out.println();

        System.out.println(game.showDealerHand());

        System.out.println();

        System.out.println(game.getResult());

    }

}
