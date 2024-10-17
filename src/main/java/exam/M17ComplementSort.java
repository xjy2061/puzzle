package exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 * 例如，整数 5 的二进制表示是 "101" （没有前导零位），取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数数组 arr 。请你将数组中的元素按照其补数升序排序。如果补数相同，则按照原数值大小升序排列。
 * 请你返回排序后的数组。
 */
public class M17ComplementSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        Integer[] arr = new Integer[input.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr, (a, b) -> {
            int complement1 = getComplement(a);
            int complement2 = getComplement(b);
            if (complement1 == complement2) {
                return Integer.compare(a, b);
            }
            return Integer.compare(complement1, complement2);
        });
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                ret.append(",");
            }
            ret.append(arr[i]);
        }
        System.out.println(ret);
    }

    static int getComplement(int num) {
        if (num == 0) {
            return 1;
        }
        int bits = Integer.toBinaryString(num).length();
        return num ^ ((1 << bits) - 1);
    }
}
