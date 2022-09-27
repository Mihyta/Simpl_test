package jsonFilesClasses;

public class Departments {
    private String name;

//    public jsonFiles.Departments(String name, double x, double y, double radius) {
//        this.name = name;
//        this.x = x;
//        this.y = y;
//        this.radius = radius;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    private double x;
    private double y;
    private double radius;

    @Override
    public String toString() {
        return name;
    }
}
