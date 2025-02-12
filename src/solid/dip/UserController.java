package solid.dip;

/**SOLID -> D: A high level concrete class should not be depended on low level concrete class.
 * Instance, both should depend on abstraction.
 * <p>
 * Abstraction should not depend upon details. Instead, the details depend upon abstraction.*/
public class UserController {
    private Database database;

    public UserController(Database database){
        this.database = database;
    }
    private void saveUser(String users){
        database.saveUser(users);

    }
}
