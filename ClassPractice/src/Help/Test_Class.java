package Help;
import Help.Shape.*;
import Help.Shape.Color.*;

class Test1 extends Color {
    @Override
    public void dispColor() {
        System.out.println("\n----- THIS IS AN INHERITED OBJECT OF THE COLOR CLASS -----");
        System.out.println("Color is: " + color);
    }
}

public class Test_Class extends Shape {
    public static void main(String[] args) {
        Shape shape1 = new Shape();
        Test1 color1 = new Test1();
        shape1.printMethod();
        color1.dispColor();
    }
}
