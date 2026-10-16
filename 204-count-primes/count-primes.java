class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] check = new boolean[n];
        check[0] = true; check[1] = true;

        for (int i = 2; i*i < n; i++) {
            if (!check[i]) {
                for (int j = i*i; j < n; j += i) {
                    check[j] = true;
                }
            }
        }

        int count = 1;
        for (int i = 3; i < n; i+=2) {
            if (!check[i]) count++;
        }

        return count;
    }
}