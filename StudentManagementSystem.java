import java.util.Scanner;

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String name = "";
        String rollNo = "";
        boolean studentAdded = false;

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter Student Name: ");
                name = sc.nextLine();

                System.out.print("Enter Roll Number: ");
                rollNo = sc.nextLine();

                studentAdded = true;

                System.out.println("Student Added Successfully!");

            } else if (choice == 2) {

                if (studentAdded) {

                    System.out.println("\n----- Student Details -----");
                    System.out.println("Name: " + name);
                    System.out.println("Roll Number: " + rollNo);

                } else {

                    System.out.println("No Student Found.");

                }

            } else if (choice == 3) {

                if (studentAdded) {

                    System.out.print("Enter New Student Name: ");
                    name = sc.nextLine();

                    System.out.print("Enter New Roll Number: ");
                    rollNo = sc.nextLine();

                    System.out.println("Student Updated Successfully!");

                } else {

                    System.out.println("No Student Found.");

                }

            } else if (choice == 4) {

                if (studentAdded) {

                    name = "";
                    rollNo = "";
                    studentAdded = false;

                    System.out.println("Student Deleted Successfully!");

                } else {

                    System.out.println("No Student Found.");

                }

            } else if (choice == 5) {

                System.out.println("Thank You!");
                break;

            } else {

                System.out.println("Invalid Choice!");

            }
        }

        sc.close();
    }
}