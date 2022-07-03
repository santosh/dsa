package array;


public class FindPatternOfChar2DArray {
    static void patternSearch(char[][] grid, String word) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == word.charAt(0) &&
                        searchInMatrix(grid, row, col, word))
                    System.out.println("pattern found at " + row + ", " + col);
            }
        }
    }

    private static boolean searchInMatrix(char[][] matrix, int row, int col, String word) {
        // indexes of the neighbour
        int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] y = {-1, 0, 1, -1, 1, -1, 0, 1};
        int R = matrix.length;
        int C = matrix[0].length;
        if (matrix[row][col] != word.charAt(0))
            return false;

        int len = word.length();

        for (int dir = 0; dir < 8; dir++) {
            int k, rd = row + x[dir], cd = col + y[dir];

            for (k = 1; k < len; k++) {
                if (rd >= R || rd < 0 || cd >= C || cd < 0)
                    break;
                if (matrix[rd][cd] != word.charAt(k))
                    break;

                rd += x[dir];
                cd += y[dir];
            }

            if (k == len)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] arr = {
                {'A', 'C', 'P', 'R', 'C'},
                {'A', 'C', 'P', 'R', 'C'},
                {'V', 'O', 'V', 'N', 'I'},
                {'W', 'G', 'F', 'M', 'N'},
                {'Q', 'A', 'T', 'I', 'T'}
        };

        patternSearch(arr, "AAVW");
    }
}
