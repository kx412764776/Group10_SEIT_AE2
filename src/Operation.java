import java.io.*;
import java.util.*;


/**
 * This class is the parent class of all operations of Administrator and Director.
 * It used to read and write file.
 */
public abstract class Operation {
    protected Scanner scanner;

    public Operation() {
        scanner = new Scanner(System.in);
    }

    /**
     * This method is used to read file according to the filename.
     * The file requires to be stored in .src/file/ + filename + .txt
     * @param filename the name of the file.
     * @return a list of map, each map is a line of the file.
     * @throws FileNotFoundException
     */
    public List<Map<String,String>> readFile(String filename) throws FileNotFoundException {
        try {
            List<Map<String,String>> list = new ArrayList<>();
            File file = new File("./src/file/" + filename + ".txt");
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String data = fileScanner.nextLine();
                String[] dataArray = data.split(",");
                Map<String, String> map = new LinkedHashMap<>();
                for (String s : dataArray) {
                    String[] sArray = s.split(":");
                    map.put(sArray[0], sArray[1]);
                }
                list.add(map);
            }
            fileScanner.close();
            return list;
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found.");
        }
        return null;
    }

    /**
     * This method is used to write file according to the filename.
     * The file requires to be stored in .src/file/ + filename + .txt
     * @param filename the name of the file.
     * @param list a list of map, each map is a line of the file.
     */
    public void writeFile(String filename,List<Map<String,String>> list) {
        try {
            PrintWriter writer = new PrintWriter("./src/file/" + filename + ".txt");
            for (Map<String, String> map : list) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    writer.print(entry.getKey() + ":" + entry.getValue()+",");
                }
                writer.println();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: file not found.");
        }
    }

    /**
     * This method is used to execute the operation.
     */
    public abstract void execute();
}
