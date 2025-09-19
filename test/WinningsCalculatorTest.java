import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class WinningsCalculatorTest
{
    @Test
    void testJackpot() {
        assertEquals(100000000, WinningsCalculator.calculateWinnings(5, true));
    }
    @Test
    void testFiveWhiteNoPower() {
        assertEquals(1000000, WinningsCalculator.calculateWinnings(5, false));
    }

    @Test
    void testFourWhiteYesPower() {
        assertEquals(50000, WinningsCalculator.calculateWinnings(4, true));
    }

    @Test
    void testFourWhiteNoPower() {
        assertEquals(100, WinningsCalculator.calculateWinnings(4, false));
    }

    @Test
    void testThreeWhiteYesPower() {
        assertEquals(100, WinningsCalculator.calculateWinnings(3, true));
    }

    @Test
    void testThreeWhiteNoPower() {
        assertEquals(7, WinningsCalculator.calculateWinnings(3, false));
    }

    @Test
    void testTwoWhiteYesPower() {
        assertEquals(7, WinningsCalculator.calculateWinnings(2, true));
    }

    @Test
    void testOneWhiteYesPower() {
        assertEquals(4, WinningsCalculator.calculateWinnings(1, true));
    }

    @Test
    void testOnlyPower() {
        assertEquals(4, WinningsCalculator.calculateWinnings(0, true));
    }

    @Test
    void testNoWin() {
        assertEquals(0, WinningsCalculator.calculateWinnings(0, false));
    }
}