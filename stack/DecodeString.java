
import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int currentNum = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                // Form the full number (handles multi-digit numbers like 10, 100)
                currentNum = currentNum * 10 + (ch - '0');
            } 
            else if (ch == '[') {
                // Push the current count and current string to their respective stacks
                numStack.push(currentNum);
                strStack.push(currentString);
                
                // Reset them for the content inside the brackets
                currentNum = 0;
                currentString = new StringBuilder();
            } 
            else if (ch == ']') {
                // Bracket closes: Decode the current inner segment
                int repeatTimes = numStack.pop();
                StringBuilder decodedSegment = new StringBuilder();
                
                // Repeat the current inner string k times
                for (int i = 0; i < repeatTimes; i++) {
                    decodedSegment.append(currentString);
                }
                
                // Retrieve the string context from before the '[' and append decoded segment
                currentString = strStack.pop().append(decodedSegment);
            } 
            else {
                // Ordinary character: just append it to the current string
                currentString.append(ch);
            }
        }

        return currentString.toString();
    }
}
public class DecodeString {
    public static void main(String[] args) {
        Solution obj = new Solution();
        String s = "3[a]2[bc]";
        String result = obj.decodeString(s);
        System.out.println(result); // Output: "aaabcbc"
    }
}