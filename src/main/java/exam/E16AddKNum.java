package exam;

import java.util.HashSet;
import java.util.Scanner;

public class E16AddKNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<Integer> nums = new HashSet<>();
        for (String n : scanner.nextLine().split(" ")) {
            nums.add(Integer.parseInt(n));
        }
        int k = scanner.nextInt();
        int sum = 0;
        int cur = 1;
        while (k > 0) {
            if (!nums.contains(cur)) {
                sum += cur;
                k--;
            }
            cur++;
        }
        System.out.println(sum);
    }
}
