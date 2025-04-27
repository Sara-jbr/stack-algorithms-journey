package org.stack.algorithms.basic.algo;

public class ReverseString {
    public static String reverseString(String s) {
        Stack stack = new Stack();
        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hello"));
    }
}


