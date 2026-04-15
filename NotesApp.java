import java.io.*;
import java.util.Scanner;

public class NotesApp {
    
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Notes App ---");
            System.out.println("1. Write Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    writeNote(sc);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");

            }
        } while (choice != 3);

        sc.close();
    }

    public static void writeNote(Scanner sc) {
        try{
            FileWriter writer = new FileWriter("notes.txt", true);
            System.out.print("Enter your note: ");
            String note = sc.nextLine();

            writer.write(note + "\n");
            writer.close();

            System.out.println("Note saved successfully.");
        } catch (IOException e) {
            System.out.println("Error writing file.");
        }
    }

    public static void readNotes() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("notes.txt"));
            String line;

            System.out.println("\n--- Your Notes ---");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}

            