package org.stack.algorithms.advanced;

import java.util.Stack;

public class CelebrityProblem {
    static int[][] matrix = {
            {0, 1, 1},
            {0, 0, 0},
            {0, 1, 0}
    };

    static boolean knows(int a, int b) {
        return matrix[a][b] == 1;
    }

    public static int findCelebrity(int n) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) stack.push(i);

        while (stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();

            if (knows(a, b)) {
                stack.push(b);
            } else {
                stack.push(a);
            }
        }

        int candidate = stack.pop();
        for (int i = 0; i < n; i++) {
            if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) {
                return -1;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {
        int n = 3;
        int celeb = findCelebrity(n);
        System.out.println(celeb == -1 ? "No Celebrity" : "Celebrity is: " + celeb); // Output: 1
    }
}
