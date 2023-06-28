class Pair {
    int row;
    int col;

    Pair(int r, int c) {
        row = r;
        col = c;
    }
}

class Solution {

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int totalOranges = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                }
                if (grid[i][j] != 0) {
                    totalOranges++;
                }
            }
        }

        int count = 0;
        int countMinutes = 0;

        int delrow[] = { -1, 0, +1, 0 };
        int delcol[] = { 0, +1, 0, -1 };

        while (!q.isEmpty()) {
            int size = q.size();
            count = count + size;

            for (int s = 0; s < size; s++) {
                int row = q.peek().row;
                int col = q.peek().col;
                q.poll();

                for (int i = 0; i < 4; i++) {
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];

                    if (nrow >= 0 && nrow < rows && ncol >= 0 && ncol < cols && grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }

            if (q.size() != 0) {
                countMinutes++;
            }
        }

        return totalOranges == count ? countMinutes : -1;
    }
}
