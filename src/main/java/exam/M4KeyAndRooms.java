package exam;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 有 n 个房间，房间按从 0 到 n - 1 编号。最初，除 0 号房间外的其余所有房间都被锁住。你的目标是进入所有的房间。然而，你不能在没有获得钥匙的时候进入锁住的房间。
 * 当你进入一个房间，你可能会在里面找到一套不同的钥匙，每把钥匙上都有对应的房间号，即表示钥匙可以打开的房间。你可以拿上所有钥匙去解锁其他房间。
 * 给你一个数组 rooms 其中 rooms[i] 是你进入 i 号房间可以获得的钥匙集合。如果能进入 所有 房间返回 true，否则返回 false。
 */
public class M4KeyAndRooms {
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
