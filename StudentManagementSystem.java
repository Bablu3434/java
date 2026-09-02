import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int age;
    String course;
    double marks;

    Student(int id, String name, int age, String course, double marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    void display() {
        System.out.println("--------------------------------");
        System.out.println("Student ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Course     : " + course);
        System.out.println("Marks      : " + marks);
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Add Student
    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, age, course, marks));

        System.out.println("\nStudent added successfully!");
    }

    // View Students
    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("\nNo students found.");
            return;
        }

        System.out.println("\n===== STUDENT LIST =====");

        for (Student s : students) {
            s.display();
        }
    }

    // Search Student
    static void searchStudent() {

        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.id == id) {
                System.out.println("\nStudent Found!");
                s.display();
                return;
            }
        }

        System.out.println("\nStudent not found.");
    }

    // Update Student
    static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {

            if (s.id == id) {

                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();

                System.out.print("Enter New Age: ");
                s.age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Course: ");
                s.course = sc.nextLine();

                System.out.print("Enter New Marks: ");
                s.marks = sc.nextDouble();

                System.out.println("\nStudent updated successfully!");
                return;
            }
        }

        System.out.println("\nStudent not found.");
    }

    // Delete Student
    static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.id == id) {
                students.remove(s);

                System.out.println("\nStudent deleted successfully!");
                return;
            }
        }

        System.out.println("\nStudent not found.");
    }

    // Main Method
    public static void main(String[] args) {

        while (true) {

            System.out.println("\n================================");
            System.out.println("   STUDENT MANAGEMENT SYSTEM");
            System.out.println("================================");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("================================");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    System.out.println("\nThank you for using Student Management System!");
                    sc.close();
                    return;

                default:
                    System.out.println("\nInvalid choice! Try again.");
            }
        }
    }
}
