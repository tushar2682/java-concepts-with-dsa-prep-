import java.util.Arrays;

public class Floodfill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int original = image[sr][sc];
        if (original == newColor) return image;

        dfs(image, sr, sc, original, newColor);
        return image;
    }

    private void dfs(int[][] img, int r, int c, int orig, int color) {
        int m = img.length, n = img[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n) return;
        if (img[r][c] != orig) return;

        img[r][c] = color;

        dfs(img, r + 1, c, orig, color);
        dfs(img, r - 1, c, orig, color);
        dfs(img, r, c + 1, orig, color);
        dfs(img, r, c - 1, orig, color);
    }
public static void main(String[] args) {
    int[][] image = {
        {1, 1, 1},
        {1, 1, 0},
        {1, 0, 1}
    };
    int sr = 1, sc = 1, newColor = 2;

    Floodfill obj = new Floodfill();
    int[][] result = obj.floodFill(image, sr, sc, newColor);

    for (int[] row : result) {
        System.out.println(Arrays.toString(row));
    }
}
}
