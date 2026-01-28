package Heaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
Question:
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user,
 and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:

Twitter() Initializes your twitter object.
void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user userId. Each call to this function
 will be made with a unique tweetId.
List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's news feed. Each item in the news
 feed must be posted by users who the user followed or by the user themself. Tweets must be ordered from most recent to least recent.
void follow(int followerId, int followeeId) The user with ID followerId started following the user with ID followeeId.
void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing the user with ID followeeId.
*/


/*

The main challenge in this problem is retrieving the 10 most recent tweets across all followed users in an efficient way.
 Since each user may have multiple tweets, and tweets are ordered by recency, this becomes similar to merging K 
 sorted lists (one per user). To do this optimally, we use a Max-Heap (priority queue) to always fetch the most recent tweet. 
 The heap keeps at most one tweet from each list (user), and we simulate a merge sort–like process where we pop the latest tweet 
 and push the next most recent tweet from the same user (if any). This ensures that we only process what's necessary instead of
  sorting everything or traversing all tweets.

Maintain a map from each user to a list of their tweets (each tweet stores its timestamp).
Maintain a map of user to set of users they follow.
In postTweet(), add the tweet with a timestamp to the user’s list.
In follow() and unfollow(), update the user's follow set accordingly.
In getNewsFeed(), use a max heap to store the most recent tweets across all followed users and self.
For each user being followed (including self), if they have tweets, push their most recent tweet into the heap along with an index pointer.
Pop from the heap at most 10 times, each time adding that tweet ID to the result.
If more tweets exist for that user, push the next recent tweet from their list into the heap.
This simulates merging sorted tweet streams efficiently.


Time Complexity: postTweet, follow, and unfollow run in O(1). getNewsFeed takes O(log k) where k is the number
 of users followed (including self), since we maintain a min-heap with at most one tweet per user and extract up to 10 tweets.

Space Complexity: Storing tweets takes O(n), where n is total tweets. Follow relationships take O(u²) 
in worst case (if everyone follows everyone). Min-heap in getNewsFeed uses O(k) space, where k is number of users followed.*/
class Twitter{
    Map<Integer,List<int[]>>tweets;
    Map<Integer,Set<Integer>>follower;
    int time;

    public Twitter() {
        tweets = new HashMap<>();
        follower = new HashMap<>();
        time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new int[]{time++,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        if(tweets.containsKey(userId)){
            for(int[]tweet:tweets.get(userId)){
                pq.offer(tweet);
                if(pq.size() > 10){
                    pq.poll();
                }
            }
        }

        if(follower.containsKey(userId)){
            for(int followee : follower.get(userId)){
                if(tweets.containsKey(followee)){
                    for(int[]tweet:tweets.get(followee)){
                        pq.offer(tweet);
                        if(pq.size() > 10){
                            pq.poll();
                        }
                    }
                }
            }
        }
        LinkedList<Integer>res = new LinkedList<>();
        while(!pq.isEmpty()){
            res.addFirst(pq.poll()[1]);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        follower.putIfAbsent(followerId, new HashSet<>());
        follower.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        follower.get(followerId).remove(followeeId);
    }

}

public class DesignTwitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        twitter.postTweet(1, 2);
        twitter.postTweet(2, 6);

        System.out.println(twitter.getNewsFeed(1)); // [2]
        twitter.follow(1, 2);
        System.out.println(twitter.getNewsFeed(1)); // [6,2]
        twitter.unfollow(1, 2);
        twitter.postTweet(1, 7);
        System.out.println(twitter.getNewsFeed(1)); // [7,2]
    }
}
