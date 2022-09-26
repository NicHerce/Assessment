import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileManager {

    // create an object of the File class
    // using the directory of the application
    public static File dir = new File(Paths.get("").toAbsolutePath().toString());
    public static String[] fileList = dir.list();

    public static void sortFile(){
        if (fileList == null) {
            System.out.println("Directory is empty");
        }
        else {
            for (int i = 0; i < fileList.length; i++) {
                for (int j = i+1; j < fileList.length; j++) {
                    // compares each element of the array to all the remaining elements
                    if (fileList[i].compareTo(fileList[j]) > 0) {
                        // swapping array elements
                        String temp = fileList[i];
                        fileList[i] = fileList[j];
                        fileList[j] = temp;
                    }
                }
            }

            // Linear search in the array
            for (String s : fileList) {
                // prints .txt files in sorted ascending order
                if(s.contains(".txt")){
                    System.out.println(s);
                }
            }
        }
    }

    public static void createFile() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        // concatenate String if user did not input .txt
        if (!fileName.contains(".txt")) {
            fileName = fileName.concat(".txt");
        }

        System.out.println("================");
        System.out.println("Enter details\n");

        System.out.print("Product Owner: ");
        String productOwner = scanner.nextLine();

        System.out.print("User Story: ");
        String userStory = scanner.nextLine();

        System.out.print("Number of Sprints ");
        int numberOfSprints = scanner.nextInt();

        System.out.print("Duration per Sprint (Days): ");
        int durationPerSprint = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Definition of Done: ");
        String definitionOfDone = scanner.nextLine();

        // create object for agile process
        Agile agile = new Agile(
                productOwner, userStory, numberOfSprints,
                durationPerSprint, definitionOfDone
        );

        String answer;
        do {
            System.out.print("Task: ");
            agile.getTasks().add(scanner.nextLine());

            System.out.print("Duration (Hour/s): ");
            agile.getDuration().add(scanner.nextInt());
            scanner.nextLine();

            // ask user if they want to add another task in the Sprint
            do {
                System.out.print("Add another task? (Y/N): ");
                answer = scanner.nextLine();
            } while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));
        } while (answer.equalsIgnoreCase("Y"));

        try {
            // create PrintWriter object with fileName attribute
            PrintWriter writer = new PrintWriter(fileName);
            System.out.println("File created");

            writer.println("Product Owner: " + agile.getProductOwner() + "\n");
            writer.println("User Story: " + agile.getUserStory() + "\n");
            writer.println("Number of Sprints: " + agile.getNumberOfSprints());
            writer.println("Duration per Sprint: " + agile.getSprintDuration());
            int total = agile.getNumberOfSprints() * agile.getSprintDuration();
            writer.println("Total Duration of Sprints: " + total + "\n");

            writer.printf("%-30.30s %-20.20s\n", "Tasks:", "Duration (Hours):");

            for (int i = 0; i < agile.getTasks().size(); i++) {
                writer.printf("%-30.30s %-20.20s\n", agile.getTasks().get(i), agile.getDuration().get(i));
            }

            writer.println("\nDefinition of Done: " + agile.getSprintDOD());

            // use flush and close to prevent data leak
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        scanner.close();
    }

    public static String searchFile(int n) {
        Scanner scanner = new Scanner(System.in);
        String key;
        String retval = null;

        if (n == 1) System.out.print("Enter file to search: ");
        // n = 2: deleteFile
        else System.out.print("Enter file to delete: ");
        key = scanner.nextLine();

        // concatenate key if input does not have ".txt"
        if(!key.contains(".txt")) key = key.concat(".txt");

        System.out.println("key = " + key);
        int results = 0;

        if (fileList == null) {
            System.out.println("Directory is empty");
        } else {
            // Linear search in the array
            for (String s : fileList) {
                if (s.equalsIgnoreCase(key)) {
                    System.out.println(s + " found");
                    results++;
                    retval = s;
                }
            }

            if (results == 0) System.out.println("File not found");
            else return retval;
        }
        scanner.close();

        // return null when directory is empty
        return null;
    }

    public static void deleteFile(){
        Scanner scanner = new Scanner(System.in);
        String search = searchFile(2);
        String answer;

        if(search != null) {
            File file = new File(search);

            do {
                System.out.print("Delete File? (Y/N): ");
                answer = scanner.nextLine();
            } while (!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N"));

            if (answer.equalsIgnoreCase("Y") && file.delete()) {
                System.out.println("Deleted the file: " + file.getName());
            } else System.out.println("Failed to delete the file.");
        }
        scanner.close();
    }

}
