package solid.lsp;

/** SOLID-> L: Object of superClass should be replaceable with object of its subclass without altering the desirable property of program.*/
public class Rectangle implements Shape {
    private final int height;
    private final int weight;
    public Rectangle(int height, int weight ){
        this.height = height;
        this.weight = weight;

    }
    @Override
    public int getArea() {
        return weight * height;
    }
}
