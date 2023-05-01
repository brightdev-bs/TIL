package com.example.tdd;

import com.example.Triangle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    @Test
    void getShape() {

        // 정삼각형
        int triangleShape = getTriangleShape(1, 1, 1);
        assertEquals(1, triangleShape);

        // 이등변 삼각형
        int triangleShape1 = getTriangleShape(1, 2, 2);
        assertEquals(2, triangleShape1);
        int triangleShape2 = getTriangleShape(2, 1, 2);
        assertEquals(2, triangleShape2);
        int triangleShape3 = getTriangleShape(2, 2, 1);
        assertEquals(2, triangleShape3);

        // 부등변 삼각형
        int triangleShape4 = getTriangleShape(1, 2, 3);
        assertEquals(3, triangleShape4);
    }


    int getTriangleShape(int a, int b, int c) {
        if(a == b && a == c)
            return 1;
        else if((a != b && b == c ) || (b != c && a == c ) || (c != a) && a == b)
            return 2; // 이등변 삼각형
        else if(a != b && b != c && a != c) return 3;
        return 0;
    }
}
