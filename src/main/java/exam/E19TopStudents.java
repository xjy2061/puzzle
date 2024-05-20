package exam;

import java.util.*;

public class E19TopStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("-");
        String[] positiveArray = input[0].substring(1, input[0].length() - 1).split(",");
        String[] positives = new String[positiveArray.length];
        for (int i = 0; i < positives.length; i++) {
            positives[i] = positiveArray[i].substring(1, positiveArray[i].length() - 1);
        }
        String[] negativeArray = input[1].substring(1, input[1].length() - 1).split(",");
        String[] negatives = new String[negativeArray.length];
        for (int i = 0; i < negatives.length; i++) {
            negatives[i] = negativeArray[i].substring(1, negativeArray[i].length() - 1);
        }
        String[] reportArray = input[2].substring(1, input[2].length() - 1).split(",");
        String[] reports = new String[reportArray.length];
        for (int i = 0; i < reports.length; i++) {
            reports[i] = reportArray[i].substring(1, reportArray[i].length() - 1);
        }
        String[] idArray = input[3].substring(1, input[3].length() - 1).split(",");
        int[] ids = new int[idArray.length];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = Integer.parseInt(idArray[i]);
        }
        int k = Integer.parseInt(input[4]);
        int[][] scores = new int[ids.length][2];
        for (int i = 0; i < ids.length; i++) {
            String report = reports[i];
            int score = 0;
            for (String positive : positives) {
                if (report.contains(positive)) {
                    score += 3;
                }
            }
            for (String negative : negatives) {
                if (report.contains(negative)) {
                    score -= 1;
                }
            }
            scores[i] = new int[]{ids[i], score};
        }
        Arrays.sort(scores, (s1, s2) -> {
            if (s1[1] == s2[1]) {
                return s1[0] - s2[0];
            } else {
                return s2[1] - s1[1];
            }
        });
        int[] topK = new int[k];
        for (int i = 0; i < k; i++) {
            topK[i] = scores[i][0];
        }
        System.out.println(Arrays.toString(topK));
    }
}
