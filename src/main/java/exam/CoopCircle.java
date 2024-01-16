package exam;

import java.util.Scanner;

public class CoopCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rows = scanner.nextLine().split("\\|");
        int n = rows.length;
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] cols = rows[i].split(" ");
            for (int j = 0; j < cols.length; j++) {
                matrix[i][j] = Integer.parseInt(cols[j]);
            }
        }

        int count = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(matrix, visited, i);
                count++;
            }
        }
        System.out.println(count);
    }

    private static void dfs(int[][] matrix, boolean[] visited, int i) {
        if (visited[i]) {
            return;
        }
        visited[i] = true;
        for (int j = 0; j < matrix.length; j++) {
            if (matrix[i][j] == 1 && !visited[j]) {
                dfs(matrix, visited, j);
            }
        }
    }
}
