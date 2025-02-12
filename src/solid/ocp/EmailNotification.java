package solid.ocp;

/** SOLID -> O: Should be open for extension, but closed for modification.
 * This means you should be able to change the behavior of a without changing its source code.
 * You do this through polymorphism and interface ( or abstract classes). */
public class EmailNotification implements Notification{
    @Override
    public void notify(String msg) {
        System.out.println(msg);
    }
}
