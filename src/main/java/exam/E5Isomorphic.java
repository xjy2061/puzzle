package exam;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
public class E5Isomorphic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        String s = input[0];
        String t = input[1];
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Character> mapT = new HashMap<>();
        for (int i = 0, len = s.length(); i < len; i++) {
            Character charS = s.charAt(i);
            Character charT = t.charAt(i);
            Character valS = mapS.get(charS);
            if (valS == null) {
                mapS.put(charS, charT);
            } else {
                if (!valS.equals(charT)) {
                    System.out.println(0);
                    return;
                }
            }
            Character valT = mapT.get(charT);
            if (valT == null) {
                mapT.put(charT, charS);
            } else {
                if (!valT.equals(charS)) {
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(1);
    }
}
