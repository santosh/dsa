package queue;

/**
 * Given a 2D array representing a grid. Each cell have either of 3 value.
 * 0: Empty cell
 * 1: Fresh mango
 * 2: Rotten mango
 *
 * Rotten mango rots fresh mango in 1 day if they are in proximity to the cell.
 * Proximity == up, down, left and right.
 *
 * Return -1 if even one of the mango does not get rotten.
 */
public class DaysToRotAllMangoes {
    public static int daysToRotMangoes(int[][] mangoes) {
        int numDaysToRot = 0;
        int rottenNum = 2;

        while (true) {
            // keep checking for the fresh mangoes to be rotten till
            // the time we don't find any mango
            boolean anyMangoesWasRotten = false;

            // logic to rot mangoes
            for (int i = 0; i < mangoes.length; i++) {
                for (int j=0; j<mangoes[0].length; j++) {
                    if (mangoes[i][j] == rottenNum) {
                        // index i,j index mango is rotten

                        // If there is any fresh mango in neighbour
                        // it should be spoiled
                        //top
                        if (i-1 > 0 && mangoes[i-1][j] == 1) {
                            mangoes[i-1][j] = rottenNum+1;
                            anyMangoesWasRotten = true;
                        }
                        //left
                        if (j-1 >= 0 && mangoes[i][j-1] == 1) {
                            mangoes[i][j-1] = rottenNum+1;
                            anyMangoesWasRotten = true;
                        }
                        //right
                        if (j+1 < mangoes[0].length && mangoes[i][j+1] == 1) {
                            mangoes[i][j+1] = rottenNum+1;
                            anyMangoesWasRotten = true;
                        }
                        //down
                        if (i+1<mangoes.length && mangoes[i+1][j] == 1) {
                            mangoes[i+1][j] = rottenNum+1;
                            anyMangoesWasRotten = true;
                        }
                    }
                }
            }

            if (!anyMangoesWasRotten) {
                break;
            }

            numDaysToRot++;
        }

        return numDaysToRot;
    }

    public static void main(String[] args) {
        int[][] mangoes = {
            {2,1,0,2,1},
            {1,0,1,2,1},
            {1,0,0,2,1}
        };

        System.out.println(daysToRotMangoes(mangoes));
    }
}
