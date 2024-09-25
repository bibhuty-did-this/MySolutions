package restart.lld.DesignPatterns.creational.prototype;

class Circle implements Prototype {
    int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    // Clone method to create a copy of the current object
    @Override
    public Circle clone() {
        return new Circle(this.radius);  // Shallow copy of the Circle object
    }

    @Override
    public String toString() {
        return "Circle with radius: " + radius;
    }
}
