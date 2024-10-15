package exam;

import java.util.*;

public class M16CallTeacher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        String teacher = input[0];
        int count = Integer.parseInt(input[1]);
        HashSet<String> teacherContacts = new HashSet<>();
        HashMap<String, HashSet<String>> contactMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String[] contact = scanner.nextLine().split(" ");
            if (teacher.equals(contact[1])) {
                teacherContacts.add(contact[1]);
            }
            HashSet<String> contacts = contactMap.get(contact[0]);
            if (contacts == null) {
                contacts = new HashSet<>();
                contactMap.put(contact[0], contacts);
            }
            contacts.add(contact[1]);
        }
        LinkedList<String> list = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        list.add("1");
        visited.add("1");
        while (!list.isEmpty()) {
            String person = list.poll();
            if (teacherContacts.contains(person)) {
                System.out.println("Yes");
                return;
            }
            HashSet<String> contacts = contactMap.get(person);
            if (contacts != null) {
                for (String contact : contacts) {
                    if (!visited.contains(contact)) {
                        list.add(contact);
                        visited.add(contact);
                    }
                }
            }
        }
        System.out.println("No");
    }
}
