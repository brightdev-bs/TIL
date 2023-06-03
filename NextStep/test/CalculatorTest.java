import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private Calculator cal;
    @BeforeEach
    public void setup() {
        cal = new Calculator();
    }

    @Test
    public void add() {
        assertEquals(9, cal.add(6, 3));
    }
    @Test
    public void subtract() {
        assertEquals(3, cal.subtract(6, 3));
    }

    // 쉼표 또는 콜론을 구분자로 각 숫자의 합을 반환한다.
    @Test
    public void splitAndAdd() {
        assertEquals(0, cal.splitAndGetSum(null));
        assertEquals(0, cal.splitAndGetSum(" "));
        assertEquals(1, cal.splitAndGetSum("1"));
        assertEquals(3, cal.splitAndGetSum("1,2"));
        assertEquals(6, cal.splitAndGetSum("1,2,3"));
        assertEquals(6, cal.splitAndGetSum("1,2:3"));
    }

    // 커스텀 구분자를 지정할 수 있다.
    @Test
    public void customAdd() {
        assertEquals(6, cal.splitAndGetSum("//;\n1;2;3"));
    }


    // 문자열 계산기에 음수를 전달하는 경우 RuntimeException으로 예외 처리한다.
    @Test
    public void minusNumbersRuntimeException() {
        assertThrows(RuntimeException.class, () -> cal.splitAndGetSum("-1,2"));
    }
}
