class Solution {

    public boolean canJump(int[] nums) {
        int Reachable = 0;

        for (int i = 0; i < nums.length; i++) {
            if (Reachable < i) {
                return false;
            }
            Reachable = Math.max(Reachable, i + nums[i]);
        }

        return true;
    }
}
