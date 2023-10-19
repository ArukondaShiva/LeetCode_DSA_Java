class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int gasSum = 0;
        int costSum = 0;

        for (int i = 0; i < n; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (gasSum < costSum) {
            return -1;
        }

        int startInd = 0;
        int curFuel = 0;

        for (int i = 0; i < n; i++) {
            curFuel += (gas[i] - cost[i]);

            if (curFuel < 0) {
                curFuel = 0;
                startInd = i + 1;
            }
        }

        return startInd;
    }
}
