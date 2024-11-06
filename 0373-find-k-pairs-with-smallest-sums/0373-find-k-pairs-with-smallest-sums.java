class Pair{
    
    int num1;
    int num2;
    int i;
    int j;
    
    Pair(int num1,int num2,int i,int j){
        this.num1 = num1;
        this.num2 = num2;
        this.i = i;
        this.j = j;
    }
}

class Solution {
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.num1+a.num2)-(b.num1+b.num2));
        Set<String> visited = new HashSet<>();
        
        pq.add(new Pair(nums1[0],nums2[0],0,0));
        visited.add((0)+","+(0));
        
        List<List<Integer>> result = new ArrayList<>();
        
        while(k-->0 && !pq.isEmpty()){
            
            Pair p = pq.poll();
            int num1 = p.num1;
            int num2 = p.num2;
            int i = p.i;
            int j = p.j;
            
            result.add(List.of(num1,num2));
            
            if(i+1<n1 && !visited.contains((i+1)+","+(j))){
                pq.add(new Pair(nums1[i+1],nums2[j],i+1,j));
                visited.add((i+1)+","+(j));
            }
            
            if(j+1<n2 && !visited.contains((i)+","+(j+1))){
                pq.add(new Pair(nums1[i],nums2[j+1],i,j+1));
                visited.add((i)+","+(j+1));
            }
            
        }
        
        return result;
    }
    
}






