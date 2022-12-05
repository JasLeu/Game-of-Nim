import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);

    private String name;
    private int points = 0;
    
    public Player() {
        name = sc.nextLine();
    }

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
