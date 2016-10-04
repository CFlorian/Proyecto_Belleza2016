package intecap.gt.proyecto_belleza2016.view;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Window;

import intecap.gt.proyecto_belleza2016.Navigation_menu;
import intecap.gt.proyecto_belleza2016.R;


public class Splash extends Activity{
    private static final long TIEMPO = 3000;
    private String  registrado;

    @Override
    protected void onCreate(Bundle bd) {
        super.onCreate(bd);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        registrado = sp.getString("Registrado", null);



        Thread splash = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(TIEMPO);

                } catch (InterruptedException e) {
                    e.getMessage();

                } finally {

                    if(registrado == null){
                        Intent registro= new Intent(Splash.this, Registro.class);
                        startActivity(registro);

                    }else {
                        Intent login = new Intent(Splash.this, Navigation_menu.class);
                        startActivity(login);
                    }

                }
            }
        };
        splash.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}