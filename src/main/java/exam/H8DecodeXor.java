package exam;

import java.util.Scanner;

public class H8DecodeXor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(",");
        int[] encoded = new int[input.length];
        for (int i = 0; i < encoded.length; i++) {
            encoded[i] = Integer.parseInt(input[i]);
        }

        int n = encoded.length + 1;
        int totalXor = 0;
        for (int i = 1; i <= n; i++) {
            totalXor ^= i;
        }
        int encodedXor = 0;
        for (int i = 1; i < n - 1; i += 2) {
            encodedXor ^= encoded[i];
        }
        int first = totalXor ^ encodedXor;
        int[] perm = new int[n];
        perm[0] = first;
        for (int i = 1; i < n; i++) {
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        }
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                ret.append(",");
            }
            ret.append(perm[i]);
        }
        System.out.println(ret);
    }
}
