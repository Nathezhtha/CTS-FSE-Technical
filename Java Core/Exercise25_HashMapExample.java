import java.util.HashMap;
import java.util.Scanner;

public class StudentIDMap {
    public static void main(String[] args) {
        HashMap<Integer, String> studentMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            studentMap.put(id, name);
        }
        System.out.print("Enter ID to search: ");
        int searchId = scanner.nextInt();
        String name = studentMap.get(searchId);
        if (name != null) {
            System.out.println("Student name: " + name);
        } else {
            System.out.println("Student ID not found.");
        }
    }
}