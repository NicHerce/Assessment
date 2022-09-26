import java.util.*;

public class App extends FileManager{

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to LockedMe");
        System.out.println("Created by Herce, D.\n");

        // main menu:
        menu();
    }

    // main menu where user can sort, add, search, and delete files
    private static void menu() {
        int input;

        do {
            System.out.println("Main Menu");
            System.out.println("""
                    [1] Retrieve file names
                    [2] Add, Search, Delete file
                    [3] Close the application"""
            );

            // asks user for input and checks if it is valid
            input = checkInput( 3);

            switch (input) {
                // case 1: sorts files in ascending order:
                case 1 -> sortFile();
                // case 3: close the application
                case 3 -> System.exit(0);
            }

            if(input == 2) {
                // case 2: add, search, and delete files:
                System.out.println("business level operation");
                System.out.println("""
                    [1] Add file
                    [2] Search file
                    [3] Delete file
                    [4] Return to main menu"""
                );

                // asks user for input and checks if it is valid
                input = checkInput(4);

                switch (input) {
                    case 1 -> createFile();
                    case 2 -> searchFile(1);
                    case 3 -> deleteFile();
                }
            }

        } while(input == 4);

    }

    // asks user for input and checks if it is valid
    private static int checkInput(int end) {
        int input;

        do{
            System.out.print("Select transaction: ");
            input = scanner.nextInt();
        }while (input < 1 || input > end);

        return input;
    }
}
