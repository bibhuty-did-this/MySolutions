package restart.lld.DesignPatterns.prototype;

public class PrototypeDesignPattern {
    public static void main(String[] args) {
        // Original objects
        Circle originalCircle = new Circle(5);
        Rectangle originalRectangle = new Rectangle(10, 20);

        // Clone objects
        Circle clonedCircle = originalCircle.clone();
        Rectangle clonedRectangle = originalRectangle.clone();

        // Show cloned objects
        System.out.println("Original Circle: " + originalCircle);
        System.out.println("Cloned Circle: " + clonedCircle);

        System.out.println("Original Rectangle: " + originalRectangle);
        System.out.println("Cloned Rectangle: " + clonedRectangle);
    }
}

