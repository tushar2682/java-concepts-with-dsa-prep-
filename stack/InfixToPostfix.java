package stack;

import java.util.Stack;

public class InfixToPostfix {

    private static int prec(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return 0;
    }

    public static String convert(String exp) {
        Stack<Character> st = new Stack<>();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            // 1) Operand → सीधे postfix में
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }

            // 2) Opening bracket
            else if (ch == '(') {
                st.push(ch);
            }

            // 3) Closing bracket
            else if (ch == ')') {
                while (st.peek() != '(') {
                    postfix.append(st.pop());
                }
                st.pop(); // remove '('
            }

            // 4) Operator
            else {
                while (!st.isEmpty() && prec(st.peek()) >= prec(ch)) {
                    postfix.append(st.pop());
                }
                st.push(ch);
            }
        }

        // 5) Remaining operators
        while (!st.isEmpty()) {
            postfix.append(st.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        String exp = "2+(3*4)-5";
        System.out.println("Postfix: " + convert(exp));
    }
}
//
/* ▶️ Dry Run

Infix:

2 + ( 3 * 4 ) - 5
Read	Stack	Postfix
2		2
+	+	2
(	+ (	2
3	+ (	23
*	+ ( *	23
4	+ ( *	234
)	+	234*
-	-	234*+
5	-	234*+5
end		234*+5-
✅ Key Line (your doubt)
while (!st.isEmpty() && prec(st.peek()) >= prec(ch)) {
    postfix.append(st.pop());
}

This is exactly:

“If low or equal precedence comes → perform operation”

Yes — this is used here.

🧠 Memory Trick

Infix is confusing → convert to postfix → evaluate easily.

▶️ Compile & Run
javac stack/InfixToPostfix.java
java stack.InfixToPostfix
explain logic in hinglish

Chalo Infix → Postfix conversion ka logic Hinglish me crystal clear karte hain.

🎯 Goal

Infix:

2 + 3 * 4

Postfix banana hai:

234*+

Taaki baad me postfix easily evaluate ho jaye (no precedence, no bracket).

🧠 Dimag me ye rule set kar lo

Hum left → right scan karte hain.

Symbol mila	Kya karna hai
Number / letter (operand)	Seedha postfix me daal do
(	Stack me push
)	Jab tak ( na mile, stack se postfix me daalte jao
Operator + - * /	Jab tak stack top ka precedence ≥ current operator, pop karke postfix me daalo

👉 Ye last rule hi tumhara “low ya equal precedence → operation karo” wala rule hai.

🪜 Step by Step Dry Run

Expression:

2 + ( 3 * 4 ) - 5
Read	Stack	Postfix	Kyu?
2		2	Operand → direct
+	+	2	Operator → push
(	+ (	2	Always push
3	+ (	23	Operand
*	+ ( *	23	Push (higher prec)
4	+ ( *	234	Operand
)	+	234*	Pop till (
-	-	234*+	+ ka prec ≥ - → pop
5	-	234*+5	Operand
end		234*+5-	Pop remaining
🔥 Important Line (Logic ka heart)
while (!st.isEmpty() && prec(st.peek()) >= prec(ch)) {
    postfix.append(st.pop());
}

Iska matlab Hinglish me:

“Jab tak stack ke upar wala operator zyada powerful hai ya same power ka hai, usko pehle nipta do.”

🧠 Real Life Analogy

Socho operators boss hain:

* / = senior boss
+ - = junior boss

Agar junior boss (+) aata hai aur stack me senior boss (*) baitha hai,
toh pehle senior boss ka kaam khatam hoga.

✅ Final Soch

Infix me confusion hota hai (precedence, bracket)
Postfix me sab sorted hota hai

Isliye:
Infix → Postfix → Evaluate

🧩 4 Golden Rules yaad rakho
Operand → postfix
( → push
) → pop till (
Operator → pop till stack prec ≥ current, then push

Bas. Yehi pura logic hai.
// */