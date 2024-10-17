package exam;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 给出一个升序排序的链表 L，删除链表中重复2次以上出现的元素，只保留原链表中出现一次或重复2次 的元素。
 * 例如：
 * 给出的链表为 1→2→3→3→4→4→4→4→5, 返回 1→2→3→3→5.
 * 给出的链表为1→1→1→2→3, 返回 2→3.
 */
public class M13DelDuplicate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String headAddress = input[0];
        int n = Integer.parseInt(input[1]);
        Node head = null;
        HashMap<String, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
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

        Node dummy = new Node("", "", "");
        dummy.next = head;
        Node prev = dummy;
        while (head != null) {
            int count = 0;
            current = head;
            while (current != null && current.data.equals(head.data)) {
                count++;
                current = current.next;
            }
            if (count > 2) {
                prev.next = current;
                prev.nextAddress = current == null ? "-1" : current.address;
            } else {
                prev = head.next == current ? head : head.next;
            }
            head = current;
        }
        current = dummy.next;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
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
