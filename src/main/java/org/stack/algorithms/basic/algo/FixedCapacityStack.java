package org.stack.algorithms.basic.algo;

public class FixedCapacityStack {
    private int[] items;
    private int top;
    private int capacity;

    public FixedCapacityStack(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
        top = -1;
    }

    public void push(int item) {
        if (top == capacity - 1) {
            throw new RuntimeException("Stack Overflow");
        }
        items[++top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow");
        }
        return items[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack");
        }
        return items[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public static void main(String[] args) {
        FixedCapacityStack stack = new FixedCapacityStack(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        System.out.println(stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

