package restart.lld.SOLID.O;

/**
 * The Open/Closed Principle (OCP) is one of the five SOLID principles of object-oriented programming and design.
 * It states that a software module (class, function, etc.) should be open for extension but closed for modification.
 * This means that the behavior of a module can be extended (through inheritance(default methods), interfaces, etc.)
 * without altering its source code, thus preventing bugs in previously working functionality.
 */
public class OpenClosedPrinciple {
    public static void main(String[] args) {
        AreaCalculator areaCalculator = new AreaCalculator();

        Shape rectangle = new Rectangle(5, 4);
        Shape circle = new Circle(3);

        System.out.println("Rectangle Area: " + areaCalculator.calculateArea(rectangle));
        System.out.println("Circle Area: " + areaCalculator.calculateArea(circle));
    }
}
