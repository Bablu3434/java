import java.util.ArrayList;
import java.util.Scanner;

class Patient {
    int id;
    String name;
    int age;
    String disease;

    Patient(int id, String name, int age, String disease) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    void display() {
        System.out.println("Patient ID : " + id);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Disease    : " + disease);
        System.out.println("---------------------------");
    }
}

class Doctor {
    int id;
    String name;
    String specialization;

    Doctor(int id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    void display() {
        System.out.println("Doctor ID       : " + id);
        System.out.println("Name            : " + name);
        System.out.println("Specialization  : " + specialization);
        System.out.println("---------------------------");
    }
}

public class HospitalManagementSystem {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<Patient> patients = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();

    static void addPatient() {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Patient Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients.add(new Patient(id, name, age, disease));

        System.out.println("Patient added successfully!");
    }

    static void showPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }

        System.out.println("\n===== PATIENT LIST =====");

        for (Patient p : patients) {
            p.display();
        }
    }

    static void addDoctor() {
        System.out.print("Enter Doctor ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();

        doctors.add(new Doctor(id, name, specialization));

        System.out.println("Doctor added successfully!");
    }

    static void showDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }

        System.out.println("\n===== DOCTOR LIST =====");

        for (Doctor d : doctors) {
            d.display();
        }
    }

    static void searchPatient() {
        System.out.print("Enter Patient ID to search: ");
        int id = sc.nextInt();

        boolean found = false;

        for (Patient p : patients) {
            if (p.id == id) {
                System.out.println("\nPatient Found:");
                p.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Patient not found.");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n=================================");
            System.out.println("     HOSPITAL MANAGEMENT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. Add Patient");
            System.out.println("2. Show Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. Show Doctors");
            System.out.println("5. Search Patient");
            System.out.println("6. Exit");
            System.out.println("=================================");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    showPatients();
                    break;

                case 3:
                    addDoctor();
                    break;

                case 4:
                    showDoctors();
                    break;

                case 5:
                    searchPatient();
                    break;

                case 6:
                    System.out.println("Thank you for using Hospital Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}