/*
Post Tweet: Time Complexity: O(1), Space Complexity: O(1)
Get News Feed: Time Complexity: O(F + T log 10), Space Complexity: O(10) (F: followees, T: tweets processed)
Follow User: Time Complexity: O(1), Space Complexity: O(1)
Unfollow User: Time Complexity: O(1), Space Complexity: O(1)
*/

class Twitter {
    private static int timestamp = 0;
    private Map<Integer, Set<Integer>> userAndFollower;
    private Map<Integer, List<Tweet>> userAndTweet;

    private class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time){
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    public Twitter() {
        userAndFollower = new HashMap<>();
        userAndTweet = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        userAndTweet.putIfAbsent(userId, new ArrayList<>());
        userAndTweet.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);
        Set<Integer> followees = userAndFollower.getOrDefault(userId, new HashSet<>());
        followees.add(userId); // Include the user themselves

        // Add tweets from user and their followees
        for(int followee : followees){
            List<Tweet> tweets = userAndTweet.getOrDefault(followee, new ArrayList<>());
            int count = tweets.size();

            // Add only the most recent 10 tweets from each followee
            for(int i=count-1 ; i>=Math.max(0,count-10) ; i--){
                maxHeap.offer(tweets.get(i));
            }
        }


        // Retrieve up to 10 most recent tweets
        List<Integer> newsFeed = new ArrayList<>();
        for(int i=0 ; i<10 && !maxHeap.isEmpty() ; i++){
            newsFeed.add(maxHeap.poll().tweetId);
        }

        return newsFeed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId) return;
        userAndFollower.putIfAbsent(followerId, new HashSet<>());
        userAndFollower.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!userAndFollower.containsKey(followerId)) return;
        userAndFollower.get(followerId).remove(followeeId);
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
