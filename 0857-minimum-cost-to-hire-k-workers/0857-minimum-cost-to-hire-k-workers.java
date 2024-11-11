class Pair{
    int quality;
    int wage;
    double ratio;
    Pair(int quality,int wage,double ratio){
        this.quality = quality;
        this.wage = wage;
        this.ratio = ratio;
    }
}

class Solution {
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        
        int n= quality.length;
        
        List<Pair> workers = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            workers.add(new Pair(quality[i],wage[i],(double)wage[i]/quality[i]));
        }
        
        Collections.sort(workers,(a,b)->Double.compare(a.ratio,b.ratio));
        
        PriorityQueue<Integer> qualityPq = new PriorityQueue<>((a,b)->b-a);
        
        int totalQuality = 0;
        double minCost = Double.MAX_VALUE;
        
        for(Pair p : workers){
            
            qualityPq.add(p.quality);
            totalQuality += p.quality;
            
            if(qualityPq.size()>k){
                totalQuality -= qualityPq.poll();
            }
            
            if(qualityPq.size()==k){
                minCost = Math.min(minCost,(double)(totalQuality*p.ratio));
            }
            
        }
        
        return minCost;
    }
    
}








