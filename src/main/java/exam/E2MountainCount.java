package exam;

import java.util.Scanner;

public class E2MountainCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        int m = Integer.parseInt(size[0]);
        int n = Integer.parseInt(size[1]);
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] cols = scanner.nextLine().split(" ");
            for (int j = 0; j < cols.length; j++) {
                matrix[i][j] = Integer.parseInt(cols[j]);
            }
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dfs(matrix, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) {
            return;
        }
        if (matrix[i][j] == 0) {
            return;
        }
        matrix[i][j] = 0;
        dfs(matrix, i -1, j);
        dfs(matrix, i + 1, j);
        dfs(matrix, i, j - 1);
        dfs(matrix, i, j + 1);
    }
}
