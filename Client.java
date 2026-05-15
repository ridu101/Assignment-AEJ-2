import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        // Connect to Server
        Socket socket = new Socket("127.0.0.1", 5000);

        System.out.println("=================================");
        System.out.println(" Connected to Server Successfully!");
        System.out.println("=================================");

        // Output Stream
        DataOutputStream output =
                new DataOutputStream(socket.getOutputStream());

        // Scanner for Input
        Scanner sc = new Scanner(System.in);

        // Number of Students
        System.out.print("Enter Number of Students: ");

        int totalStudents = sc.nextInt();

        // Send Total Students
        output.writeInt(totalStudents);

        // Input Student Information
        for (int i = 0; i < totalStudents; i++) {

            System.out.println();
            System.out.println("Enter Student " + (i + 1) + " Information");

            // Student ID
            System.out.print("Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            // Student Name
            System.out.print("Student Name: ");
            String name = sc.nextLine();

            // Student Marks
            System.out.print("Student Marks: ");
            int marks = sc.nextInt();

            // Send Data to Server
            output.writeInt(id);
            output.writeUTF(name);
            output.writeInt(marks);
        }

        System.out.println();
        System.out.println("=================================");
        System.out.println(" Student Information Sent Successfully!");
        System.out.println("=================================");

        // Close Connection
        socket.close();

        sc.close();
    }
}