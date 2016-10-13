package com.sankuai.meituan.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Tweet {
    int id;//primary key
    long time;
}

class User {
    int id;
    List<Integer> followeeIdList = new ArrayList<>();//user 关注的人的Id list
    List<Tweet> tweetList = new ArrayList<>();
    
    public void createTweet(int tweetId) {
        Tweet tweet = new Tweet();
        tweet.id = tweetId;
        tweet.time = System.nanoTime();
        tweetList.add(tweet);
    }
    
    public void follow(int followeeId) {
        if (followeeIdList.contains(followeeId)) 
            return;
        followeeIdList.add(followeeId);
    }
    public void unfollow(int followeeId) {
        // if (!followeeIdList.contains(followeeId)) 
            // return;
        followeeIdList.remove(new Integer(followeeId));
    }
}

public class Twitter {
    
    private Map<Integer, User> userMap = new HashMap<>();
    
    /** Initialize your data structure here. */
    public Twitter() {
        
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User user = userMap.get(userId);
        if (user == null) {
            user = new User();
            userMap.put(userId, user);
        }
        user.id = userId;
        user.createTweet(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        User user = userMap.get(userId);
        if (user == null) return new ArrayList<Integer>();
        List<Tweet> tweets = new ArrayList<>();
        tweets.addAll(user.tweetList);
        List<Integer> followeeIdList = user.followeeIdList;
        for (Integer followeeId : followeeIdList) {
            User followee = userMap.get(followeeId);
            if (followee == null) continue;
            tweets.addAll(followee.tweetList);
        }
        Collections.sort(tweets, new Comparator<Tweet>(){
            public int compare(Tweet t1, Tweet t2) {
                return (int)(t2.time - t1.time);
            }
        });
        if (tweets.size() > 10) {
            tweets = tweets.subList(0, 10);
        }
        List<Integer> result = new ArrayList<>();
        for (Tweet tweet : tweets) {
            result.add(tweet.id);
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        User user = userMap.get(followerId);
        if (user == null) {
            user = new User();
            userMap.put(followerId, user);
        }   
        user.id = followerId;
        user.follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        User user = userMap.get(followerId);
        if (user == null) {
            return;
        } 
        user.unfollow(followeeId);
    }
    
    public static void main(String[] args) {
		Twitter tw = new Twitter();
		tw.postTweet(1, 5);
		tw.postTweet(1, 3);
		List<Integer> list = tw.getNewsFeed(1);
		System.out.println(list);
	}
    
    
}
