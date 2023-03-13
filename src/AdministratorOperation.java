import java.io.FileNotFoundException;
import java.util.*;


/**
 * AdministratorOperation class is a subclass of Operation class.
 * Administrator can read the requirements file and teacher information file.
 */
public class AdministratorOperation extends Operation {
    private List<Map<String, String>> teachers;
    private List<Map<String, String>> requirements;


    /**
     * Constructor of AdministratorOperation class.
     * Read the requirements file and teacher information file.
     */
    public AdministratorOperation() {
        super();
        try {
            requirements = readFile("requirements");
            teachers = readFile("teacher_information");
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found.");
        }
    }

    /**
     * Execute the operation of administrator.
     * Administrator can read the requirements file and teacher information file.
     * Administrator can also add new teacher information and change the status of the teacher whether is trained.
     */
    @Override
    public void execute() {

        System.out.println("Welcome, administrator! Please choose an operation:");
        System.out.println("1. Read requirements file");
        System.out.println("2. Read teacher information file");
        System.out.println("3. Write teacher information file");
        System.out.println("4. Change the status of the teacher whether is trained");
        int choice = scanner.nextInt();
        scanner.nextLine();


        switch (choice) {
            case 1:
                // Print the requirements file
                for (Map<String, String> map : requirements) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        System.out.println(entry.getKey() + " " + entry.getValue());
                    }
                    System.out.println();
                }
                break;

            case 2:
                // Print the teacher information file
                for (Map<String, String> map : teachers) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        System.out.println(entry.getKey() + " " + entry.getValue());
                    }
                    System.out.println();
                }
                break;

            case 3:
                // Add new teacher information
                System.out.println("Please enter teacher's name:");
                HashMap<String, String> map = new LinkedHashMap<>();
                String name = scanner.nextLine();
                map.put("Name", name);

                System.out.println("Please enter subject of the teacher:");
                String subject = scanner.nextLine();
                map.put("Subject", subject);

                System.out.println("Please enter class of the teacher:");
                String classOfTeacher = scanner.nextLine();

                // Determine if the input value is a positive integer
                if (!classOfTeacher.matches("[1-9]\\d*")) {
                    System.out.println("Invalid input.");
                    return;
                }
                map.put("Class", classOfTeacher);

                System.out.println("Please enter whether the teacher is trained(Yes or No):");
                String isTrained = scanner.nextLine();
                // Determine if the input value is Yes or No
                if (isTrained.equalsIgnoreCase("yes"))
                    map.put("Training_Status", "Yes");
                else if (isTrained.equalsIgnoreCase("no"))
                    map.put("Training_Status", "No");
                else {
                    System.out.println("Invalid input.");
                    return;
                }
                teachers.add(map);
                writeFile("teacher_information", teachers);
                System.out.println("Teacher information has been added.");
                break;

            case 4:
                // Change the status of the teacher whether is trained
                System.out.println("Please enter teacher's name:");
                String teacherName = scanner.nextLine();

                // Determine if the teacher is in the teacher information file
                for (Map<String, String> teacher : teachers) {
                    if (teacher.get("Name").equals(teacherName)) {
                        System.out.println("Please enter the new status(Yes or No):");
                        String newStatus = scanner.nextLine();
                        if (newStatus.equalsIgnoreCase("yes"))
                            teacher.put("Training_Status", "Yes");
                        else if (newStatus.equalsIgnoreCase("no"))
                            teacher.put("Training_Status", "No");
                        else {
                            System.out.println("Invalid input.");
                            return;
                        }
                        writeFile("teacher_information", teachers);
                        System.out.println("Teacher information has been updated.");
                        return;
                    }
                }
                System.out.println("Teacher not found.");
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
    }
}

