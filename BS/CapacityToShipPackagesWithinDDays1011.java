public class CapacityToShipPackagesWithinDDays1011 {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0, end = 0;
        for (int w : weights) {
            start = Math.max(start, w);
            end += w;
        }

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            boolean canShip = canShip(weights, days, mid);
            if (canShip) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (canShip(weights, days, start)) {
            return start;
        } else {
            return end;
        }
    }

    private boolean canShip(int[] weights, int days, int capacity) {
        int needDay = 1;
        int curWeights = 0;
        for (int w : weights) {
            if (curWeights + w > capacity) {
                needDay++;
                curWeights = 0;
            }
            curWeights += w;
        }
        return (needDay <= days);
    }

    // Binary Search with one method
    public int shipWithinDays2(int[] weights, int days) {
        int start = 0, end = 0;
        for (int w : weights) {
            start = Math.max(start, w);
            end += w;
        }
        while (start < end) {
            int mid = start + (end - start) / 2, needDays = 1, curWeight = 0;
            for (int w : weights) {
                if (curWeight + w > mid) {
                    needDays++;
                    curWeight = 0;
                }
                curWeight += w;
            }
            if (needDays > days)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
}
