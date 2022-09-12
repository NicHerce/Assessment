import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("Welcome to LockedMe");
        System.out.println("Created by Herce, D.");

        System.out.println();
        mainMenu();
    }

    private static void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Main Menu");
        System.out.println("Select Transaction: ");
        String input = scanner.nextLine();

        switch (input) {
            case "1" -> System.out.println("case 1: return file names in ascending order");
            case "2" -> System.out.println("case 2: return ");
            case "3" -> System.out.println("case 3: close the application");
        }
    }

}
