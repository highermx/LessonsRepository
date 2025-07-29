package Lesson11;

public class Triangle implements Figure {
    private int base;
    private int heigh;

    public int getHeigh() {
        return heigh;
    }

    public int getBase() {
        return base;
    }

    public Triangle(int heigh, int base) {
        this.heigh = heigh;
        this.base = base;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "base=" + base +
                ", heigh=" + heigh +
                '}';
    }

    @Override
    public double findTheArea() {

        double areaTriangle = (getBase() * getHeigh())/2;
        System.out.println("Площадь треугольника равна: " + areaTriangle);

        return areaTriangle;
    }
}
