package Lesson11;

public class Square implements Figure {

    private int sidelength;

    public int getSidelength() {
        return sidelength;
    }

    public Square(int sidelength) {
        this.sidelength = sidelength;
    }

    @Override
    public String toString() {
        return "Square{" +
                "sidelength=" + sidelength +
                '}';
    }

    @Override
    public double findTheArea() {

        double areaSquare = Math.pow(getSidelength(), 2);
        System.out.println("Площадь круга равна: " + areaSquare);

        return areaSquare;
    }
}
