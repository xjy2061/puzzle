package exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定n个物品和一个容量为C的背包，物品i的重量是Wi，其价值为Vi，背包问题是如何选择入背包的物品，使得装入背包的物品的总价值最大。
 * 注意：你可以将物品的一部分装入背包，但不能重复装入。
 */
public class E17MaxValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] capacity = scanner.nextLine().split(",");
        String[] weights = scanner.nextLine().split(",");
        String[] values = scanner.nextLine().split(",");
        int n = Integer.parseInt(capacity[0]);
        int c = Integer.parseInt(capacity[1]);
        double[][] items = new double[n][3];
        for (int i = 0; i < n; i++) {
            double weight = Double.parseDouble(weights[i]);
            double value = Double.parseDouble(values[i]);
            items[i] = new double[]{weight, value, value / weight};
        }
        Arrays.sort(items, (o1, o2) -> Double.compare(o2[2], o1[2]));
        double currentWeight = 0;
        double totalValue = 0;
        for (int i = 0; i < n; i++) {
            double[] item = items[i];
            if (currentWeight + item[0] <= c) {
                currentWeight += item[0];
                totalValue += item[1];
            } else {
                totalValue += (c - currentWeight) * item[2];
                break;
            }
        }
        System.out.println((int) totalValue);
    }
}
