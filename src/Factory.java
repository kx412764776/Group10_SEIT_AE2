/**
 * Factory class to create operation object based on user role
 */
public class Factory {
    public static Operation createOperation(String role) {
        if (role.equalsIgnoreCase("director")) {
            return new DirectorOperation();
        } else if (role.equalsIgnoreCase("administrator")) {
            return new AdministratorOperation();
        } else {
            return null;
        }
    }
}
