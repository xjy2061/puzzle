package exam;

import java.util.*;

public class E19TopStudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("-");
        String positiveStr = input[0].substring(1, input[0].length() - 1);
        String negativeStr = input[1].substring(1, input[1].length() - 1);
        String[] reportArray = input[2].substring(1, input[2].length() - 1).split(",");
        String[] idArray = input[3].substring(1, input[3].length() - 1).split(",");
        int k = Integer.parseInt(input[4]);
        HashMap<String, Integer> wordScores = new HashMap<>();
        for (String s : positiveStr.split(",")) {
            wordScores.put(s.substring(1, s.length() - 1), 3);
        }
        for (String s : negativeStr.split(",")) {
            wordScores.put(s.substring(1, s.length() - 1), -1);
        }
        int[][] scores = new int[idArray.length][2];
        for (int i = 0; i < idArray.length; i++) {
            String report = reportArray[i];
            report = report.substring(1, report.length() - 1);
            int score = 0;
            for (String s : report.split(" ")) {
                Integer ws = wordScores.get(s);
                score += ws != null ? ws : 0;
            }
            scores[i] = new int[]{Integer.parseInt(idArray[i]), score};
        }
        Arrays.sort(scores, (s1, s2) -> {
            if (s1[1] == s2[1]) {
                return s1[0] - s2[0];
            } else {
                return s2[1] - s1[1];
            }
        });
        StringBuilder ret = new StringBuilder("[");
        for (int i = 0; i < k; i++) {
            if (i > 0) {
                ret.append(", ");
            }
            ret.append(scores[i][0]);
        }
        ret.append("]");
        System.out.println(ret);
    }
}
