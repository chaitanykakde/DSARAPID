import java.util.*;

public class StackCodes {

    // 20. Valid Parentheses
    // Easy
    // Topics
    // premium lock icon
    // Companies
    // Hint
    // Given a string s containing just the characters '(', ')', '{', '}', '[' and
    // ']', determine if the input string is valid.

    // An input string is valid if:

    // Open brackets must be closed by the same type of brackets.
    // Open brackets must be closed in the correct order.
    // Every close bracket has a corresponding open bracket of the same type.
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            // check deos it any opening paranthesis
            char curr = s.charAt(i);
            if (curr == '(' || curr == '[' || curr == '{') {
                st.push(curr);
            } else {
                if (st.isEmpty()) return false;
                char top=st.pop();
                if(curr=='}' && top!='{' || curr==']'&& top!='[' || curr==')' && top!='(' ){
                    return false;
                }
            } 
        }
        if (!st.isEmpty()) {
            return false;
        }

        return true;

    }

    

    public static void main(String[] args) {

    }
}
