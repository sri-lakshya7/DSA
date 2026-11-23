class ProductOfNumbers {
    ArrayList<Integer> lst;

    public ProductOfNumbers() {
        this.lst = new ArrayList<>();
    }
    
    public void add(int num) {
        if (num == 0) lst.clear();
        else if (lst.size() == 0) lst.add(num);
        else lst.add(num * lst.get(lst.size()-1));
    }
    
    public int getProduct(int k) {
        int n = lst.size();
        if (k > n) return 0;
        int lastNum = lst.get(n-1);
        if (k == n) return lastNum;
        return lastNum/lst.get(n-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */