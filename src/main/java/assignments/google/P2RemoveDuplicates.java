package assignments.google;

public class P2RemoveDuplicates {

    public int[] removeDuplicates(int[] values) {
        int writeIdx = 1;
        for (int i = 1; i < values.length; ++i) {
            int val = values[i];
            if (val != values[writeIdx - 1]) {
                values[writeIdx++] = val;
            }
        }
        int[] res = new int[writeIdx];
        System.arraycopy(values, 0, res, 0, writeIdx);
        return res;
    }
}