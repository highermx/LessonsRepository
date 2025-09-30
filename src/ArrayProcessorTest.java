import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayProcessorTest {

    @Test
    void testGetAfterLast4StandardCase() {
        int[] input = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        assertArrayEquals(new int[]{1, 7}, ArrayProcessor.getAfterLast4(input));
    }

    @Test
    void test4AtEnd() {
        int[] input = {4, 1, 3, 4};
        assertArrayEquals(new int[]{}, ArrayProcessor.getAfterLast4(input));
    }

    @Test
    void testSingle4() {
        int[] input = {2, 5, 3, 4};
        assertArrayEquals(new int[]{}, ArrayProcessor.getAfterLast4(input));
    }

    @Test
    void testNo4Exception() {
        int[] input = {1, 2, 3, 5};
        assertThrows(RuntimeException.class, () -> ArrayProcessor.getAfterLast4(input));
    }

    @Test
    void testValidCase() {
        int[] input = {1, 4, 4, 1};
        assertTrue(ArrayProcessor.hasOnly1And4(input));
    }

    @Test
    void testOnly1() {
        int[] input = {1, 1, 1};
        assertFalse(ArrayProcessor.hasOnly1And4(input));
    }

    @Test
    void testOnly4() {
        int[] input = {4, 4, 4};
        assertFalse(ArrayProcessor.hasOnly1And4(input));
    }

    @Test
    void testInvalidNumbers() {
        int[] input = {1, 4, 3, 2};
        assertFalse(ArrayProcessor.hasOnly1And4(input));
    }
}
