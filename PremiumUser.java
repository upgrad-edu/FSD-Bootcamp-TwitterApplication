package com.upgrad.fsd;

public class PremiumUser extends User {

    public PremiumUser(String uName, int userId) {
        super(uName, userId);
    }

    /*

    public void recover_tweet_by_tweet_id(int tweetId, String userName) {
        User user = getUserIfValid(userName);
        Tweet t = getTweetIfValid(tweetId);

        if (user == null) {
            System.out.println("The user does not seem to exist!");
        } else if (t == null) {
            System.out.println("The tweet does not seem to exist!");
        } else if (!(user instanceof PremiumUser)) {
            System.out.println("The user is not allowed to perform this operation!");
        } else if (!t.isDeleted()) {
            System.out.println("The tweet is not deleted!");
        } else if (!t.getTweetOwner().equals(user)) {
            System.out.println("This user does not own this tweet!");
        } else {
            t.setDeleted(false);
            System.out.println("This tweet had been recovered successfully!");
        }
    }


     */



}
