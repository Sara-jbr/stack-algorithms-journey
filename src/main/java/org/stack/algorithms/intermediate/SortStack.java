package org.stack.algorithms.intermediate;

import java.util.Stack;

public class SortStack {
    public static void sort(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() > temp) {
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        sort(stack);
        System.out.println("Sorted Stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
