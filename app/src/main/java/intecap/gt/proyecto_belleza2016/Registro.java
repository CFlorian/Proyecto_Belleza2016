package intecap.gt.proyecto_belleza2016;


import android.text.Editable;
import android.widget.AdapterView;

public class Registro extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private Spinner años;
    private Button registrar;
    private EditText nombre, apellido, carne, dias, mes, año, dpi1, dpi2, dpi3, usuario, contraseña, contraseña2;
    private String registrado = null;
    private SharedPreferences spToolbar;
    private String sNombre, sApellido, sCarne, sDias, sMes, sAño, sDpi1, sDpi2, sDpi3, sUsuario, sContraseña, sContraseña2, añoCarne, dpi, fechaNacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        spToolbar = getSharedPreferences("Nuevo", Context.MODE_PRIVATE);
        String bToolbar = "Nuevo";
        SharedPreferences.Editor editor = spToolbar.edit();
        editor.putString("compartir_cadena",bToolbar);
        editor.commit();
        iniciaVars();
    }

    private void iniciaVars(){

        ArrayAdapter<String> añosArray= new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item,
                getResources().getStringArray(R.array.años));

        años = (Spinner) findViewById(R.id.spinnerCarne);
        años.setAdapter(añosArray);
        años.setOnItemSelectedListener(this);

        registrar = (Button) findViewById(R.id.bRegistrar);
        registrar.setOnClickListener(this);

        nombre = (EditText) findViewById(R.id.etPrimerNombre);
        apellido = (EditText) findViewById(R.id.etPrimerApellido);
        carne = (EditText) findViewById(R.id.etCarne);
        dias = (EditText) findViewById(R.id.etDia);
        mes = (EditText) findViewById(R.id.etMes);
        año = (EditText) findViewById(R.id.etAño);
        dpi1 = (EditText) findViewById(R.id.etDpi1);
        dpi2 = (EditText) findViewById(R.id.etDpi2);
        dpi3 = (EditText) findViewById(R.id.etDpi3);
        usuario = (EditText) findViewById(R.id.etNombreUsuario);
        contraseña = (EditText) findViewById(R.id.etContraseña);
        contraseña2 = (EditText) findViewById(R.id.etContraseña2);
        dpi1.addTextChangedListener(chance);
        dpi2.addTextChangedListener(chance);
    }

    @Override
    public void onClick(View v) {
        sNombre = nombre.getText().toString().trim();
        sApellido = apellido.getText().toString().trim();
        sCarne = carne.getText().toString().trim();
        sDias = dias.getText().toString().trim();
        sMes = mes.getText().toString().trim();
        sAño = año.getText().toString().trim();
        sDpi1 = dpi1.getText().toString().trim();
        sDpi2 = dpi2.getText().toString().trim();
        sDpi3 = dpi3.getText().toString().trim();
        sUsuario = usuario.getText().toString().trim();
        sContraseña = contraseña.getText().toString().trim();
        sContraseña2 = contraseña2.getText().toString().trim();

        sCarne = añoCarne + "-" + sCarne;
        dpi = ""+ sDpi1 + sDpi2 + sDpi3;
        fechaNacimiento = sDias + "/" + sMes + "/" + sAño;

        if(sNombre.matches("") || sApellido.matches("") || sCarne.matches("") || sDias.matches("") || sMes.matches("") ||
                sAño.matches("") || sDpi1.matches("") || sDpi2.matches("") || sDpi3.matches("") ||
                sUsuario.matches("") || sContraseña.matches("") || sContraseña2.matches("")){

            Toast.makeText(Registro.this, "Debe llenar todos los campos.", Toast.LENGTH_SHORT).show();

        }else{

            if(!sContraseña.contentEquals(sContraseña2)){
                Toast.makeText(Registro.this, "Las contraseñas no coinciden.", Toast.LENGTH_SHORT).show();
            }else{

                if(dpi.length() < 13){
                    Toast.makeText(Registro.this, "DPI invalido, por favor, ingreselo correctamente.", Toast.LENGTH_SHORT).show();
                }else{

                    if(sCarne.length() < 11){
                        Toast.makeText(Registro.this, "Carné invalido, por favor, ingreselo correctamente.", Toast.LENGTH_SHORT).show();

                    }else{
                        final SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(Registro.this);


                        registrado = "OK";
                        sp.edit().putString("Nombre", sNombre).apply();
                        sp.edit().putString("Apellido", sApellido).apply();
                        sp.edit().putString("Carne", sCarne).apply();
                        sp.edit().putString("Nacimiento", fechaNacimiento).apply();
                        sp.edit().putString("DPI", dpi).apply();
                        sp.edit().putString("Usuario", sUsuario).apply();
                        sp.edit().putString("Contraseña", sContraseña).apply();
                        sp.edit().putString("Registrado", registrado).apply();

                        new AlertDialog.Builder(Registro.this).setTitle("Registrado").setMessage("Registrado con exito").setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent menu = new Intent(Registro.this, Presentacion.class);
                                startActivity(menu);
                            }
                        }).show();
                    }
                }
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                añoCarne = "2017";
                break;
            case 1:
                añoCarne = "2016";
                break;
            case 2:
                añoCarne = "2015";
                break;
            case 3:
                añoCarne = "2014";
                break;
            case 4:
                añoCarne = "2013";
                break;
            case 5:
                añoCarne = "2012";
                break;
            case 6:
                añoCarne = "2011";
                break;
            case 7:
                añoCarne = "2010";
                break;
            case 8:
                añoCarne = "2009";
                break;
            case 9:
                añoCarne = "2008";
                break;
            case 10:
                añoCarne = "2007";
                break;
            case 11:
                añoCarne = "2006";
                break;
            case 12:
                añoCarne = "2005";
                break;
            case 13:
                añoCarne = "2004";
                break;
            case 14:
                añoCarne = "2003";
                break;
            case 15:
                añoCarne = "2002";
                break;
            case 16:
                añoCarne = "2001";
                break;
            case 17:
                añoCarne = "2000";
                break;
            case 18:
                añoCarne = "1999";
                break;
            case 19:
                añoCarne = "1998";
                break;
            case 20:
                añoCarne = "1997";
                break;
            case 21:
                añoCarne = "1996";
                break;
            case 22:
                añoCarne = "1995";
                break;
            case 23:
                añoCarne = "1994";
                break;
            case 24:
                añoCarne = "1993";
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {}

    private Chance chance = new Chance(){
        @Override
        public void afterTextChanged(Editable e){
            switch (e.length()){
                case 4: dpi2.requestFocus(); break;
                case 5: dpi3.requestFocus(); break;
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}