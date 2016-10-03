package intecap.gt.proyecto_belleza2016;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;


public class Video extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String API_YOUTUBE = "AIzaSyCcoUT7cpFxWK4zquIJF_iFMN_Wxs9q3Og";
    private static final String VIDEO_ID = "YVN3IzbtkR0";
    private YouTubePlayerView yt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        yt = (YouTubePlayerView) findViewById(R.id.video);
        yt.initialize(API_YOUTUBE, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (VIDEO_ID!=null){
            try {
                youTubePlayer.loadVideo(VIDEO_ID);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
/*
        if (!b){
            youTubePlayer.cueVideo("5coJa7lrRQw");
        }*/
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "no funciono", Toast.LENGTH_LONG).show();
    }
}
