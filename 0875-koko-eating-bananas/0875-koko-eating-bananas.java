class Solution {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = (int) (1e9);

        int ans = -1;

        while (low <= high) {
            int mid = low+(high-low)/2;

            if (canEatInTime(piles, mid, h)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canEatInTime(int piles[], int k, int h) {
        int hours = 0;

        for (int bananas : piles) {
            
            hours = hours + (int) Math.ceil((double) bananas / k);
            
            if(hours>h){
                break;
            }
        }
        return hours <= h;
    }
}
