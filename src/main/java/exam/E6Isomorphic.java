package exam;

import java.util.HashMap;
import java.util.Scanner;

public class E6Isomorphic {
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
