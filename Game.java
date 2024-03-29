import java.util.Scanner;

/***
 * Names: Jason/Anchal/Palak
 * Course: APCSA Tri 2
 * 
 * Description: Runs a two player game where each player grabs pieces from the pile.
 */
public class Game {
    
    //declares variables to be used
    Scanner sc = new Scanner(System.in);
    Player p1;
    Player p2;
    int option;
    Player currentPlayer;
    int pieces;
    int grab;

    // Constructors
    public Game() {
        // initializes p1 and p2
        System.out.print("Player 1 name: ");
        p1 = new Player();
        System.out.println("Is there a second player?");
        String ans = sc.nextLine();
        if (ans.equals("yes") || ans.equals("y")) {
            System.out.print("Player 2 name: ");
            p2 = new Player();
        } else {
            p2 = new Player("Bot");
        }
        
    
        // decides who goes first
        option = Player.choosePlayer();
        if (option == 1) {
            currentPlayer = p1;
        } else {
            currentPlayer = p2;
        }
    }

    // Methods
    public void play() {
        
        // sets the initial amount of pieces to take
        pieces = Board.getPieces();

        // runs the game through a while loop
        while (true) {
            // prints intial question
            System.out.println("\nPieces: " + Board.getPieces());

            // runs if total pieces isn't 1
            if (Board.getPieces() != 1) {
                
                // runs if there is a second player
                if (!currentPlayer.getName().equals("Bot")) {
                    do {
                        System.out.println(currentPlayer + ", how many pieces would you like to grab?");
                        grab = Integer.parseInt(sc.nextLine());
                    } while (grab > Board.getPieces()/2 || grab < 1);
                    Board.updateTotal(grab);
                    currentPlayer = p2;

                // runs if there isn't a second player
                } else {
                    grab = currentPlayer.randomizeNumber();
                    System.out.println(currentPlayer + " chooses " + grab + ".");
                    Board.updateTotal(grab);
                    currentPlayer = p1;  
                }
            } else {

                // checks if the current player chosen was bot, indicating that they have the last piece
                if (currentPlayer.getName().equals("Bot")) {
                    p1.setPoints();
                    System.out.println(p2 + " loses. " + p2 + " has " + p2.getPoints() + " points. " + p1 + " has " + p1.getPoints() + " points. \n\nWould you want to play again?");   
                } else {
                    p2.setPoints();
                    System.out.println(p1 + " loses. " + p1 + " has " + p1.getPoints() + " points. " + p2 + " has " + p2.getPoints() + " points. \n\nWould you want to play again?");
                }
                String ans = sc.nextLine();

                // checks if the player wants to restart the game, if yes then adds pieces to Board, otherwise ends the program
                if (ans.equals("yes") || ans.equals("y")) {
                    Board.populate();
                } else {
                    System.exit(0);
                } 
            }
        }
    }
}
