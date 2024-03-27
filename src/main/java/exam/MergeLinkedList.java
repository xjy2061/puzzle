package exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MergeLinkedList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Node> map = new HashMap<>();
        String[] input = scanner.nextLine().split(" ");
        String addr1 = input[0];
        String addr2 = input[1];
        int count = Integer.parseInt(input[2]);
        for (int i = 0; i < count; i++) {
            String[] node = scanner.nextLine().split(" ");
            map.put(node[0], new Node(node[0], node[1], node[2]));
        }
        ArrayList<Node> list1 = new ArrayList<>();
        ArrayList<Node> list2 = new ArrayList<>();
        while(!addr1.equals("-1")) {
            Node node = map.get(addr1);
            list1.add(node);
            addr1 = node.next;
        }
        while(!addr2.equals("-1")) {
            Node node = map.get(addr2);
            list2.add(node);
            addr2 = node.next;
        }
        int len1 = list1.size();
        int len2 = list2.size();
        if (len2 > len1) {
            ArrayList<Node> temp = list1;
            list1 = list2;
            list2 = temp;
            int len = len1;
            len1 = len2;
            len2 = len;
        }
        for (int i = 0, j = len2 -1; i < len1; i++) {
            Node node1 = list1.get(i);
            Node node2 = null;
            if (i % 2 == 1 && j >= 0) {
                node2 = list2.get(j);
                node1.next = node2.addr;
                int next = i + 1;
                if (next < len1) {
                    node2.next = list1.get(next).addr;
                } else {
                    node2.next = "-1";
                }
                j--;
            }
            System.out.println(node1.addr + " " + node1.data + " " + node1.next);
            if (node2 != null) {
                System.out.println(node2.addr + " " + node2.data + " " + node2.next);
            }
        }
    }

    static class Node {
        String addr;
        String data;
        String next;

        Node(String addr, String data, String next) {
            this.addr = addr;
            this.data = data;
            this.next = next;
        }
    }
}
