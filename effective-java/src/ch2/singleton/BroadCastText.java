package ch2.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BroadCastText {
    @Test
    void test() {
        BroadCast broadCast = new BroadCast(Elvis.INSTANCE);
        broadCast.perform();

        assertTrue(broadCast.isOn());
    }

    @Test
    void testWithMock() {
        BroadCast broadCast = new BroadCast(new MockElvis());
        broadCast.perform();

        assertTrue(broadCast.isOn());
    }
}