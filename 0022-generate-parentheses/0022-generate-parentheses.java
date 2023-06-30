class Solution {

    public List<String> generateParenthesis(int n) {
        int openCount = 0;
        int closeCount = 0;
        List<String> list = new ArrayList<>();

        recur(openCount, closeCount, "", n, list);
        return list;
    }

    public void recur(int openCount, int closeCount, String str, int n, List<String> list) {
        if (openCount == n && closeCount == n) {
            list.add(str);
        }

        if (openCount < n) {
            recur(openCount + 1, closeCount, str + "(", n, list);
        }

        if (closeCount < openCount) {
            recur(openCount, closeCount + 1, str + ")", n, list);
        }
    }
}
