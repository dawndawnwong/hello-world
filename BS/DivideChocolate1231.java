public class DivideChocolate1231 {

    public int maximizeSweetness(int[] sweetness, int K) {
        int start = 0, end = 0;
        for (int s : sweetness) {
            end += s;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            boolean canCut = canCut(sweetness, K, mid);
            if (canCut) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (canCut(sweetness, K, end)) {
            return end;
        } else {
            return start;
        }
    }

    public boolean canCut(int[] sweetness, int K, int target) {
        int count = 0, curSum = 0;
        for (int s : sweetness) {
            curSum += s;
            if (curSum >= target) {
                count++;
                curSum = 0;
            }
        }
        return (count >= K + 1);
    }
}
