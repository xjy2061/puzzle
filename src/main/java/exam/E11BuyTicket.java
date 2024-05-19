package exam;

import java.util.Scanner;

public class E11BuyTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int k = scanner.nextInt();
        int[] tickets = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            tickets[i] = Integer.parseInt(input[i]);
        }
        int time = 0;
        int i = 0;
        while (tickets[k] > 0) {
            if (tickets[i] > 0) {
                tickets[i]--;
                time++;
            }
            i++;
            if (i == tickets.length) {
                i = 0;
            }
        }
        System.out.println(time);
    }
}
