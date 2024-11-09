class Solution {
    
    public int largestInteger(int num) {
    
        String numStr = Integer.toString(num);
                int n = numStr.length();
        int[] digits = new int[n];

        for(int i=0;i<n;i++){
            digits[i] = numStr.charAt(i)-'0';
        }
        
        PriorityQueue<Integer> evenHeap = new PriorityQueue<>((a,b)->b-a);
        PriorityQueue<Integer> oddHeap = new PriorityQueue<>((a,b)->b-a);
        
        for(int i=0;i<n;i++){
            if(digits[i]%2==0){
                evenHeap.add(digits[i]);
            }else{
                oddHeap.add(digits[i]);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<n;i++){
            if(digits[i]%2==0){
                sb.append(""+evenHeap.poll());
            }
            else{
                sb.append(""+oddHeap.poll());
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
    
}