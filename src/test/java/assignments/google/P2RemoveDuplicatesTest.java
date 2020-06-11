package assignments.google;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class P2RemoveDuplicatesTest {

    @Test
    void testRemoveDuplicates() {
        P2RemoveDuplicates sol = new P2RemoveDuplicates();
        int[] input = {1, 2, 3, 3, 3, 4, 4, 10, 13, 15, 15, 17};
        int[] expected = {1, 2, 3, 4, 10, 13, 15, 17};
        Assert.assertArrayEquals(expected, sol.removeDuplicates(input));
    }
}