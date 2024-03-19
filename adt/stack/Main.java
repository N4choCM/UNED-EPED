package adt.stack;

import adt.stack.dataStructures.Stack;
import adt.stack.dataStructures.StackImpl;
import adt.stack.models.URL;

public class Main {
  public static void main(String[] args) {
    URL firstURL = new URL("https://www.google.com");
    URL secondURL = new URL("https://www.facebook.com");
    URL thirdURL = new URL("https://www.twitter.com");

    Stack<URL> stack = new StackImpl<URL>();
    printBrowsingHistory(stack);
    stack.push(firstURL);
    printBrowsingHistory(stack);
    stack.push(secondURL);
    printBrowsingHistory(stack);
    stack.push(thirdURL);
    printBrowsingHistory(stack);
    while(!stack.isEmpty()) {
      stack.pop();
      printBrowsingHistory(stack);
    }
  }

  public static void printBrowsingHistory(Stack<URL> stack) {
    if (stack.isEmpty()) {
      System.out.println("Browsing history is empty");
    } else {
      System.out.println("Size: " + stack.size() + " --- " + stack.get().getUrl());
    }
  }
}
