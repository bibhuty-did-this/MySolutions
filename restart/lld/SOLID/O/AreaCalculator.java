package restart.lld.SOLID.O;

// AreaCalculator class
class AreaCalculator {

    // Without open closed principle, not extensible design
    // If we've to make it extensible then we have to make a generic
    // method but have to change each time a new shape is added, which
    // is not a good design choice
    public double calculateRectangleArea(Rectangle rectangle) {
        return rectangle.length * rectangle.width;
    }

    public double calculateCircleArea(Circle circle) {
        return Math.PI * circle.radius * circle.radius;
    }

    // With open closed principle, extensible design with any kind of shape
    // And no preexisting methods needs to be touched

    public double calculateArea(Shape shape) {
        return shape.calculateArea();
    }
}
