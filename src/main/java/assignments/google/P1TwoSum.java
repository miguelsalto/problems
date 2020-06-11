package assignments.google;

import java.util.HashMap;
import java.util.Map;

public class P1TwoSum {

    public int[] findTwoSum(int[] input, int target) {
        Map<Integer, Integer> valToIdx = new HashMap<>();
        for (int currentIdx = 0; currentIdx < input.length; ++currentIdx) {
            int val = input[currentIdx];
            Integer seenIdx = valToIdx.get(target - val);
            if (seenIdx != null) {
                return new int[]{seenIdx, currentIdx};
            }
            seenIdx = valToIdx.get(val + target);
            if (seenIdx != null) {
                return new int[]{seenIdx, currentIdx};
            }
            valToIdx.put(val, currentIdx);
        }
        return null;
    }
}