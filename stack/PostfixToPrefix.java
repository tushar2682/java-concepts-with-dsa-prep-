package stack;

import java.util.Stack;

public class PostfixToPrefix {

    public static String convert(String postfix) {
        Stack<String> st = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {
            char ch = postfix.charAt(i);

            // Operand → push
            if (Character.isLetterOrDigit(ch)) {
                st.push(ch + "");
            }
            // Operator → pop 2 → make prefix → push
            else {
                String s2 = st.pop();
                String s1 = st.pop();
                String expr = ch + s1 + s2;
                st.push(expr);
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String postfix = "23*54*+9-";
        System.out.println("Prefix: " + convert(postfix));
    }
}