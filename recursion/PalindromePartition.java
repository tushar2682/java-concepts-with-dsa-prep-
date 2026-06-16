package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

    // Check palindrome
    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Backtracking function
    public static void backtrack(int idx,
                                 List<String> currentPartition,
                                 List<List<String>> allPartitions,
                                 String s) {

        if (idx == s.length()) {
            allPartitions.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            String prefix = s.substring(idx, i + 1);

            if (isPalindrome(prefix)) {
                currentPartition.add(prefix);
                backtrack(i + 1, currentPartition, allPartitions, s);
                currentPartition.remove(currentPartition.size() - 1); // backtrack step
            }
        }
    }

    // Driver function
    public static List<List<String>> partition(String s) {
        List<List<String>> allPartitions = new ArrayList<>();
        backtrack(0, new ArrayList<>(), allPartitions, s);
        return allPartitions;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> partitions = partition(s);
        System.out.println(partitions);
    }
}