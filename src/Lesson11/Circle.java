package Lesson11;

public class Circle implements  Figure {
    private int r;


    public Circle(int r) {
        this.r = r;
    }

    public int getR() {
        return r;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "r=" + r +
                '}';
    }

    @Override
    public double findTheArea() {
        double areaCircle = Math.PI * Math.pow(getR(), 2);
        System.out.println("Площадь круга равна: " + areaCircle);

        return areaCircle;
    }
}
