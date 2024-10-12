package exam;

import java.util.HashMap;
import java.util.Scanner;

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
