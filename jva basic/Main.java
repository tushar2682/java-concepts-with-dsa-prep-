import java.util.*;

public class Main {

    private static final int MOD = 1000000007;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        long[] dp = new long[target + 1];
        dp[0] = 1;

        // 🔥 Permutation logic (order matters)
        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = (dp[i] + dp[i - coin]) % MOD;
                }
            }
        }

        System.out.println(dp[target]);
        sc.close();
    }
}