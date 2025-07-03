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
//        System.out.println(isValidPare("((){[}])"));
        System.out.println(isDuplicatePare("(((a + b)) + (a - b))"));
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
    public static void stockSpam(int[] stock, int[] span){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 0; i < stock.length; i++) {
            int curr = stock[i];
            while (!s.isEmpty() && curr > stock[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i +1;
            }else {
                int preH = s.peek();
                span[i] = i - preH;
            }
            s.push(i);

        }
    }

    /// Q5. Next Greater Element.
    public static void nextGreaterElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int[] nxtGenerate = new int[arr.length];
        for (int i = arr.length -1; i >= 0; i--){

            while (!stack.empty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }

            if (stack.empty()){
                nxtGenerate[i] = -1;
            }else {
                nxtGenerate[i] = arr[stack.peek()];
            }

            stack.push(i);
        }

        for (int num : nxtGenerate){
            System.out.println(num);
        }
    }

    ///  Q6. Validate Parentheses.
    public static Boolean isValidPare(String str){
        Stack<Character> s = new Stack<>();

        for (int i = 0 ; i < str.length(); i++){
            // Opening Parentheses
            if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '['){
                s.push(str.charAt(i));
            }else {
                if (s.empty()) {
                    return false;
                }
                if ((s.peek() == '(' && str.charAt(i) == ')') || (s.peek() == '{' && str.charAt(i) == '}') || (s.peek() == '[' && str.charAt(i) == ']')){
                    s.pop();
                }else {
                    return false;
                }

            }
        }
        return s.isEmpty();
    }
    /// Q7. Check Duplicate Parentheses.
    public static Boolean isDuplicatePare(String string){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < string.length(); i++){
            char ch = string.charAt(i);

            // For Close
            if (ch == ')'){
                int count = 0;
                while (stack.peek() != '('){
                    stack.pop();
                    count++;
                }
                if (count < 1){
                    return true; // Is Duplicate
                }else {
                    stack.pop(); // Is pair
                }

            }else {
                // For Open
                stack.push(ch);
            }
            

        }
        return false;
    }

    ///  Q8. Max Area in Histogram.

}
