import java.util.*;

public class StackAll {

    // conversions of expressions
    // infix to postfix
    // postfix to infix
    // infix to prefix
    // prefix to infix
    // prefix to postfix
    // postfix to prefix

    // 1.infix to postfix

    public static int priority(char c) {
        if (c == '^') {
            return 3;
        } else if (c == '*' || c == '/') {
            return 2;
        } else if (c == '+' || c == '-') {
            return 1;
        } else {
            return -1;
        }
    }

    public static String infixToPostfix(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            char curr = s.charAt(i);

            // check for the range of character to identify does it operand
            if (curr >= 'A' && curr <= 'Z' || curr >= 'a' && curr <= 'z' || curr >= '0' && curr <= '9') {
                sb.append(curr);
            } else if (curr == '(') {
                st.push(curr);
            } else if (curr == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    char operator = st.pop();
                    sb.append(operator);
                }
                st.pop();
            } else {
                // now its definitely a operator so we can before adding to the stack
                // need to check its priority
                // as rules: if priority of character present in the stack is grator or equal
                // than curr char then we need to pop all such and append to answer

                while (!st.isEmpty() && st.peek() != '(' &&
                        (priority(curr) < priority(st.peek())
                                || (priority(curr) == priority(st.peek()) && st.peek() != '^'))) {
                    sb.append(st.pop());
                }
                st.push(curr);
            }
            i++;
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.toString();
    }

    // infix to prefix

    public static String infixToPrefix(String s) {
        StringBuilder sb = new StringBuilder();

        // reverse the expression
        // convert ( to ) and ) to (
        StringBuilder helper = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                helper.append(')');
            } else if (s.charAt(i) == ')') {
                helper.append('(');
            } else {
                helper.append(s.charAt(i));
            }

        }
        s = helper.toString();

        Stack<Character> st = new Stack<>();
        int n = s.length();
        int i = 0;
        while (i < n) {
            char curr = s.charAt(i);

            // check for the range of character to identify does it operand
            if (curr >= 'A' && curr <= 'Z' || curr >= 'a' && curr <= 'z' || curr >= '0' && curr <= '9') {
                sb.append(curr);
            } else if (curr == '(') {
                st.push(curr);
            } else if (curr == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    char operator = st.pop();
                    sb.append(operator);
                }
                st.pop();
            } else {
                // now its definitely a operator so we can before adding to the stack
                // need to check its priority
                // as rules: if priority of character present in the stack is grator or equal
                // than curr char then we need to pop all such and append to answer

                if (curr == '^') {
                    while (!st.isEmpty() && priority(curr) <= priority(st.peek())) {
                        sb.append(st.pop());
                    }
                } else {
                    while (!st.isEmpty() && st.peek() != '(' && priority(curr) < priority(st.peek())) {
                        sb.append(st.pop());
                    }
                }
                st.push(curr);
            }
            i++;
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }


    

    public static void main(String[] args) {
        String s = "A+B*C/D-E";
        // System.out.println(infixToPostfix("A^B^C"));
        System.out.println(infixToPrefix("((A+B)*C)-(D-E)*(F+G)"));
    }
}
