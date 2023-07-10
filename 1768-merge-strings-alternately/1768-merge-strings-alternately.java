class Solution {

    public String mergeAlternately(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        int i = 0;
        int j = 0;

        String res = "";

        while (i < n1 && j < n2) {
            res = res + word1.charAt(i) + word2.charAt(j);
            i++;
            j++;
        }

        if (i < n1) {
            res = res + word1.substring(i);
        }

        if (j < n2) {
            res = res + word2.substring(j);
        }

        return res;
    }
}
