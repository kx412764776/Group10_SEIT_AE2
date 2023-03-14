import java.io.FileNotFoundException;
import java.util.*;


/**
 * This class is responsible for the director's operations.
 * It extends the Operation class.
 * It has a list of requirements.
 */
public class DirectorOperation extends Operation{

    private List<Map<String,String>> requirements;

    /**
     * This is the constructor of the class.
     * It reads the requirements file and stores the data in the list.
     */
    public DirectorOperation() {
        super();
        try {
            requirements = readFile("requirements");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * This method is responsible for the director's operations.
     * It allows the director to read the requirements file and write the requirements file.
     */
    @Override
    public void execute() {

        System.out.println("Welcome, director! Please choose an operation:");
        System.out.println("1. Read requirements file");
        System.out.println("2. Write requirements file");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1:
                // Traversal the requirements list and print the data.
                // 1.1 If there is no content in the file, return reminder.
                if (requirements.isEmpty()){
                    System.out.println("Temporarily there is no requirement for teachers!");
                    break;
                }
                // 1.2 Output the contents of requirements.
                printFile(requirements);
                break;

            case 2:
                // Enter the data and write it to the requirements file.
                System.out.println("Please enter class:");
                HashMap<String, String> map = new LinkedHashMap<>();
                String className = scanner.nextLine();
                map.put("class", className);

                System.out.println("Please enter number of teachers:");
                String numOfTeachers = scanner.nextLine();
                map.put("number_of_teachers", numOfTeachers);

                System.out.println("Please enter subjects:");
                String subjects = scanner.nextLine();
                map.put("subjects", subjects);

                requirements.add(map);
                writeFile("requirements", requirements);
                System.out.println("Requirements file has been updated.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}
