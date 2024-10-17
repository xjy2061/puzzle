package exam;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定一个由不同正整数组成的非空数组 nums，考虑下面的构图：
 * 有 nums.length 个节点，按照从 nums[0]到 nums[nums.length-1]标记；
 * 只有当 nums[i] 和 nums[j] 共用一个大于 1 的公因数时，nums[i] 和 nums[j] 之间才有一条边。
 * 返回构图中最大连通组件的大小。
 */
public class H2MaxFactorSize {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] nums = new int[input.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }
        UnionFind uf = new UnionFind(nums.length);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            for (int j = 2; j * j <= x; j++) {
                if (x % j == 0) {
                    Integer index = map.get(j);
                    if (index != null) {
                        uf.union(i, index);
                    } else {
                        map.put(j, i);
                    }
                    int factor = x / j;
                    index = map.get(factor);
                    if (index != null) {
                        uf.union(i, index);
                    } else {
                        map.put(factor, i);
                    }
                }
            }
            Integer index = map.get(x);
            if (index != null) {
                uf.union(i, index);
            } else {
                map.put(x, i);
            }
        }
        int max = 0;
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int root = uf.find(i);
            int count = counts.getOrDefault(root, 0) + 1;
            counts.put(root, count);
            max = Math.max(max, count);
        }
        System.out.println(max);
    }

    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
                if (rank[rootX] == rank[rootY]) {
                    rank[rootY]++;
                }
            }
        }
    }
}
