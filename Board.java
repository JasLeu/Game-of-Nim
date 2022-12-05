public class Board {
    static int pieces;

    public static void populate() {
        pieces = (int) (Math.random() * 41 + 10);
    }

    public static int getPieces(){
        return pieces;
    }

    public static void updateTotal(int num) {
        pieces -= num;
    }
}
    
