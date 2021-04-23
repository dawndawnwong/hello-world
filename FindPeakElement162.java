public class FindPeakElement162 {
    // Time complexity: O(log N), Space complexity: O(1)
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] < nums[end]) {
            return end;
        } else {
            return start;
        }
    }
}
