package exam;

import java.util.Scanner;

public class H6MaxIslandArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] row = input.substring(1, input.length() - 1).split(";");
        int[][] grid = new int[row.length][];
        for (int i = 0; i < grid.length; i++) {
            String[] col = row[i].substring(1, row[i].length() - 1).split(",");
            grid[i] = new int[col.length];
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = Integer.parseInt(col[j]);
            }
        }

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(dfs(grid, i, j), max);
            }
        }
        System.out.println(max);
    }

    static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int area = 1;
        area += dfs(grid, i - 1, j);
        area += dfs(grid, i, j - 1);
        area += dfs(grid, i, j + 1);
        area += dfs(grid, i + 1, j);
        return area;
    }
}
