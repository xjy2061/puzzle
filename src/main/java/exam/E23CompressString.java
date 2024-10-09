package exam;

import java.util.Scanner;

public class E23CompressString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.isEmpty()) {
            System.out.println();
            return;
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                ret.append(s.charAt(i - 1));
            }
        }
        ret.append(s.charAt(s.length() - 1));
        System.out.println(ret);
    }
}
