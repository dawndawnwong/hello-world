public class CapacityToShipPackagesWithinDDays1011 {
    public int shipWithinDays(int[] weights, int D) {
        int start = 0, end = 0;
        for (int w : weights) {
            start = Math.max(start, w);
            end += w;
        }
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            boolean canShip = canShip(weights, D, mid);
            if (canShip) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (canShip(weights, D, start)) {
            return start;
        } else {
            return end;
        }
    }

    public boolean canShip(int[] weights, int D, int capacity) {
        int needsDay = 1;
        int curWeights = 0;
        for (int w : weights) {
            if (curWeights + w > capacity) {
                needsDay++;
                curWeights = 0;
            }
            curWeights += w;
        }
        return (needsDay <= D);
    }
}
