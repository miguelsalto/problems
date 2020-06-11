package assignments.google;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class P1TwoSumTest {

    @Test
    void testFindTwoSum() {
        P1TwoSum sol = new P1TwoSum();
        int[] input = {3, 1, 5, 7, 5, 9};
        int[] result = sol.findTwoSum(input, 10);
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals(5, Arrays.stream(input).sum());
    }
}