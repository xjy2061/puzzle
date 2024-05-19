package exam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class E13StoneWeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        ArrayList<Integer> stones = new ArrayList<>();
        for (String s : input) {
            stones.add(Integer.parseInt(s));
        }
        Collections.sort(stones);
        while (stones.size() > 1) {
            int s1 = stones.remove(stones.size() - 1);
            int s2 = stones.remove(stones.size() - 1);
            int remain = s1 - s2;
            if (remain == 0) {
                continue;
            } else if (!stones.isEmpty() && remain == stones.get(stones.size() - 1)) {
                stones.remove(stones.size() - 1);
                continue;
            }
            for (int i = 0, size = stones.size(); i < size; i++) {
                if (stones.get(i) > remain) {
                    stones.add(i, remain);
                    break;
                }
            }
        }
        System.out.println(stones.isEmpty() ? 0 : stones.get(0));
    }
}
