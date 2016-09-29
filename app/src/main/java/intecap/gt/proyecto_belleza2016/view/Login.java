package intecap.gt.proyecto_belleza2016.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.internal.NavigationMenu;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import intecap.gt.proyecto_belleza2016.Navigation_menu;
import intecap.gt.proyecto_belleza2016.R;

public class Login extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private static final int TEXT_ID = 0;
    private EditText etUsuario, etContraseña;
    private TextView tvDatosOlvidados;
    private Button bLogin;
    private String sUsuario1, sUsuario2, sContraseña1, sContraseña2, sDpi, sDpiSharedPreferences;
    private Boolean bUsuario, bContraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        sUsuario1 = sp.getString("Usuario", null);
        sContraseña1 = sp.getString("Contraseña", null);
        sDpiSharedPreferences = sp.getString("DPI", null);

        iniciaVars();
    }

    private void iniciaVars() {

        bUsuario = bContraseña = false;
        etUsuario = (EditText) findViewById(R.id.etLoginUsuario);
        etContraseña = (EditText) findViewById(R.id.etLoginContraseña);
        bLogin = (Button) findViewById(R.id.bLogin);
        tvDatosOlvidados = (TextView) findViewById(R.id.tvLoginDatosOlvidados);

        bLogin.setOnClickListener(this);
        etUsuario.setOnTouchListener(this);
        etContraseña.setOnTouchListener(this);
        tvDatosOlvidados.setOnTouchListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.bLogin:

                sUsuario2 = etUsuario.getText().toString().trim();
                sContraseña2 = etContraseña.getText().toString().trim();

                if(sUsuario2.matches("") || sContraseña2.matches("")){

                    Toast.makeText(Login.this, "Rellene todos los campos", Toast.LENGTH_LONG).show();
                }else {

                    if(sUsuario2.contentEquals(sUsuario1) && sContraseña2.contentEquals(sContraseña1)){

                        Intent menu = new Intent(Login.this, Navigation_menu.class);
                        startActivity(menu);

                    }else{

                        if(!sUsuario2.contentEquals(sUsuario1)){
                            bUsuario = true;
                            etUsuario.setBackgroundColor(Color.RED);
                        }
                        if(!sContraseña2.contentEquals(sContraseña1)){
                            bContraseña = true;
                            etContraseña.setBackgroundColor(Color.RED);
                        }
                        Toast.makeText(Login.this, R.string.datos_incorrectos_ingrese_de_nuevo, Toast.LENGTH_LONG).show();
                    }
                }
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (v.getId()){

            case R.id.etLoginUsuario:

                if(bUsuario) {
                    etUsuario.setBackgroundColor(R.color.colorTrasparent);
                    bUsuario = false;
                }
                break;

            case R.id.etLoginContraseña:
                if(bContraseña) {
                    etContraseña.setBackgroundColor(R.color.colorTrasparent);
                    bContraseña = false;
                }
                break;

            case R.id.tvLoginDatosOlvidados:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Datos olvidados");
                builder.setMessage("Ingresa tu DPI (sin espacios ni guiones):");

                final EditText inputDpi = new EditText(this);
                inputDpi.setId(TEXT_ID);
                builder.setView(inputDpi);

                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int whichButton) {
                        sDpi = inputDpi.getText().toString().trim();

                        if(sDpiSharedPreferences.matches(sDpi)){

                            AlertDialog.Builder builder2 = new AlertDialog.Builder(Login.this);
                            builder2.setTitle("Datos de usuario:").
                                    setMessage("Nombre de usuario: \n" + sUsuario1 + "\n" + "Contraseña: \n" + sContraseña1).setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    }).show();

                        }else{
                            AlertDialog.Builder builder2 = new AlertDialog.Builder(Login.this);
                            builder2.setTitle("Error").
                                    setMessage("DPI no registrado en la base de datos.").setPositiveButton("OK",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {

                                        }
                                    }).show();
                        }
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
                break;
        }
        return false;
    }
}