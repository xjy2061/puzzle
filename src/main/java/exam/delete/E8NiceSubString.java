package exam.delete;

import java.util.HashSet;
import java.util.Scanner;

public class E8NiceSubString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int len = s.length();
        String max = "";
        for (int i = 0, last = len - 1; i < last; i++) {
            for (int j = i + 2; j <= len; j++) {
                String sub = s.substring(i, j);
                if (isNice(sub) && sub.length() > max.length()) {
                    max = sub;
                }
            }
        }
        System.out.println(max);
    }

    private static boolean isNice(String s) {
        HashSet<Character> set = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            set.add(s.charAt(i));
        }
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c >= 'a') {
                c = (char) (c - ('a' - 'A'));
            } else {
                c = (char) (c + ('a' - 'A'));
            }
            if (!set.contains(c)) {
                return false;
            }
        }
        return true;
    }
}
