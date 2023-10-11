class RandomizedSet {
    
    private Map<Integer, Boolean> map;

    public RandomizedSet() {
        map = new HashMap<Integer, Boolean>();
    }

    public boolean insert(int val) {
        boolean flag = false;
        if (!map.containsKey(val)) {
            flag = true;
            map.put(val, true);
        }
        return flag;
    }

    public boolean remove(int val) {
        boolean flag = false;
        if (map.containsKey(val)) {
            flag = true;
             map.remove(val);
        }
        return flag;
    }

    public int getRandom() {
        int min = 0;
        int max = map.keySet().size() - 1;
        int range = max - min + 1;

        int rand = (int) (Math.random() * range) + min;
        return (int) map.keySet().toArray()[rand];
    }
    
}
/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
