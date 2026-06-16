package recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetArray {

    public static void subset(int idx, int[] arr,
                              List<Integer> currentSubset,
                              List<List<Integer>> allSubsets) {

        if (idx == arr.length) {
            allSubsets.add(new ArrayList<>(currentSubset));
            return;
        }

        // Include
        currentSubset.add(arr[idx]);
        subset(idx + 1, arr, currentSubset, allSubsets);

        // Backtrack (remove)
        currentSubset.remove(currentSubset.size() - 1);

        // Exclude
        subset(idx + 1, arr, currentSubset, allSubsets);
    }

    public static List<List<Integer>> getAllSubsets(int[] arr) {
        List<List<Integer>> allSubsets = new ArrayList<>();
        subset(0, arr, new ArrayList<>(), allSubsets);
        return allSubsets;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> subsets = getAllSubsets(arr);
        System.out.println(subsets);
    }
}