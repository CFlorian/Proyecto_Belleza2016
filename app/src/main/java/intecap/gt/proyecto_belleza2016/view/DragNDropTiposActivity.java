package intecap.gt.proyecto_belleza2016.view;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import intecap.gt.proyecto_belleza2016.Navigation_menu;
import intecap.gt.proyecto_belleza2016.R;
import intecap.gt.proyecto_belleza2016.utilidades.Alert;
import intecap.gt.proyecto_belleza2016.utilidades.OnAction;
import intecap.gt.proyecto_belleza2016.utilidades.Parametros;

public class DragNDropTiposActivity extends AppCompatActivity {

    private TextView descripcion, respuesta1, respuesta2;
    private ImageView imagen;
    String texto,respuesta,op1, op2;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_ndrop_tipos);
        mensaje();
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        initText();
    }

    private void mensaje(){
        String cuerpo = "En el siguiente test manten y arrastra la respuesta hacia la imagen.";
        Alert.alert(this, "Test de tipos de material", cuerpo, new OnAction() {
            @Override
            public void onAction() {
                printTraceStace();
            }

            private void printTraceStace(){
                System.err.println("NULL REFERENCE OBJTEC EXCEPTION");
            }
        });
    }

    private void initText(){
        sp = getSharedPreferences(Parametros.VALOR, Context.MODE_PRIVATE);
        final int posicion = sp.getInt(Parametros.VALOR,1);

        if (posicion == 1 || posicion == 3){
            texto = "Mantenga presionado y arrastre el nombre correcto para el siguiente peinado";
            respuesta = "Peinado con Trenza";
            op1 = "Peinado con Trenza";
            op2 = "Peinado pelo suelto";
            imagen = (ImageView) findViewById(R.id.ivImagen);
            imagen.setImageResource(R.mipmap.peinado_damas);
            iniciaVars();
        }else if (posicion == 2 || posicion == 4){
            texto = "Mantenga y arrastre el nombre correcto para el siguiente peinado";
            respuesta = "Peinado degrafilado";
            op1 = "Peinado estilo hongo";
            op2 = "Peinado degrafilado";
            imagen = (ImageView) findViewById(R.id.ivImagen);
            imagen.setImageResource(R.mipmap.peinado_caballeros);
            iniciaVars();
        }

    }

    private void iniciaVars() {
        descripcion = (TextView) findViewById(R.id.tvDescrip);
        descripcion.setText(texto);
        respuesta1 = (TextView) findViewById(R.id.tvRes1);
        respuesta1.setText(op1);
        respuesta2 = (TextView) findViewById(R.id.tvRes2);
        respuesta2.setText(op2);
        findViewById(R.id.tvRes1).setOnLongClickListener(longListener);
        findViewById(R.id.tvRes2).setOnLongClickListener(longListener);
        findViewById(R.id.tvTarget).setOnDragListener(dropListener);
        recuperaPreferencia();
    }

    private void recuperaPreferencia(){
        SharedPreferences sp = getSharedPreferences(Parametros.VALOR, Context.MODE_PRIVATE);
        int tema = sp.getInt(Parametros.VALOR, 1);
        System.err.println(tema + " CRISTIAN");
    }

    View.OnLongClickListener longListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            DragShadow dragShadow = new DragShadow(v);
            ClipData data = ClipData.newPlainText("", "");
            v.startDrag(data, dragShadow, v, 0);
            return false;
        }
    };

    private class DragShadow extends View.DragShadowBuilder {

        ColorDrawable greyBox;

        public DragShadow(View view) {
            super(view);
            greyBox = new ColorDrawable(Color.LTGRAY);
        }

        @Override
        public void onDrawShadow(Canvas canvas) {
            greyBox.draw(canvas);
        }

        @Override
        public void onProvideShadowMetrics(Point shadowSize, Point shadowTouchPoint) {
            View v = getView();
            int alto = (int) v.getHeight();
            int ancho = (int) v.getWidth();

            greyBox.setBounds(0, 0, ancho, alto);

            shadowSize.set(ancho, alto);
            shadowTouchPoint.set((int) ancho / 2, (int) alto / 2);
        }
    }

    View.OnDragListener dropListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvento = event.getAction();
            switch (dragEvento){
                case DragEvent.ACTION_DRAG_ENTERED:
                    //nada
                    Log.i("DRAG_EVENT", "ingreso");
                    break;
                case DragEvent.ACTION_DRAG_EXITED:
                    //nada
                    Log.i("DRAG_EVENT", "salio");
                    break;
                case DragEvent.ACTION_DROP:
                    Log.i("DRAG_EVENT", "libero");
                    TextView target = (TextView) v;
                    TextView dragged = (TextView) event.getLocalState();
                    target.setText(dragged.getText());
                    String Test = String.valueOf(target.getText());
                    if (Test.equals(respuesta)){
                        Log.i("DRAG_TEST", "CORRECTO");
                        dataCorrecta();
                        //Toast.makeText(getApplicationContext(),"Correcto",Toast.LENGTH_SHORT).show();
                    }else {
                        //imagen.setImageResource(R.mipmap.malo);
                        //showAlertDialog("Resultado", "Respuesta incorrecta", true);
                        //Toast.makeText(getApplicationContext(),"Incorrecto Intentalo nuevamente",Toast.LENGTH_SHORT).show();
                        dataIncorrecta();
                    }
                    break;
            }
            return true;
        }
    };

    private void dataCorrecta() {
        imagen.setImageResource(R.mipmap.bueno);
        showAlertDialog("Respuesta Correcta", "Siga con los siguientes temas ", true);
        Thread hilo = new Thread(){

            @Override
            public void run() {
                try {
                    sleep(Parametros.TIEMPO);
                    Intent intent = new Intent(DragNDropTiposActivity.this,Navigation_menu.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        hilo.start();
    }

    private void dataIncorrecta() {
        imagen.setImageResource(R.mipmap.malo);
        showAlertDialog("Respuesta Incorrecta", "Siga con los siguientes temas ", true);
        Thread hilo = new Thread(){

            @Override
            public void run() {
                try {
                    sleep(Parametros.TIEMPO);
                    Intent intent = new Intent(DragNDropTiposActivity.this,Navigation_menu.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        hilo.start();
    }

    public void showAlertDialog(String title, String message, Boolean status) {
        AlertDialog alertDialog = new AlertDialog.Builder(DragNDropTiposActivity.this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.show();
    }
}
