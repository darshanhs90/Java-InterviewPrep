package Mar2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class _0355DesignTwitter {

	public static void main(String[] args) {
		Twitter twitter = new Twitter();

		// User 1 posts a new tweet (id = 5).
		twitter.postTweet(1, 5);

		// User 1's news feed should return a list with 1 tweet id -> [5].
		// System.out.println(twitter.getNewsFeed(1));

		// User 1 follows user 2.
		twitter.follow(1, 2);

		// User 2 posts a new tweet (id = 6).
		twitter.postTweet(2, 6);

		// User 1's news feed should return a list with 2 tweet ids -> [6, 5].
		// Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		System.out.println(twitter.getNewsFeed(1));

		// User 1 unfollows user 2.
		twitter.unfollow(1, 2);

		// User 1's news feed should return a list with 1 tweet id -> [5],
		// since user 1 is no longer following user 2.
		System.out.println(twitter.getNewsFeed(1));
	}

	static class Tweet {
		int tweetID;
		int uid;

		public Tweet(int tweetID, int uid) {
			this.tweetID = tweetID;
			this.uid = uid;
		}
	}

	static class Twitter {
		HashMap<Integer, HashSet<Integer>> userFollowersMap;
		HashMap<Integer, HashSet<Tweet>> userTweetsMap;
		int uid;

		/** Initialize your data structure here. */
		public Twitter() {
			this.userFollowersMap = new HashMap<Integer, HashSet<Integer>>();
			this.userTweetsMap = new HashMap<Integer, HashSet<Tweet>>();
			this.uid = 0;

		}

		/** Compose a new tweet. */
		public void postTweet(int userId, int tweetId) {
			if (!this.userFollowersMap.containsKey(userId)) {
				this.userFollowersMap.put(userId, new HashSet<Integer>());
				this.userTweetsMap.put(userId, new HashSet<Tweet>());
			}
			this.userFollowersMap.get(userId).add(userId);
			Tweet tweet = new Tweet(tweetId, uid++);
			this.userTweetsMap.get(userId).add(tweet);
		}

		/**
		 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
		 * the news feed must be posted by users who the user followed or by the user
		 * herself. Tweets must be ordered from most recent to least recent.
		 */
		public List<Integer> getNewsFeed(int userId) {
			if (!this.userFollowersMap.containsKey(userId))
				return new ArrayList<Integer>();

			List<Tweet> tweets = new ArrayList<Tweet>();

			Iterator<Integer> followers = this.userFollowersMap.get(userId).iterator();

			while (followers.hasNext()) {
				tweets.addAll(userTweetsMap.get(followers.next()));
			}

			Collections.sort(tweets, new Comparator<Tweet>() {
				@Override
				public int compare(Tweet o1, Tweet o2) {
					// TODO Auto-generated method stub
					return o2.uid - o1.uid;
				}
			});

			List<Integer> out = new ArrayList<Integer>();
			for (int i = 0; i < Math.min(tweets.size(), 10); i++) {
				out.add(tweets.get(i).tweetID);
			}
			return out;
		}

		/**
		 * Follower follows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void follow(int followerId, int followeeId) {
			if (!this.userFollowersMap.containsKey(followerId)) {
				this.userFollowersMap.put(followerId, new HashSet<Integer>());
				this.userTweetsMap.put(followerId, new HashSet<Tweet>());
			}

			this.userFollowersMap.get(followerId).add(followerId);
			if (!this.userFollowersMap.containsKey(followeeId)) {
				this.userFollowersMap.put(followeeId, new HashSet<Integer>());
				this.userTweetsMap.put(followeeId, new HashSet<Tweet>());
			}

			this.userFollowersMap.get(followeeId).add(followeeId);
			this.userFollowersMap.get(followerId).add(followeeId);
		}

		/**
		 * Follower unfollows a followee. If the operation is invalid, it should be a
		 * no-op.
		 */
		public void unfollow(int followerId, int followeeId) {
			if (!this.userFollowersMap.containsKey(followerId) || !this.userFollowersMap.containsKey(followeeId)) {
				return;
			}

			if (followerId == followeeId || !this.userFollowersMap.get(followerId).contains(followeeId)) {
				return;
			}

			this.userFollowersMap.get(followerId).remove(followeeId);
		}
	}

}
