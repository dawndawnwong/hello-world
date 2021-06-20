public class SplitArrayLargestSum410 {
    public int splitArray(int[] nums, int m) {
        int start = 0, end = 0;
        for(int n : nums) {
            start = Math.max(start, n);
            end += n;
        }

        while (start < end) {
            int mid = start + (end - start) / 2;
            if (canDivide(nums, mid, m)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private boolean canDivide(int[] nums, int target, int m) {
        int sum = 0, count = 1;
        for (int n: nums) {
            if (sum + n > target) {
                count++;
                sum = 0;
            }
            sum += n;
        }
        return (count <= m);
    }
}