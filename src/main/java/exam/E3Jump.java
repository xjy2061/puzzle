package exam;

import java.util.Scanner;

/**
 * Drizzle 被困到一条充满数字的方块路中，假设这条路由一个非负的整数数组m组成，Drizzle 最开始的位置在下标 start 处，当他位于下标i位置时可以向前或者向后跳跃m[i]步数，已知元素值为0处的位置是出口，且只能通过出口出去，不可能数组越界，也不能折返，如果跳跃的步数超出数组范围，则也定义为失败，请你通过编程计算出Drizzle能否逃出这里。
 */
public class E3Jump {
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
