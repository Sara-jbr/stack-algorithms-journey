package org.stack.algorithms.basic.algo;


import java.util.ArrayList;

public class Stack<T> {

    private ArrayList<T> items;

    public Stack() {
        items = new ArrayList<>();
    }

    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (!isEmpty()) {
            return items.remove(items.size() - 1);
        }
        return null;
    }

    public T peek() {
        if (!isEmpty()) {
            return items.get(items.size() - 1);
        }
        return null;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>();
        intStack.push(1);
        intStack.push(2);
        System.out.println(intStack.peek());
        System.out.println(intStack.pop());
        System.out.println(intStack.isEmpty());

        Stack<String> stringStack = new Stack<>();
        stringStack.push("Hello");
        stringStack.push("World");
        System.out.println(stringStack.peek());
        System.out.println(stringStack.pop());
        System.out.println(stringStack.isEmpty());
    }
}