package intecap.gt.proyecto_belleza2016;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import intecap.gt.proyecto_belleza2016.prueba.Presentacion;
import intecap.gt.proyecto_belleza2016.view.DragNDrop;
import intecap.gt.proyecto_belleza2016.view.DragNDropTiposActivity;

public class Navigation_menu extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView recycler, recycler2;
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView.LayoutManager lManager, lManager2;
    private GridLayoutManager glm, glm2;
    private RecyclerView upRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragment = new Presentacion();
        fragmentManager.beginTransaction().replace(R.id.contenedor, fragment).commit();
        //presentacionMenu();
    }

/*ate void presentacionMenu() {
        List<PresentacionMenu> items = new ArrayList<>();//img / nombre
        items.add(new PresentacionMenu(R.mipmap.cortedama, "Damas"));
        items.add(new PresentacionMenu(R.mipmap.cortedama, "Caballero"));
        items.add(new PresentacionMenu(R.mipmap.cortedama, "Niños"));
        items.add(new PresentacionMenu(R.mipmap.cortedama, "Niñas"));

        List<PresentacionMenu> item = new ArrayList<>();
        item.add(new PresentacionMenu(R.mipmap.cortedama, "Damas"));
        item.add(new PresentacionMenu(R.mipmap.cortedama, "Caballeros"));
        item.add(new PresentacionMenu(R.mipmap.cortedama, "Niños"));
        item.add(new PresentacionMenu(R.mipmap.cortedama, "Niñas"));


       *//*
       *  List<Peinados> item = new ArrayList<>();//img / nombre
        item.add(new Peinados(R.mipmap.cortedama, ""));
        item.add(new Peinados(R.mipmap.cortedama, ""));
        item.add(new Peinados(R.mipmap.cortedama, ""));
        item.add(new Peinados(R.mipmap.cortedama, ""));
        *//*

        glm = new GridLayoutManager(this, 2);
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(glm);

        adapter = new PresentacionAdapter(items);
        recycler.setAdapter(adapter);



        glm2 = new GridLayoutManager(this, 2);
        recycler2 = (RecyclerView) findViewById(R.id.reciclador2);
        recycler2.setHasFixedSize(true);

        lManager2 = new LinearLayoutManager(this);
        recycler2.setLayoutManager(glm2);

        adapter2 = new PresentacionAdapter(item);
        recycler2.setAdapter(adapter2);


        //adapter = new PresentacionAdapter(item);
    }*/


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;
        int id = item.getItemId();
        Class<?> clase = null;

        if (id == R.id.nav_perfil)
            clase = null;
        else if (id == R.id.nav_info)
            clase = DragNDropTiposActivity.class;
        else if (id == R.id.nav_creditos)
            clase = DragNDrop.class;
        else if (id == R.id.nav_herramientas)
            clase = Video.class;
        if (fragmentTransaction) {
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, fragment).commit();
        }

        if (clase != null) {
            Intent i = new Intent(getBaseContext(), clase);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
