package com.upgrad.fsd;

import java.util.Scanner;

public class TwitterDriver {

    public static void main(String[] args) {
        TweetApplication application = new TweetApplication();
        Scanner input = new Scanner(System.in);

        int option;
        do {
            System.out.println("\nPlease choose your option:");
            System.out.println("1. Create User");
            System.out.println("2. Accept Follower");
            System.out.println("3. Post Tweet");
            System.out.println("4. Get Home Page");
            System.out.println("5. Follow a User");
            System.out.println("6. Delete tweet");
            System.out.println("7. Get Feed for User");
            System.out.println("8. Hide tweet");
            System.out.println("Press anything else to exit!");
            option = input.nextInt();
            String flush = input.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Please enter the user name: ");
                    String userName = input.nextLine();
                    application.create_user(userName);
                    break;
                case 2:
                    System.out.println("Please enter the user name of the user:");
                    String u1 = input.nextLine();
                    System.out.println("Please enter the user whose request you want to accept:");
                    String u2 = input.nextLine();
                    application.accept_follow_request(u1, u2);
                    break;
                case 3:
                    System.out.println("Please enter the user name: ");
                    userName = input.nextLine();
                    System.out.println("Please enter the tweet: ");
                    String tweet = input.nextLine();
                    application.post_tweet(tweet, userName);
                    break;
                case 4:
                    System.out.println("Please enter the user name: ");
                    userName = input.nextLine();
                    application.show_home_page(userName);
                    break;
                case 5:
                    System.out.println("Please enter the user name of the user:");
                    u1 = input.nextLine();
                    System.out.println("Please enter the user who you want to follow:");
                    u2 = input.nextLine();
                    application.submit_follow_request(u1, u2);
                    break;
                case 6:
                    System.out.println("Please enter the user name: ");
                    userName = input.nextLine();
                    System.out.println("Please enter the tweet id: ");
                    int tweetId = input.nextInt();
                    application.delete_tweet_by_tweet_id(tweetId, userName);
                    break;
                case 7:
                    System.out.println("Please enter the user name: ");
                    userName = input.nextLine();
                    application.show_user_feed_by_user_name(userName);
                    break;
                case 8:
                    System.out.println("Please enter the user name: ");
                    userName = input.nextLine();
                    System.out.println("Please enter the tweet id: ");
                    tweetId = input.nextInt();
                    application.hide_tweet_for_user_by_tweetid(userName, tweetId);
                    break;
                default:
                    System.out.println("Thank you for using!");
            }
        } while (option >= 1 && option <= 8);

        input.close();
    }
}
