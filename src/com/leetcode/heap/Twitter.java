package com.leetcode.heap;

import java.util.*;

public class Twitter {

    /**
     *
     */
    class Tweet{
        int id;
        int timestamp;
        Tweet next;
        public Tweet(int id,int timestamp,Tweet next){
            this.id= id;
            this.timestamp =timestamp;
            this.next = next;
        }
    }
    private  int timestamp;
    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer,Tweet> tweetMap;
    /** Initialize your data structure here. */
    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
        timestamp = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        Tweet next = null;
        if(tweetMap.containsKey(userId)){
            next = tweetMap.get(userId);
        }
        tweetMap.put(userId, new Tweet(tweetId, timestamp, next));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed.
     * Each item in the news feed must be posted by users who the user followed or by the user herself.
     * Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {

        List<Integer> ret = new ArrayList<>();
        /**动态维护数据的有序性*/
        PriorityQueue<Tweet> pq = new PriorityQueue<>((p, q) -> q.timestamp - p.timestamp);
        if(tweetMap.containsKey(userId)){
            pq.offer(tweetMap.get(userId));
        }
        /**
         * 合并多个有序链表
         */
        if(followMap.containsKey(userId)){
            for(Integer followerId:followMap.get(userId)){
                Tweet tweet = tweetMap.get(followerId);
                if(tweet!=null){
                    pq.offer(tweet);
                }
            }
        }

        while (!pq.isEmpty()){

            Tweet tweet = pq.poll();
            ret.add(tweet.id);
            if(ret.size()>=10){
                break;
            }
            if(tweet.next!=null){
                pq.add(tweet.next);
            }
        }
        return ret;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followeSet = null;
        if(followMap.containsKey(followerId)){
            followeSet = followMap.get(followerId);
            if(!followeSet.contains(followeeId)){
                followeSet.add(followeeId);
            }
        }else{
            followeSet = new HashSet<>();
            followeSet.add(followeeId);
            followMap.put(followerId, followeSet);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId)){
            Set<Integer> followeSet = followMap.get(followerId);
            if(followeSet.contains(followeeId)){
                followeSet.remove(followeeId);
            }
        }
    }
}
