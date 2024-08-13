import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Person_map {
    Integer id;
    String name;
    String email;

    public Person_map(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person_map person = (Person_map) o;
        return Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "Person_map{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Map<Person_map, Person_map> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Prompt user to enter id
            System.out.print("Enter id (or type 'exit' to finish): ");
            String idInput = scanner.nextLine();

            if ("exit".equalsIgnoreCase(idInput)) {
                break;
            }

            Integer id;
            try {
                id = Integer.parseInt(idInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid id format. Please enter a numeric id.");
                continue;
            }
            System.out.print("Enter name: ");
            String name = scanner.nextLine();  // Prompt user to enter email
            System.out.print("Enter email: ");
            String email = scanner.nextLine();

            Person_map person = new Person_map(id, name, email);

            // Insert or update the entry
            insertOrUpdate(map, person);
            System.out.println();
        }
        System.out.println("Final entries in the map:");
        for (Person_map p : map.values()) {
            System.out.println(p);
        }
        scanner.close();
    }

    private static void insertOrUpdate(Map<Person_map, Person_map> map, Person_map newPerson) {
        if (map.containsKey(newPerson)) {
            // Update existing entry
            Person_map existingPerson = map.get(newPerson);
            existingPerson.id = newPerson.id;
            existingPerson.name = newPerson.name;
        } else {
            // Add new entry
            map.put(newPerson, newPerson);
        }
    }
}