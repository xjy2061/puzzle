package exam;

import java.util.Scanner;

public class Jump {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        String[] steps = scanner.nextLine().split(" ");
        int[] m = new int[steps.length];
        for (int i = 0; i < m.length; i++) {
            m[i] = Integer.parseInt(steps[i]);
        }
        int start = scanner.nextInt();

        boolean[] visited = new boolean[m.length];
        boolean ret = dfs(m, visited, start);
        System.out.println(ret ? "True" : "False");
    }

    private static boolean dfs(int[] m, boolean[] visited, int start) {
        if (start < 0 || start >= m.length || visited[start]) {
            return false;
        }
        visited[start] = true;
        if (m[start] == 0) {
            return true;
        }
        return dfs(m, visited, start + m[start]) || dfs(m, visited, start - m[start]);
    }
}
