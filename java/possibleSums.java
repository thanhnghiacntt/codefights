/*
You have a collection of coins, and you know the values of the coins and the quantity of each type of coin in it. You want to know how many distinct sums you can make from non-empty groupings of these coins.
*/
int possibleSums(int[] coins, int[] quantity) {
    Set<Integer> set = new HashSet<Integer>();
    addSet(set, 0, 0, coins, quantity);
    return set.size();
}

void addSet(Set<Integer> set, int sum, int i, int[] coins, int[] q) {
    if (i == q.length) {
        if (sum > 0) {
            set.add(sum);
        }
    } else {
        for (int j = 0; j <= q[i]; j++) {
            int temp = j * coins[i];
            addSet(set, sum + temp, i + 1, coins, q);
        }
    }
}