public class FirstBadVersion278 {
    public int firstBadVersion(int n) {
        //Time complexity : O(Logn), space complexity: O(1)
        int start = 1, end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (isBadVersion(start)) {
            return start;
        } else {
            return end;
        }
    }
}
