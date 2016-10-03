package intecap.gt.proyecto_belleza2016.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import intecap.gt.proyecto_belleza2016.R;

public class DesarrolloActivity extends AppCompatActivity implements YouTubePlayer.OnInitializedListener {

    private ControlladorCortes.Cortes item;
    private YouTubePlayerSupportFragment frag;
    private static final String API_YOUTUBE = "AIzaSyCcoUT7cpFxWK4zquIJF_iFMN_Wxs9q3Og";
    private static final String VIDEO_ID = "PCiwDjzWaIk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desarrollo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(DesarrolloFragment.ARG_ITEM_ID,
                    getIntent().getStringExtra(DesarrolloFragment.ARG_ITEM_ID));
            DesarrolloFragment fragment = new DesarrolloFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.item_detail_container, fragment)
                    .commit();
        }

        frag = (YouTubePlayerSupportFragment) getSupportFragmentManager().findFragmentById(R.id.youtube_fragment);
        frag.initialize(API_YOUTUBE, this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {

            navigateUpTo(new Intent(this, Presentacion.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (VIDEO_ID!= null){
            try {
                youTubePlayer.loadVideo(VIDEO_ID);
            }
            catch (Exception e){
                e.printStackTrace();
                Toast.makeText(this, "no funciono", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this, "no funciono", Toast.LENGTH_LONG).show();
    }
}
