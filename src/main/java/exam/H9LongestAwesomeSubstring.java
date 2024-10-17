package exam;

import java.util.HashMap;
import java.util.Scanner;

public class H9LongestAwesomeSubstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int state = 0;
        int max = 0;
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        for (int i = 0, len = s.length(); i < len; i++) {
            int digital = s.charAt(i) - '0';
            state ^= (1 << digital);
            Integer pos = seen.get(state);
            if (pos == null) {
                seen.put(state, i);
            } else {
                max = Math.max(max, i - pos);
            }
            for (int j = 0; j < 10; j++) {
                int tempState = state ^ (1 << j);
                Integer tempPos = seen.get(tempState);
                if (tempPos != null) {
                    max = Math.max(max, i - tempPos);
                }
            }
        }
        System.out.println(max);
    }
}
