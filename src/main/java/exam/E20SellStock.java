package exam;

import java.util.Scanner;

public class E20SellStock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int[] prices = new int[input.length];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Integer.parseInt(input[i]);
        }
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        System.out.println(maxProfit);
    }
}
