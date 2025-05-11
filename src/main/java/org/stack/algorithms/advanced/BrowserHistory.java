package org.stack.algorithms.advanced;

import java.util.Stack;

public class BrowserHistory {
    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String currentPage;

    public BrowserHistory(String homepage) {
        currentPage = homepage;
    }

    public void visit(String url) {
        backStack.push(currentPage);
        currentPage = url;
        forwardStack.clear();
    }

    public String back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
        }
        return currentPage;
    }

    public String forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
        }
        return currentPage;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory("home.com");
        browser.visit("page1.com");
        browser.visit("page2.com");
        System.out.println(browser.back());       // page1.com
        System.out.println(browser.back());       // home.com
        System.out.println(browser.forward());    // page1.com
        browser.visit("page3.com");
        System.out.println(browser.getCurrentPage()); // page3.com
    }
}
