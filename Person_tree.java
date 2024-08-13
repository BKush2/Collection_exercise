import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;

public class Person_tree implements Comparable<Person_tree> {
    Integer id;
    String name;
    String email;

    public Person_tree(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person_tree person = (Person_tree) o;
        return Objects.equals(email, person.email);
    }

    @Override
    public String toString() {
        return "Person_tree{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person_tree other) {
        return this.email.compareTo(other.email);
    }

    public static void main(String[] args) {
        TreeSet<Person_tree> treeSet = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Choose action - (a) Add, (d) Display, (e) Exit: ");
            String choice = scanner.nextLine().trim().toLowerCase();

            switch (choice) {
                case "a":
                    addEntry(treeSet, scanner);
                    break;

                case "d":
                    displayEntries(treeSet);
                    break;

                case "e":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter 'a' to add, 'd' to display, or 'e' to exit.");
            }
        }
    }
    private static void addEntry(TreeSet<Person_tree> treeSet, Scanner scanner) {
        // Prompt user to enter id
        System.out.print("Enter id: ");
        String idInput = scanner.nextLine();

        Integer id;
        try {
            id = Integer.parseInt(idInput);
        } catch (NumberFormatException e) {
            System.out.println("Invalid id format. Please enter a numeric id.");
            return;
        }
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        Person_tree person = new Person_tree(id, name, email);

        if (!treeSet.add(person)) {
            treeSet.remove(person);
            treeSet.add(person);
        }
        System.out.println("Entry added/updated successfully.");
    }
    private static void displayEntries(TreeSet<Person_tree> treeSet) {
        if (treeSet.isEmpty()) {
            System.out.println("No entries to display.");
        } else {
            System.out.println("Current entries in the TreeSet:");
            for (Person_tree p : treeSet) {
                System.out.println(p);
            }
        }
    }
}