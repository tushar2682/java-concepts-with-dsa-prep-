package stack;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> st = new Stack<>();
    private Stack<Integer> minSt = new Stack<>();

    // Push
    public void push(int x) {
        st.push(x);

        if (minSt.isEmpty() || x <= minSt.peek()) {
            minSt.push(x);
        }
    }

    // Pop
    public void pop() {
        if (st.isEmpty()) return;

        int removed = st.pop();
        if (!minSt.isEmpty() && removed == minSt.peek()) {
            minSt.pop();
        }
    }

    // Top
    public int top() {
        return st.peek();
    }

    // Get Minimum
    public int getMin() {
        return minSt.peek();
    }

    // Demo
    public static void main(String[] args) {
        MinStack ms = new MinStack();

        ms.push(5);
        ms.push(8);
        ms.push(2);
        ms.push(10);
        ms.push(1);

        System.out.println("Min: " + ms.getMin()); // 1
        ms.pop();
        System.out.println("Min: " + ms.getMin()); // 2
        ms.pop();
        System.out.println("Top: " + ms.top());   // 2
        System.out.println("Min: " + ms.getMin()); // 2
    }
}