class Solution {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length();

        int ch = n - 1;
        int length = 0;

        while (ch >= 0) {
            if (s.charAt(ch) == ' ') {
                return length;
            }
            length++;
            ch--;
        }

        return length;
    }
}
