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
    int currentPlayer;
    int pieces;
    int grab;

    // Constructors
    public Game() {
        // initializes p1 and p2
        System.out.print("Player 1 name: ");
        p1 = new Player();
        System.out.print("Player 2 name: ");
        p2 = new Player();
    
        // decides who goes first
        currentPlayer = (int) (Math.random() * 2 + 1);
    }

    // Methods
    public void play() {
        
        // sets the initial amount of pieces to take
        pieces = Board.getPieces();

        // runs the game through a while loop
        while (true) {
            //prints intial question
            System.out.println("\nPieces: " + Board.getPieces());

            //player 1
            if (currentPlayer == 1) {

                // runs if total pieces isn't 1
                if (Board.getPieces() != 1) {

                    //checks for valid input
                    do {
                        System.out.println(p1 + ", how many pieces would you like to grab?");
                        grab = Integer.parseInt(sc.nextLine());
                    }
                    while ((grab > Board.getPieces()/2));

                    // updates the total pieces in Board
                    Board.updateTotal(grab);

                    // changes the current player to player 2
                    currentPlayer = 2;


                } else {
                    // if the total amount of pieces = 1
                    
                    // adds one point to p2
                    p2.setPoints();

                    // prints the scores
                    System.out.println(p1 + " loses. " + p1 + " has " + p1.getPoints() + " points. " + p2 + " has " + p2.getPoints() + " points. \n\nWould you want to play again?");
                    String ans = sc.nextLine();

                    // checks if the player wants to restart the game, if yes then adds pieces to Board, otherwise ends the program
                    if (ans.equals("yes") || ans.equals("y")) {
                        Board.populate();
                    } else {
                        System.exit(0);
                    }
                }            
    

            //player 2
            } else {
                if(Board.getPieces() != 1) {
                    do {
                        System.out.println(p2 + ", how many pieces would you like to grab?");
                        grab = Integer.parseInt(sc.nextLine());
                    }
                    while ((grab > Board.getPieces()/2));

                    //System.out.println("2");
                    Board.updateTotal(grab);
                    currentPlayer = 1;
                } else {
                    p1.setPoints();
                    System.out.println(p2 + " loses. " + p2 + " has " + p2.getPoints() + " points. " + p1 + " has " + p1.getPoints() + " points. \n\nWould you want to play again?");
                    String ans = sc.nextLine();
                    if (ans.equals("yes") || ans.equals("y")) {
                        Board.populate();
                    } else {
                        System.exit(0);
                    }
                }
            }
        }
        
        
        
    }
}
