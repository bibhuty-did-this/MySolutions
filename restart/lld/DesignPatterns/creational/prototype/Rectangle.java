package restart.lld.DesignPatterns.creational.prototype;

class Rectangle implements Prototype {
    int width;
    int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    // Clone method to create a copy of the current object
    @Override
    public Rectangle clone() {
        return new Rectangle(this.width, this.height);  // Shallow copy of the Rectangle object
    }

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + "]";
    }
}
