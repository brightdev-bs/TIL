package flyweight;

public class Tree extends TreeType {
    private int x;
    private int y;
    private TreeType type;

    public Tree() {}
    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "x=" + x +
                ", y=" + y +
                ", type=" + type +
                '}';
    }
}
