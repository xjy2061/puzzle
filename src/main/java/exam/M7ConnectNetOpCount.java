package exam;

import java.util.Scanner;

public class M7ConnectNetOpCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        if (m < n - 1) {
            System.out.println(-1);
            return;
        }
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            String[] conn = scanner.nextLine().split(" ");
            uf.union(Integer.parseInt(conn[0]), Integer.parseInt(conn[1]));
        }
        System.out.println(uf.count - 1);
    }

    static class UnionFind {
        int[] parent;
        int[] rank;
        int count;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootX] = rootY;
                    if (rank[rootX] == rank[rootY]) {
                        rank[rootY]++;
                    }
                }
                count--;
            }
        }
    }
}
