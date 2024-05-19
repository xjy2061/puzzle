package exam;

import java.util.Scanner;

public class E5Palindromic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String s = input.toLowerCase().replaceAll("[^0-9a-z]+", "");
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                System.out.println(0);
                return;
            }
            i++;
            j--;
        }
        System.out.println(1);
    }
}
