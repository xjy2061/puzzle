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

        HashMap<Integer, Integer> map = new HashMap<>();
        UnionFind uf = new UnionFind(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    Integer pos = map.get(j);
                    if (pos != null) {
                        uf.union(i, pos);
                    } else {
                        map.put(j, i);
                    }
                    int factor = num / j;
                    pos = map.get(factor);
                    if (pos != null) {
                        uf.union(i, pos);
                    } else {
                        map.put(factor, i);
                    }
                }
            }
            Integer pos = map.get(num);
            if (pos != null) {
                uf.union(i, pos);
            } else {
                map.put(num, i);
            }
        }
        map.clear();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int root = uf.find(i);
            int count = map.getOrDefault(root, 0) + 1;
            map.put(root, count);
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

        int find(int i) {
            if (parent[i] != i) {
                parent[i] = find(parent[i]);
            }
            return parent[i];
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rank[rootA] > rank[rootB]) {
                parent[rootB] = rootA;
            } else {
                parent[rootA] = rootB;
                if (rank[rootA] == rank[rootB]) {
                    rank[rootB]++;
                }
            }
        }
    }
}