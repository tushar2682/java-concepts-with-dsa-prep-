public class Pattern2 {
    public static void main(String[] args) {
        int n = 5;
        if (args.length > 0) {
            try { n = Integer.parseInt(args[0]); } catch (Exception e) { }
        }
        for (int i = 1; i <= n; i++) {
            for (int s = 0; s < n - i; s++) System.out.print(" ");
            for (int j = 0; j < 2 * i - 1; j++) System.out.print("*");
            System.out.println();
        }
    }
}
