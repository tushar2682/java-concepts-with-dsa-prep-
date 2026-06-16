package stack;
public class CelebrityProblem {
    public static int celeb(int[][]M, int n) {
        int i = 0, j = n - 1;

        while (i < j) {
            if (M[i][j] == 1) {
                i++;
            } else {
                j--;
            }
        }
        for (int k = 0; k < n; k++) {
            if (k != i && (M[i][k] == 1 || M[k][i] == 0)) {
                return -1;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        int[][] M = {
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}
        };
        int n = M.length;
        int celeb = celeb(M, n);
        if (celeb == -1) {
            System.out.println("No celebrity found.");
        } else {
            System.out.println("Celebrity is person " + celeb);
        }
    }
    
}
