package exam;

import java.util.LinkedList;
import java.util.Scanner;

public class E20SlideWindow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numArray = scanner.nextLine().split(" ");
        int k = scanner.nextInt();
        int[] nums = new int[numArray.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(numArray[i]);
        }
        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            while (!list.isEmpty() && nums[i] > nums[list.getLast()]) {
                list.pollLast();
            }
            list.addLast(i);
            if (i - k + 1 > list.getFirst()) {
                list.poll();
            }
            if (i >= k - 1) {
                if (i > k - 1) {
                    ret.append(' ');
                }
                ret.append(nums[list.getFirst()]);
            }
        }
        System.out.println(ret);
    }
}
