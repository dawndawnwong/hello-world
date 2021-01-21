public class SearchinRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[start] < nums[mid]) {
                if (target <= nums[mid] && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (target >= nums[mid] && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (target == nums[start]) {
            return start;
        } else if (target == nums[end]) {
            return end;
        } else {
            return -1;
        }
    }
}
