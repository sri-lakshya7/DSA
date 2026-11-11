class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long cost = 0;
        if (cost1 >= costBoth && cost2 >= costBoth) cost = Math.max(need1, need2) * (long)costBoth;
        else if (cost2 >= costBoth && cost1 < costBoth) {
            if (need1 > need2) {
                cost += need2 * (long)costBoth;
                cost += (need1 - need2) * (long)cost1;
            } else {
                cost += need2 * (long)costBoth;
            }
        } else if (cost1 >= costBoth && cost2 < costBoth) {
            if (need2 > need1) {
                cost += need1 * (long)costBoth;
                cost += (need2 - need1) * (long)cost2;
            } else {
                cost += need1 * (long)costBoth;
            }
        } 
        else {
            if (costBoth < (long)cost1 + cost2) {
                int shared = Math.min(need1, need2);
                cost += shared * (long)costBoth;
                cost += (need1 - shared) * (long)cost1;
                cost += (need2 - shared) * (long)cost2;
            } else cost += (need1 * (long)cost1) + (need2 * (long)cost2);
        }

        return cost;
    }
}
