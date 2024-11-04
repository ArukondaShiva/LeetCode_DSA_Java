class Pair{
    
    int count;
    int tweetId;

    Pair(int _count,int _tweetId){
        count = _count;
        tweetId = _tweetId;
    }
}

class Twitter {
    
    Map<Integer,Set<Integer>> followersMap;
    Map<Integer,PriorityQueue<Pair>> tweetsMap;
    int count;

    public Twitter() {
        followersMap = new HashMap<>();
        tweetsMap = new HashMap<>();
        count = 0;
    }
    
    
    public void postTweet(int userId, int tweetId) {
     
        tweetsMap.putIfAbsent(userId, new PriorityQueue<>((a, b) -> b.count - a.count));
        tweetsMap.get(userId).add(new Pair(count++, tweetId));
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        List<Integer> feedTweetIds = new ArrayList<>();
        PriorityQueue<Pair> feeds = new PriorityQueue<>((a,b)->b.count-a.count);
        
        if(tweetsMap.containsKey(userId)){
            feeds.addAll(tweetsMap.get(userId));
        }
        
        Set<Integer> followees = followersMap.getOrDefault(userId,new HashSet<>());
        
        for(Integer followee : followees){
            if(tweetsMap.containsKey(followee)){
                feeds.addAll(tweetsMap.get(followee));
            }
        }
        
        for(int i=0;i<10 && !feeds.isEmpty();i++){
            feedTweetIds.add(feeds.poll().tweetId);
        }
        
        return feedTweetIds;
    }
    
    public void follow(int followerId, int followeeId) {
        followersMap.putIfAbsent(followerId,new HashSet<>());
        followersMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followersMap.containsKey(followerId)){
            followersMap.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */