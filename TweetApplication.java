package com.upgrad.fsd;

public class TweetApplication {

    private User[] allUsers;
    private Tweet[] allTweets;

    private int maxTweetId;
    private int maxUserId;

    public TweetApplication() {
        this.allUsers = new User[10000];
        this.allTweets = new Tweet[50000];

        this.maxTweetId = -1;
        this.maxUserId = -1;
    }

    public void create_user(String userName) {
        if (maxUserId == 9999) {
            System.out.println("Sorry, we cannot on-board new users for now!");
        } else if (getUserIfValid(userName) != null) {
            System.out.println("The username already exists!");
        } else {
            maxUserId++;
            User user = new User(userName, maxUserId);
            allUsers[maxUserId] = user;
            System.out.println("User created successfully!");
        }
    }

    public void accept_follow_request(String mainUser, String follower) {

        User main = getUserIfValid(mainUser);
        User follow = getUserIfValid(follower);

        if (main == null || follow == null) {
            System.out.println("Invalid user names!");
            return;
        }

        main.accept_follow_request(follow);
        follow.start_following_user(main);
    }

    public void post_tweet(String tweet, String userName) {
        if (tweet == null || tweet.equals(""))
            System.out.println("The message cannot be blank!");
        else if (maxTweetId == 49999) {
            System.out.println("Sorry, we cannot support more tweets now.");
        } else {
            User user = getUserIfValid(userName);
            if (user == null) {
                System.out.println("The user does not seem to exist!");
            } else {
                maxTweetId++;
                Tweet t = new Tweet(maxTweetId, tweet, user);
                allTweets[maxTweetId] = t;
                user.add_tweet(t);
            }
        }

    }

    public void show_home_page(String userName) {
        User user = getUserIfValid(userName);

        if(user == null) {
            System.out.println("Invalid user names!");
            return;
        }

        Tweet[] tweets = user.getMyTweets();
        boolean isEmptyHomePage = true;

        for (int i = 0; i < tweets.length; i++) {
            if (tweets[i] != null && !tweets[i].isDeleted()) {
                isEmptyHomePage = false;
                System.out.println(tweets[i].getId() + ": " + tweets[i].getMessage());
                System.out.println();
            } else {
                break;
            }
        }

        if (isEmptyHomePage) {
            System.out.println("Your home page seems to be empty!");
        }
    }

    public void submit_follow_request(String mainUser, String userNameToFollow) {

        User main = getUserIfValid(mainUser);
        User userToFollow = getUserIfValid(userNameToFollow);

        if (main == null || userToFollow == null) {
            System.out.println("Invalid user names!");
            return;
        }

        userToFollow.list_follow_request(main);
    }

    public void delete_tweet_by_tweet_id(int tweetId, String userName) {
        User user = getUserIfValid(userName);
        Tweet t = getTweetIfValid(tweetId);

        if (user == null) {
            System.out.println("The user does not seem to exist!");
        } else if (t == null) {
            System.out.println("The tweet does not seem to exist!");
        } else if (t.isDeleted()) {
            System.out.println("The tweet has already been deleted!");
        } else if (!t.getTweetOwner().equals(user)) {
            System.out.println("This user does not own this tweet!");
        } else {
            t.setDeleted(true);
            System.out.println("This tweet had been deleted successfully!");
        }
    }

    public void show_user_feed_by_user_name(String userName) {
        User user = getUserIfValid(userName);

        if (user == null) {
            System.out.println("The user does not seem to exist!");
        } else {
            boolean isEmptyFeed = true;
            for (User followers : user.getFollowing()) {
                if (followers != null) {
                    for (Tweet t : followers.getMyTweets()) {
                        if (t != null && !t.isDeleted()  && !user.has_hidden_tweet(t)) {
                                System.out.println(t.getId() + ": " + t.getMessage());
                                isEmptyFeed = false;
                        }
                    }
                }
            }

            if (isEmptyFeed) {
                System.out.println("The user's feed is empty!");
            }
        }
    }

    public void hide_tweet_for_user_by_tweetid(String userName, int tweetId) {
        User user = getUserIfValid(userName);
        Tweet t = getTweetIfValid(tweetId);

        if (user == null) {
            System.out.println("The user does not seem to exist!");
        } else if (t == null) {
            System.out.println("The tweet does not seem to exist!");
        } else if (t.isDeleted()) {
            System.out.println("The tweet has already been deleted!");
        } else {
            User tweetOwner = t.getTweetOwner();

            boolean isUserAFollower = false;
            for (User user1 : user.getFollowing()) {
                if (user1 != null && user1.getUserId() == tweetOwner.getUserId()) {
                    isUserAFollower = true;
                    break;
                }
            }

            if (!isUserAFollower) {
                System.out.println("This tweet is not in the feed of the user!");
            }

            boolean isTweetAlreadyHidden = false;
            for (Tweet tweet : user.getHiddenTweets()) {
                if (tweet != null && tweet.getId() == t.getId()) {
                    isTweetAlreadyHidden = true;
                    break;
                }
            }

            if (isTweetAlreadyHidden) {
                System.out.println("This tweet has already been hidden!");

            }

            for (int i = 0; i < user.getHiddenTweets().length; i++) {
                if (user.getHiddenTweets()[i] == null) {
                    user.getHiddenTweets()[i] = t;
                    break;
                }
            }

        }
    }

    public User getUserIfValid(String userName) {
        for (User user : allUsers) {
            if (user != null && user.getUserName().equals(userName)) {
                return user;
            }
        }

        return null;
    }

    public Tweet getTweetIfValid(long tweetId) {
        for (Tweet tweet : allTweets) {
            if (tweet.getId() == tweetId) {
                return tweet;
            }
        }

        return null;
    }
}
