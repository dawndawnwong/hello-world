public class SearchinaSortedArrayofUnknownSize702 {
    public int search(ArrayReader reader, int target) {
        int end = 1;
        while (target > reader.get(end)) {
            end *= 2;
        }
        int start = end / 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == reader.get(mid)) {
                return mid;
            } else if (target < reader.get(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (target == reader.get(start)) {
            return start;
        } else if (target == reader.get(end)) {
            return end;
        } else {
            return -1;
        }
    }
}
