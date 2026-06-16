package stack;

import java.util.Stack;

public class MaxPeopleVisible {

    public static int visible(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int count = 0;

        for (int h : heights) {

            // Pop all shorter people (they are visible)
            while (!st.isEmpty() && st.peek() < h) {
                st.pop();
                count++;
            }

            // If someone taller exists, he is also visible
            if (!st.isEmpty()) {
                count++;
            }

            st.push(h);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] heights = {3, 5, 4, 4, 6, 7};
        System.out.println("Max People Visible: " + visible(heights));
    }
}