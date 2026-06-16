package stack;

import java.util.Stack;

public class InfixEvaluation {
    private static int operation(int v1, int v2, char optr) {
        if (optr == '+') return v1 + v2;
        if (optr == '-') return v1 - v2;
        if (optr == '*') return v1 * v2;
        return v1 / v2;
    }
    private static int prec(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return 0;
    }

    public static int evaluate(String exp) {
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isDigit(ch)) {
                val.push(ch - '0');
            }
            else if (ch == '(') {
                op.push(ch);
            }
            // If closing bracket
            else if (ch == ')') {
                while (op.peek() != '(') {
                    char optr = op.pop();
                    int v2 = val.pop();
                    int v1 = val.pop();
                    val.push(operation(v1, v2, optr));
                }
                op.pop(); // remove '('
            }
            // If operator
            else {
                while (!op.isEmpty() && prec(op.peek()) >= prec(ch)) {
                    char optr = op.pop();
                    int v2 = val.pop();
                    int v1 = val.pop();
                    val.push(operation(v1, v2, optr));
                }
                op.push(ch);
            }
        }
        while (!op.isEmpty()) {
            char optr = op.pop();
            int v2 = val.pop();
            int v1 = val.pop();
            val.push(operation(v1, v2, optr));
        }

        return val.pop();
    }

    public static void main(String[] args) {
        String exp = "2+(5*3)-4";
        System.out.println("Result: " + evaluate(exp));
    }
}