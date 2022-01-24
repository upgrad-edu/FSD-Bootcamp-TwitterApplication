package com.upgrad.fsd;

class User {

    private int userId;

    private String userName;

    private User[] followers;

    private User[] following;

    private User[] followRequests;

    private Tweet[] hiddenTweets;

    private Tweet[] myTweets;

    public User(String uName, int userId) {
        userName = uName;
        this.userId = userId;
        followers = new User[100];
        following = new User[100];
        followRequests = new User[100];
        myTweets = new Tweet[500];
        hiddenTweets = new Tweet[500];
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public User[] getFollowing() {
        return following;
    }

    public Tweet[] getHiddenTweets() {
        return hiddenTweets;
    }

    public Tweet[] getMyTweets() {
        return myTweets;
    }

    public void accept_follow_request(User user) {
        if (user == null) {
            System.out.println("Invalid user names!");
            return;
        }

        boolean isValidRequest = false;

        for(int i = 0; i < followRequests.length; i++) {
            if (followRequests[i] == null) {
                break;
            }

            if (followRequests[i].getUserId() == user.getUserId()) {
                isValidRequest = true;
                followRequests[i] = null;
            }
        }

        if (!isValidRequest) {
            System.out.println("User hasn't requested to follow!");
            return;
        }

        for(int i = 0; i < followers.length; i++) {
            if (followers[i] == null) {
                followers[i] = user;
                break;
            }
        }

    }

    public void list_follow_request(User user) {
        if (user == null) {
            System.out.println("Invalid user names!");
            return;
        }

        for(int i = 0; i < followRequests.length; i++) {
            if (followRequests[i] == null) {
                followRequests[i] = user;
                break;
            }
        }
    }

    public void start_following_user(User user) {
        if (user == null) {
            System.out.println("Invalid user names!");
            return;
        }

        for(int i = 0; i < following.length; i++) {
            if (following[i] == null) {
                following[i] = user;
                break;
            }
        }

    }

    public void add_tweet(Tweet t) {
        for(int i = 0; i < myTweets.length; i++) {
            if (myTweets[i] == null) {
                myTweets[i] = t;
                return;
            }
        }
    }

    public boolean has_hidden_tweet(Tweet t) {
        for (Tweet tweet : hiddenTweets) {
            if (tweet != null && tweet.getId() == t.getId()) {
                return true;
            }
        }

        return false;
    }
}
