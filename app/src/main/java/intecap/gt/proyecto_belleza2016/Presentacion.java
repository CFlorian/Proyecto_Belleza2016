package intecap.gt.proyecto_belleza2016;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;


public class Presentacion extends AppCompatActivity  {
    private CollapsingToolbarLayout collapsingToolbarLayout = null;
    ArrayList<SeccionCortes> cortes = new ArrayList<SeccionCortes>();
    //private ListView listView;

    //private CardView damas, caballeros, ninos, ninas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presentacion);

        toolbar();
        dynamicToolbarColor();
        toolbarTextAppernce();
        //mostrarAdaptador();
        //selectOption();

        ListView lv = (ListView) findViewById(R.id.listview);
        AdapterCortes adapterCortes = new AdapterCortes(this, cortes);
        lv.setAdapter(adapterCortes);

    }
    /*
        private void mostrarAdaptador() {
            ListView lv = (ListView) findViewById(R.id.listview);
            AdapterCortes adapterCortes = new AdapterCortes(this, cortes);
            lv.setAdapter(adapterCortes);
        }


            private void selectOption() {
                damas = (CardView) findViewById(R.id.damas);
                caballeros = (CardView) findViewById(R.id.caballero);

                caballeros.setOnClickListener(this);
                damas.setOnClickListener(this);
            }
        */
    private void toolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Cortes y peinados");
    }


    private void dynamicToolbarColor() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.intecap);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(R.attr.colorAccent));
                collapsingToolbarLayout.setStatusBarScrimColor(palette.getMutedColor(R.attr.colorControlHighlight));
            }
        });
    }

    private void toolbarTextAppernce() {
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }



}
