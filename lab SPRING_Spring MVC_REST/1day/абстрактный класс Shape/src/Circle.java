public class Circle extends Shape {
    private Point o;
    private Point a;

    public Circle() {
    }

    public Circle(Point o, Point r) {
        this.o = o;
        this.a = r;
    }

    public Point getO() {
        return o;
    }

    public void setO(Point o) {
        this.o = o;
    }

    public Point getR() {
        return a;
    }

    public void setR(Point a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "Circle{" + "o=" + o + ", a=" + a + '}';
    }

    @Override
    public double getPerimetr() {
        return 2 * Math.PI * Point.calculationDistance(o,a);
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow( Point.calculationDistance(o,a), 2);
    }

}