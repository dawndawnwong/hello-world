public class IntersectionofTwoArraysII350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0)
            return new int[] {};
        if (nums1 == null || nums1.length == 0)
            return new int[] {};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        int start = 0, end = nums1.length - 1;
        for (int i = 0; i < nums2.length; i++) {
            int index = binarySearch(nums1, nums2[i], start, end);
            if (index != -1) {
                start = index + 1;
                list.add(nums2[i]);
            }
        }
        int[] result = new int[list.size()];
        int k = 0;
        for (int num : list) {
            result[k++] = num;
        }
        return result;
    }

    private int binarySearch(int[] nums, int target, int start, int end) {
        if (start >= nums.length)
            return -1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid;
            } else {
                end = mid;
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
