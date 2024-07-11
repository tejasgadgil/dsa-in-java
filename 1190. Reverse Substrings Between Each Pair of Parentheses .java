import java.util.Stack;
import java.util.ArrayList;

class Solution {
    public String reverseParentheses(String s) {
        // Initialize a stack to keep track of characters
        Stack<Character> stk = new Stack<>();
        
        // Iterate through each character in the input string
        for (char c : s.toCharArray()) {
            // If the character is a closing parenthesis, reverse the substring within the parentheses
            if (c == ')') {
                stk = reverseAndAppend(stk);
            } else {
                // Otherwise, push the character onto the stack
                stk.push(c);
            }
        }
        
        // Build the final result string from the stack
        StringBuilder result = new StringBuilder();
        while (!stk.isEmpty()) {
            result.append(stk.pop());
        }
        
        // The characters are added in reverse order, so reverse the result string before returning
        return result.reverse().toString();
    }

    public Stack<Character> reverseAndAppend(Stack<Character> stk) {
        // Use a list to collect characters to be reversed
        ArrayList<Character> rev = new ArrayList<>();
        
        // Pop characters from the stack until an opening parenthesis is encountered
        while (stk.peek() != '(') {
            rev.add(stk.pop());
        }
        // Pop the opening parenthesis
        stk.pop();
        
        // Push the characters in reverse order back onto the stack
        for (int i = 0; i < rev.size(); i++) {
            stk.push(rev.get(i));
        }
        
        return stk;
    }
}

// Explaination:
// push in stk till )
// pop and reverse from stack till (
// extend to stack
// continue till end of str
// stack to string
  
// Time Complexity
// O(n)
// Space Complexity
// O(n)
// Algorithm Approach
// Stack-based approach.
