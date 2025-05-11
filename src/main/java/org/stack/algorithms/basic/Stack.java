package org.stack.algorithms.basic;

public class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    public int pop() {
        if (!isEmpty()) {
            return stackArray[top--];
        }
        throw new RuntimeException("Stack Underflow");
    }

    public int peek() {
        if (!isEmpty()) {
            return stackArray[top];
        }
        throw new RuntimeException("Stack is Empty");
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display() {
        for (int i = top; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);

        System.out.println("Pushing elements:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display(); // should print 30, 20, 10

        System.out.println("\nTop element is: " + stack.peek());

        System.out.println("\nPopping element: " + stack.pop());
        stack.display(); // should print 20, 10

        System.out.println("\nIs stack empty? " + stack.isEmpty());

        stack.pop();
        stack.pop();

        System.out.println("\nIs stack empty after popping all? " + stack.isEmpty());

        // Uncomment to see underflow in action
        // stack.pop(); // Will throw RuntimeException
    }
}
