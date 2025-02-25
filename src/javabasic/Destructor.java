package javabasic;

class Resource implements AutoCloseable {
/** If you need to clean up resources (e.g., closing files or database connections), use AutoCloseable instead of finalize()*/
    public Resource() {
        System.out.println("Resource acquired");
    }

    public void close() {
        System.out.println("Resource released");
    }
}

public class Destructor {
    public static void main(String[] args) {
        try (Resource resource = new Resource()) {
            System.out.println("Using resource...");
        } // The resource is automatically closed here

        System.out.println("End of main() method");
    }
}
