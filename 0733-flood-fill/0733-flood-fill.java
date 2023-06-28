class Pair{
    int row;
    int col;
    Pair(int r,int c){
        row = r;
        col = c;
    }
}

class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int vis[][] = new int[n][m];

        for (int row[] : vis) {
            Arrays.fill(row, 0);
        }

        int ans[][] = image;

        int iniColor = image[sr][sc];

        int delrow[] = { -1, 0, +1, 0 };
        int delcol[] = { 0, +1, 0, -1 };

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(sr, sc));
        vis[sr][sc] = 1;
        ans[sr][sc] = color;

        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && ans[nrow][ncol] == iniColor && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow, ncol));
                    ans[nrow][ncol] = color;
                }
            }
        }

        return ans;
    }
}
