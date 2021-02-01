public class IntersectionofTwoArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0)
            return new int[] {};
        if (nums2 == null || nums2.length == 0)
            return new int[] {};
        Arrays.sort(nums1);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            if (binarySearch(nums1, nums2[i])) {
                set.add(nums2[i]);
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (int num : set) {
            result[k] = num;
            k++;
        }
        return result;
    }

    public boolean binarySearch(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target || nums[end] == target) {
            return true;
        } else {
            return false;
        }
    }
}
