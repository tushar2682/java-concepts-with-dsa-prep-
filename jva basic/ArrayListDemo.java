import java.util.*;
public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        int[] Arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < Arr.length; i++) {
            arr.add(Arr[i]);
        }
        System.out.println(arr);
    }

}
