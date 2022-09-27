package jsonFilesClasses;

import java.util.Objects;

public class Wells {
//    public jsonFiles.Wells(int id, String name, double x, double y) {
//        this.id = id;
//        this.name = name;
//        this.x = x;
//        this.y = y;
//    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wells)) return false;
        Wells wells = (Wells) o;
        return id == wells.id && Double.compare(wells.x, x) == 0 && Double.compare(wells.y, y) == 0 && name.equals(wells.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, x, y);
    }

    @Override
    public String toString() {
        return name;
    }

    public String toStringXY() {
        return name + " " + x + " " + y;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    private int id;
    private String name;
    private double x;
    private double y;
}
