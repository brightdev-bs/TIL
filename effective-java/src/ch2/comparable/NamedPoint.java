package ch2.comparable;

import java.util.Comparator;
import java.util.TreeSet;

public class NamedPoint extends Point {

    private String name;

    public NamedPoint(int x, int y, int z, String name) {
        super(x, y, z);
        this.name = name;
    }

    @Override
    public String toString() {
        return "NamedPoint{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    public static void main(String[] args) {
        NamedPoint p1 = new NamedPoint(1, 1, 1, "좌표");
        NamedPoint p2 = new NamedPoint(1, 2, 3, "좌표2");

        TreeSet<NamedPoint> points = new TreeSet<>(new Comparator<NamedPoint>() {
            @Override
            public int compare(NamedPoint o1, NamedPoint o2) {
                int result = Integer.compare(o1.getX(), o2.getX());
                if(result == 0) {
                    result = Integer.compare(o1.getY(), o2.getY());
                    if(result == 0) {
                        result = Integer.compare(o1.getZ(), o2.getZ());
                    }
                }
                if(result == 0) {
                    result = o1.name.compareTo(o2.name);
                }
                return result;
            }
        });

        points.add(p1);
        points.add(p2);

        System.out.println(points);
    }
}
