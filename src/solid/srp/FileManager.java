package solid.srp;

/**  SOLID ->  S: Single Responsibility Principle.
 * A Class should have only one reason to change. meaning that it should have only one responsibility or job.*/
public class FileManager {

    public FileManager(int a, int b){

    }

    public void openFile(){
        System.out.println("Open File...");
    }
    public void saveFile(){
        System.out.println("Save File...");
    }
}
