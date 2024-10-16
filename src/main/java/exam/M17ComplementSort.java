package exam;

import java.util.Arrays;
import java.util.Scanner;

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
