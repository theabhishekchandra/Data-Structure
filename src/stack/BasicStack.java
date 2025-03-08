package stack;

import java.util.ArrayList;
import java.util.Stack;

/** Stack -> Stack is the fundamental Data Structure that can follow the Last In, First Out(LIFO) principle. It can work that the last element added to the stack will be the first one to be removed. It can operate like a stack of plates: We can only add or remove the topmost plate at any given time. The simplicity and efficiency of the stack make them crucial in various computer science applications.*/
public class BasicStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        reverseStack(stack);
        String str = "abc";
        System.out.println(stack);
    }

    ///  Q1. Push at the bottom of the stack;
    public static void pushAtBottom(Stack<Integer> stack, int data){
        // Base Case
        if (stack.empty()){
            stack.add(data);
            return;
        }
        // Recursion
        int top = stack.pop();
        pushAtBottom(stack,data);
        stack.push(top); // Backtracking.
    }

    ///  Q2. Reverse a String using Stack.
    public static String reverseString(String string){
        Stack<Character> stack = new Stack<>();
        int idx = 0;
        while (idx < string.length()){
            stack.push(string.charAt(idx));
            idx++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()){
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    /// Q3. Reverse Stack.

    public static void reverseStack(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }

        int top = stack.pop();
        reverseStack(stack);
        pushAtBottom(stack,top);
    }
    /// Q4. Stock Span Problem.
}
