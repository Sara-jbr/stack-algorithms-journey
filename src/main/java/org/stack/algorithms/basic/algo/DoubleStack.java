package org.stack.algorithms.basic.algo;

public class DoubleStack {
    private int[] items;
    private int top1, top2;

    public DoubleStack(int capacity) {
        items = new int[capacity];
        top1 = -1;
        top2 = capacity;
    }

    // استک اول
    public void push1(int item) {
        if (top1 + 1 == top2) {
            throw new RuntimeException("Stack Overflow");
        }
        items[++top1] = item;
    }

    public int pop1() {
        if (top1 == -1) {
            throw new RuntimeException("Stack Underflow");
        }
        return items[top1--];
    }

    // استک دوم
    public void push2(int item) {
        if (top1 + 1 == top2) {
            throw new RuntimeException("Stack Overflow");
        }
        items[--top2] = item;
    }

    public int pop2() {
        if (top2 == items.length) {
            throw new RuntimeException("Stack Underflow");
        }
        return items[top2++];
    }

    public static void main(String[] args) {
        DoubleStack ds = new DoubleStack(10);

        ds.push1(1);
        ds.push1(2);
        ds.push1(3);

        ds.push2(9);
        ds.push2(8);
        ds.push2(7);

        System.out.println(ds.pop1());
        System.out.println(ds.pop2());

        ds.push1(4);
        ds.push2(6);

        System.out.println(ds.pop1());
        System.out.println(ds.pop2());
    }
}

