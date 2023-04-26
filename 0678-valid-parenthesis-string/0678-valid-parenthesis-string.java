class Solution {

    public boolean checkValidString(String s) {
        int cmax = 0;
        int cmin = 0;
        // open parentheses count in range [cmin, cmax]

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                cmax++;
                cmin++;
            } else if (ch == ')') {
                cmax--;
                cmin--;
            } else if (ch == '*') {
                cmax++; // if `*` become `(` then openCount++
                cmin--; // if `*` become `)` then openCount--
                // if `*` become `` then nothing happens
                // So openCount will be in new range [cmin-1, cmax+1]
            }

            if (cmax < 0) {
                return false;
            }
            // Currently, don't have enough open parentheses to match close parentheses-> Invalid
            // For example: ())(

            cmin = Math.max(cmin, 0);
            // It's invalid if open parentheses count < 0 that's why cmin can't be negative

        }

        return cmin == 0;
    }
}
