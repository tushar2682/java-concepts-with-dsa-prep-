import java.util.Scanner;

public class Dicecombination {

    static final int MOD = 1000000007;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        long[] dp = new long[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {

            for (int dice = 1; dice <= 6; dice++) {

                if (i - dice >= 0) {
                    dp[i] = (dp[i] + dp[i - dice]) % MOD;
                }
            }
        }

        System.out.println(dp[target]);
    }
}