package exam;

import java.util.HashSet;
import java.util.Scanner;

public class KeyAndRooms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] roomArray = input.substring(1, input.length() - 1).split(";");
        int[][] rooms = new int[roomArray.length][];
        for (int i = 0; i < rooms.length; i++) {
            String keyStr = roomArray[i];
            keyStr = keyStr.substring(1, keyStr.length() - 1);
            String[] keyArray = keyStr.isEmpty() ? new String[0] : keyStr.split(",");
            int[] keys = new int[keyArray.length];
            for (int j = 0; j < keys.length; j++) {
                keys[j] = Integer.parseInt(keyArray[j]);
            }
            rooms[i] = keys;
        }
        HashSet<Integer> visited = new HashSet<>();
        dfs(rooms, 0, visited);
        System.out.println(visited.size() == rooms.length);
    }

    private static void dfs(int[][] rooms, int room, HashSet<Integer> visited) {
        if (visited.contains(room)) {
            return;
        }
        visited.add(room);
        for (int key : rooms[room]) {
            dfs(rooms, key, visited);
        }
    }
}
