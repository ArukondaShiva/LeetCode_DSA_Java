class Solution {

    public boolean checkValidString(String s) {
        int cmax = 0;
        int cmin = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                cmax++;
                cmin++;
            } else if (ch == ')') {
                cmax--;
                cmin--;
            } else if (ch == '*') {
                cmax++;
                cmin--;
            }

            if (cmax < 0) {
                return false;
            }

            cmin = Math.max(cmin, 0);
        }

        return cmin == 0;
    }
}
