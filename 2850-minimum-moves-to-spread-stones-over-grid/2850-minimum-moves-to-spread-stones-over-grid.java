class Pair{
    private int X;
    private int Y;
    
    Pair(int X,int Y){
        this.X = X;
        this.Y = Y;
    }
    
    public int getX(){
        return this.X;
    }
    
    public int getY(){
        return this.Y;
    }
    
}

class Solution {
    
    public int minimumMoves(int[][] grid) {
        
        List<Pair> zerosList = new ArrayList<>();
        List<Pair> extrasList = new ArrayList<>();
        
        int n = grid.length;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    zerosList.add(new Pair(i,j));
                }
                
                if(grid[i][j]>1){
                    extrasList.add(new Pair(i,j));
                }
            }
        }
        
        if(zerosList.size()==0){
            return 0;
        }
        
       return dfs(0,zerosList, extrasList, grid);
    }
    
    public int dfs(int ind,List<Pair> zerosList, List<Pair> extrasList, int grid[][]){
        
        if(ind==zerosList.size()){
            return 0;
        }
        
        int curZeroX = zerosList.get(ind).getX();
        int curZeroY = zerosList.get(ind).getY();
        
        int ans = 100000;
        
        for(int i=0;i<extrasList.size();i++){
            
            int curExtraX = extrasList.get(i).getX();
            int curExtraY = extrasList.get(i).getY();
            
            if(grid[curExtraX][curExtraY]>1){
            
              grid[curZeroX][curZeroY] = 1;
              grid[curExtraX][curExtraY]--;
            
              ans = Math.min(ans,((Math.abs(curZeroX-curExtraX)+Math.abs(curZeroY-curExtraY)))+dfs(ind+1,zerosList,extrasList,grid));
            
              grid[curZeroX][curZeroY] = 0;
              grid[curExtraX][curExtraY]++;  
            }
            
        }
        
        return ans;
    }
    
}











