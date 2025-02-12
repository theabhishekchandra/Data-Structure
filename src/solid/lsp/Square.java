package solid.lsp;

public class Square implements Shape {

    private int sideLength;
    public Square(int sideLength){
        this.sideLength = sideLength;
    }
    @Override
    public int getArea() {
        return sideLength * sideLength;
    }
}
