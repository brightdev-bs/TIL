package ch2.comparable;

public class NamedCompositionPoint implements Comparable<NamedPoint> {

    private final Point point;
    private final String name;

    public NamedCompositionPoint(Point point, String name) {
        this.point = point;
        this.name = name;
    }

    @Override
    public int compareTo(NamedPoint o) {
        return 0;
    }
}
