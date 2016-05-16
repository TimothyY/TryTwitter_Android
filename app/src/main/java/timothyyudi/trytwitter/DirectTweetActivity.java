package timothyyudi.trytwitter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import io.fabric.sdk.android.Fabric;

public class DirectTweetActivity extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static String TWITTER_KEY = "2302840674-rEy02ZRY1hqTaWAf9xVTTfdeXNhUCklJbCWmx0c";
    private static String TWITTER_SECRET = "gz8yQgzq85SZLgNATXELVyfQ68BUm0t2cxbjqkmVAZN6W";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        setContentView(R.layout.activity_main);

//        File myImageFile = new File("/path/to/image");
//        Uri myImageUri = Uri.fromFile(myImageFile);

        TweetComposer.Builder builder = new TweetComposer.Builder(this)
                .text("just setting up my Fabric. #tes");
//                .image(myImageUri);
        builder.show();
    }
}
