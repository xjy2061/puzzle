package exam;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给定一个常数 K 和一个单链表 L，请你在单链表上每 K 个元素做一次反转，并输出反转完成后的链表。
 * 如果链表最后一部分不足 K 个元素，则最后一部分不翻转。
 * 例如，假设 L 为 1→2→3→4→5→6
 * 如果 K=3，则你应该输出 3→2→1→6→5→4
 * 如果 K=4，则你应该输出 4→3→2→1→5→6
 */
public class M8RangeReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String headAddress = input[0];
        int total = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        Node head = null;
        HashMap<String, Node> map = new HashMap<>();
        for (int i = 0; i < total; i++) {
            String[] nodeInfo = scanner.nextLine().split(" ");
            Node node = new Node(nodeInfo[0], nodeInfo[1], nodeInfo[2]);
            if (node.address.equals(headAddress)) {
                head = node;
            }
            map.put(node.address, node);
        }
        Node current = head;
        while (current != null) {
            current.next = map.get(current.nextAddress);
            current = current.next;
        }
        current = reverse(head, k);
        while(current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    static Node reverse(Node head, int k) {
        Node current = head;
        int count = 0;
        while (current != null && count < k) {
            current = current.next;
            count++;
        }
        if (count == k) {
            current = reverse(current, k);
            while (count > 0) {
                Node tmp = head.next;
                head.next = current;
                head.nextAddress = current == null ? "-1" : current.address;
                current = head;
                head = tmp;
                count--;
            }
            head = current;
        }
        return head;
    }

    static class Node {
        String address;
        String data;
        String nextAddress;
        Node next;

        Node(String address, String data, String nextAddress) {
            this.address = address;
            this.data = data;
            this.nextAddress = nextAddress;
        }

        @Override
        public String toString() {
            return address + " " + data + " " + nextAddress;
        }
    }
}
