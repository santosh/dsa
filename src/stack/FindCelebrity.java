package stack;

import java.util.Stack;

/**
 * There are n people at a party. Find the celebrity.
 *
 * A celebrity is someone who does not know anybody, but everyone knows them.
 */
public class FindCelebrity {
    public static int findCelebrity(int n, boolean[][] relationMatrix) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            stack.push(i);
        }

        while (stack.size()>1) {
            int per1 = stack.pop();
            int per2 = stack.pop();

            if (relationMatrix[per1][per2]) {
                stack.push(per2);
            } else {
                stack.push(per1);
            }
        }

        int celeb = stack.pop();

        // need to verify if it actually is  celebrity
        for (int i = 0; i < n; i++) {
            if (i!=celeb && relationMatrix[i][celeb]
                    && relationMatrix[celeb][i]) {
                return -1;  // there  is no celebrity
            }
        }

        return celeb;
    }

    public static void main(String[] args) {
        boolean[][] relationMatrix = {
            {false, false, true, false},
            {false, false, true, false},
            {false, false, false, false},
            {false, false, true, false}
        };

        System.out.println(findCelebrity(4, relationMatrix));
    }
}
