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
        System.out.println("Player 1 name: ");
        p1 = new Player();
        System.out.println("Player 2 name: ");
        p2 = new Player();
    
        
        currentPlayer = (int) (Math.random() * 2 + 1);
        System.out.println(currentPlayer);
    }

    // Methods
    public void play() {
        pieces = Board.getPieces();
        System.out.println(p1 + ", how many pieces would you like to grab?");
        grab = Integer.parseInt(sc.nextLine());

        if (currentPlayer == 1) {
            if(pieces != 1) {
                while (grab >= pieces/2) {
                    System.out.println(p1 + ", how many pieces would you like to grab?");
                    grab = Integer.parseInt(sc.nextLine());
                }
            } else {
                System.out.println("Player 1 loses. \n\n Would you want to play again?");
                if (sc.nextLine().equals("yes"))
            }            

        } else {
            if(pieces != 1) {
                while (grab >= pieces/2) {
                    System.out.println(p1 + ", how many pieces would you like to grab?");
                    grab = Integer.parseInt(sc.nextLine());
                }
            } 
        }
        
        
    }
}
