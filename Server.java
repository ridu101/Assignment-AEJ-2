import java.net.*;
import java.io.*;
import java.util.*;

public class Server {

    public static void main(String[] args) throws IOException {

        // Create Server Socket
        ServerSocket ss = new ServerSocket(5000);

        System.out.println("=================================");
        System.out.println(" Server is Waiting for Client...");
        System.out.println("=================================");

        // Accept Client Connection
        Socket socket = ss.accept();

        System.out.println("Client Connected Successfully!");
        System.out.println();

        // Input Stream
        DataInputStream input =
                new DataInputStream(socket.getInputStream());

        // HashMap for ID and Marks
        HashMap<Integer, Integer[]> studentMarks =
                new HashMap<>();

        // HashMap for ID and Name
        HashMap<Integer, String> studentNames =
                new HashMap<>();

        // Receive Number of Students
        int totalStudents = input.readInt();

        // Receive Student Information
        for (int i = 0; i < totalStudents; i++) {

            int id = input.readInt();

            String name = input.readUTF();

            int marks = input.readInt();

            // Store Marks
            Integer[] markArray = {marks};

            studentMarks.put(id, markArray);

            // Store Name with ID
            studentNames.put(id, name);
        }

        // Display Student Records
        System.out.println("========== Student Records ==========");

        for (Integer id : studentMarks.keySet()) {

            Integer[] marks = studentMarks.get(id);

            String name = studentNames.get(id);

            System.out.println("Student ID   : " + id);
            System.out.println("Student Name : " + name);
            System.out.println("Marks        : " + marks[0]);

            System.out.println("-------------------------------------");
        }

        System.out.println("All Student Information Received!");

        // Close Connection
        socket.close();
        ss.close();
    }
}