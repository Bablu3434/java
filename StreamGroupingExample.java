import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamGroupingExample {

    public static class Employee {
        private String name;
        private String department;
        private double salary;

        public Employee(String name, String department, double salary) {
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }

        @Override
        public String toString() {
            return String.format("%s ($%.0f)", name, salary);
        }
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "Engineering", 85000),
            new Employee("Bob", "HR", 60000),
            new Employee("Charlie", "Engineering", 92000),
            new Employee("Diana", "Marketing", 65000),
            new Employee("Ethan", "HR", 58000)
        );

        // Group employees by department
        Map<String, List<Employee>> byDepartment = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));

        // Print the results
        byDepartment.forEach((dept, empList) -> {
            System.out.println(dept + ": " + empList);
        });
    }
}