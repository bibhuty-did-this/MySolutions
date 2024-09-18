package restart.lld.SOLID.O;

// Rectangle class implementing Shape
class Rectangle implements Shape {
    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }
}
