package org.stack.algorithms.basic.algo;

import java.util.Stack;

public class InfixToPostfix {
    public static String infixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        StringBuilder output = new StringBuilder();
        java.util.Map<Character, Integer> precedence = java.util.Map.of(
                '+', 1, '-', 1, '*', 2, '/', 2
        );

        for (char c : expression.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                output.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && stack.peek() != '(' && precedence.get(c) <= precedence.get(stack.peek())) {
                    output.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop());
        }

        return output.toString();
    }

    public static void main(String[] args) {
        System.out.println(infixToPostfix("(a+b)*c"));
    }
}

