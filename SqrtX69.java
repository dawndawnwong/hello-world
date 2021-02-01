public class SqrtX69 {
    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        int start = 1, end = x;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (end > x / end) {
            return start;
        } else {
            return end;
        }
    }
}
