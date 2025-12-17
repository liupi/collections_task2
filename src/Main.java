import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = readFile().stream()
                .filter(e -> !e.isBlank())
                .map(str -> {
                    String[] arr = str.trim().split(" ");
                    return new Employee(arr[0], arr[1]);
                }).toList();
    }

    private static Set<String> readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("resources/employees.txt"))) {
            var list = br.lines().toList();
            System.out.println("Size of list: " + list.size());
            HashSet<String> s = new HashSet<>(list);
            System.out.println("Size of set: " + s.size());
            return s;
        } catch (IOException e) {
            throw new RuntimeException("Error reading file.");
        }
    }
}