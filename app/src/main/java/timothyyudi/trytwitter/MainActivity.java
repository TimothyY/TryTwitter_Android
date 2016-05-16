package timothyyudi.trytwitter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
//    private static String TWITTER_KEY = "2302840674-rEy02ZRY1hqTaWAf9xVTTfdeXNhUCklJbCWmx0c";
    private static String TWITTER_KEY = "YrvUuBYqHsxt0oWXywulRtMMU";
//    private static String TWITTER_SECRET = "gz8yQgzq85SZLgNATXELVyfQ68BUm0t2cxbjqkmVAZN6W";
    private static String TWITTER_SECRET = "RQGHPxJwq1Q0JISuJoH3asP3ZB9SSXnYJ6PunclYuYIJ6TR7Sy";

    TwitterLoginButton twLoginButton;
    Button btnTweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
//        Fabric.with(this, new Twitter(authConfig));
//        setContentView(R.layout.activity_main);
//
//        twLoginButton = (TwitterLoginButton) findViewById(R.id.login_button);
//        twLoginButton.setCallback(new Callback<TwitterSession>() {
//            @Override
//            public void success(Result<TwitterSession> result) {
//                // Do something with result, which provides a TwitterSession for making API calls
//
//            }
//
//            @Override
//            public void failure(TwitterException exception) {
//                // Do something on failure
//            }
//        });
//
//        btnTweet = (Button) findViewById(R.id.btnTweet);
//        btnTweet.setOnClickListener(this);

        startActivity(new Intent(this,DirectTweetActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Pass the activity result to the login button.
        twLoginButton.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnTweet) {
            TwitterSession session = Twitter.getSessionManager().getActiveSession();
            TwitterAuthToken authToken = session.getAuthToken();
            String token = authToken.token;
            String secret = authToken.secret;

            TwitterAuthConfig authConfig = new TwitterAuthConfig(token, secret);
            Fabric.with(this, new Twitter(authConfig));

            TweetComposer.Builder builder = new TweetComposer.Builder(this)
                    .text("Just setting up my Fabric. #test");
//                .image(myImageUri);
            builder.show();
        }
    }
}
