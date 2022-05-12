package recursion;

/**
 * There are 3 table. 1st table has N coins of various diameters.
 * Coins are arranged in tower like structure where largest diameter
 * coin is at the bottom and smallest at top.
 *
 * Your task is to find the number of moves in which all the coins will be
 * moved to 2nd table. You can use 3rd table as auxiliary space.
 *
 * Constraint: You cannot place larger coin over smaller one.
 */
public class TowerOfHanoi {
    public int moves(int n, char s, char d, char a) {
        if (n <= 1) {
            return n;
        }

        int moves1 = moves(n-1, s, a, d);
        int moves2 = 1;
        int moves3 = moves(n-1, a, d, s);

        return moves1 + moves2 + moves3;
    }

    public static void main(String[] args) {
        TowerOfHanoi toh = new TowerOfHanoi();
        int numMoves = toh.moves(6, 'S', 'D', 'A');
        System.out.println(numMoves);
    }
}
