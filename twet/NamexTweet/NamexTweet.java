import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "oykCI45coaH3qtGiVqTNKwO8a";
    private final static String CONSUMER_KEY_SECRET = "4i4hRqZfymbBVZ2DQ9OwxRT8W3YsfSZEbWfm2ZsWZNrjxgePp9";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hi, im updating status again from Namex Tweet for Demo tugas webservice FMP");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "v3dURimbGI3kDWvQj0iufaoS9fzNauduowcZaPHXOeV9b";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "1134445305343045643-nBIbTRc4liJ2yivQd3jH12udC8HDKl";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}
