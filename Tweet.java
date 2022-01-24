package com.upgrad.fsd;

class Tweet {

    private int id;

    private boolean isDeleted;

    private String message;

    private User tweetOwner;

    public Tweet(int id) {
        this.id = id;
        this.isDeleted = false;
    }

    public Tweet(int id, String message, User tweetOwner) {
        this(id);
        this.message = message;
        this.tweetOwner = tweetOwner;
    }

    public int getId() {
        return id;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getMessage() {
        return message;
    }

    public User getTweetOwner() {
        return tweetOwner;
    }

}
