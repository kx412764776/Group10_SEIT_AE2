import java.util.Scanner;

/**
 * Start the program
 */
public class Command {
    public void StartTask(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your role (director or administrator):");
        String role = scanner.nextLine();
        Operation operation = Factory.createOperation(role);
        if (operation != null) {
            do {
                operation.execute();
                System.out.println("Please press any key to continue, press q to exit");
            } while (!scanner.nextLine().equals("q"));
        } else {
            System.out.println("Invalid role.");
        }
    }
}
