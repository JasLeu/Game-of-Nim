import java.util.Scanner;

public class Game {
    
    Scanner sc = new Scanner(System.in);
    Player p1;
    Player p2;
    int currentPlayer;
    int pieces;
    int grab;

    // Constructors
    public Game() {
        System.out.print("Player 1 name: ");
        p1 = new Player();
        System.out.print("Player 2 name: ");
        p2 = new Player();
    
        
        currentPlayer = (int) (Math.random() * 2 + 1);
        // System.out.println(currentPlayer);
    }

    // Methods
    public void play() {
        //Board board = new Board();
        pieces = Board.getPieces();
        System.out.println("\nTotal pieces: " + Board.getPieces() + "\n");
        /* System.out.println(p1 + ", how many pieces would you like to grab?");
        grab = Integer.parseInt(sc.nextLine()); */

        while (true) {
            //prints intial question
            /* System.out.println(currentPlayer + ", how many pieces would you like to grab?");
            grab = Integer.parseInt(sc.nextLine()); */
            System.out.println("PIeces: " + Board.getPieces());
            //player 1
            if (currentPlayer == 1) {


                if (Board.getPieces() != 1) {

                    //checks for valid input
                    do {
                        System.out.println(p1 + ", how many pieces would you like to grab?");
                        grab = Integer.parseInt(sc.nextLine());
                    }
                    while ((grab > Board.getPieces()/2));


                    System.out.println("1");
                    Board.updateTotal(grab);
                    currentPlayer = 2;


                } else {
                    p2.setPoints();
                    System.out.println(p1 + " loses. " + p1 + " has " + p1.getPoints() + " points. " + p2 + " has " + p2.getPoints() + " points. \n\n Would you want to play again?");
                    if (sc.nextLine().equals("yes")) {
                        Game nim = new Game(); 
                        nim.play();
                    } else {
                        //System.exit(0);
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

                    System.out.println("2");
                    Board.updateTotal(grab);
                    currentPlayer = 1;
                } else {
                    p1.setPoints();
                    System.out.println(p2 + " loses. " + p2 + " has " + p2.getPoints() + " points. " + p1 + " has " + p1.getPoints() + " points. \n\n Would you want to play again?");
                    if (sc.nextLine().equals("yes")) {
                        Game nim = new Game(); 
                        nim.play();
                    } else {
                     //   System.exit(1);
                    }
                }
            }
        }
        
        
        
    }
}
