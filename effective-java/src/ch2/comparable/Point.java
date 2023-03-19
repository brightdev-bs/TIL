package ch2.comparable;

import java.util.Objects;

public class Point implements Comparable<Point> {

    int x, y, z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public int compareTo(Point o) {
        int result = this.x - o.x;        // 가장 중요한 필드
        if(result == 0) {
            result = this.y - o.y;        // 두 번째로 중요한 필드
            if(result == 0) {
                result = this.z - o.z;    // 세 번째로 중요한 필드
            }
        }
        return result;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
