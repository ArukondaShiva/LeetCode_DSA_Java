class Solution {
    
    public boolean makesquare(int[] matchsticks) {
        
       if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }

        int sum = 0;
        
        for (int matchstick : matchsticks) {
            sum += matchstick;
        }
        
        if(sum%4!=0){
            return false;
        }
        
        int target = sum / 4;
        
        // Sort in descending order to try larger matchsticks first
        Arrays.sort(matchsticks);
        
        reverse(matchsticks);

        int[] sides = new int[4];
        
        Arrays.fill(sides, 0);

        return dfs(0, target, matchsticks, sides);
    }
    
    public boolean dfs(int ind,int target,int matchsticks[],int sides[]){
        
        if(ind==matchsticks.length){
            return sides[0]==target && sides[1]==target && sides[2]==target && sides[3]==target;
        }
        
        for(int i=0;i<4;i++){
            
            if(sides[i] + matchsticks[ind] <=target){
            
               sides[i] = sides[i] + matchsticks[ind];
            
               if(dfs(ind+1,target,matchsticks,sides)==true){
                  return true;
               }
            
               sides[i] = sides[i] - matchsticks[ind];  
            }
            
            if (sides[i] == 0) {
                break;
            }
        }
        
        return false;
    }
    
    
      private void reverse(int[] matchsticks) {
        int left = 0;
        int right = matchsticks.length - 1;
        while (left < right) {
            int temp = matchsticks[left];
            matchsticks[left] = matchsticks[right];
            matchsticks[right] = temp;
            left++;
            right--;
        }
    }
    
    
    
}