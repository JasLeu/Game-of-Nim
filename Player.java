import java.util.Scanner;

/***
 * Player class
 */
public class Player {
    Scanner sc = new Scanner(System.in);

    private String name;
    private int points = 0;
    
    //initializes name
    public Player() {
        name = sc.nextLine();
    }

    //adds one point
    public void setPoints() {
        points++;
    }
    
    /*** Getters */
    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String toString() {
        return name;
    }
}
