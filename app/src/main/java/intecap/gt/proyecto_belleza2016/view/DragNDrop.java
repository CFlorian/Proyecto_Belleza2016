package intecap.gt.proyecto_belleza2016.view;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import intecap.gt.proyecto_belleza2016.R;
import intecap.gt.proyecto_belleza2016.utilidades.Alert;
import intecap.gt.proyecto_belleza2016.utilidades.OnAction;
import intecap.gt.proyecto_belleza2016.utilidades.Parametros;

public class DragNDrop extends AppCompatActivity {

    private TextView descripcion, respuesta1, respuesta2;
    private int count = 0;
    private ImageView imagen;
    private SharedPreferences sp;

   private  String textos[] = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_ndrop_tipos);
        alerta();
        tiempoEspera();
        onInit();
    }

    private void alerta(){
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

    private void onInit() {

        descripcion = (TextView) findViewById(R.id.tvDescrip);
        imagen = (ImageView) findViewById(R.id.ivImagen);
        respuesta1 = (TextView) findViewById(R.id.tvRes1);
        respuesta2 = (TextView) findViewById(R.id.tvRes2);

        textos = recuperaTexto();
        descripcion.setText(textos[0]);
        //descripcion.setText(TEXTO[]);
        int tema = recuperaPreferencias();
        System.err.println(tema + "  Tema recuperado");
        imagen.setImageResource(Parametros.Const.IMAGENES[tema]);
        respuesta1.setText(textos[1]);
        respuesta2.setText(textos[2]);

        findViewById(R.id.tvRes1).setOnLongClickListener(longListener);
        findViewById(R.id.tvRes2).setOnLongClickListener(longListener);
        findViewById(R.id.tvTarget).setOnDragListener(dropListener);

    }

    private String[] recuperaTexto(){
        String cadena = "";
        Resources r = getResources();
        String[] cadenas = r.getStringArray(Parametros.Const.TEST1[count]);
        for (int i = 0;  i < cadenas.length; i ++){
            cadena +=  cadenas[i] + "-";
        }
        return cadena.split("-");
    }

    private int recuperaPreferencias(){
        int tema = 0;
        try{
           sp = getSharedPreferences(Parametros.VALOR, Context.MODE_PRIVATE);
             tema = sp.getInt(Parametros.VALOR, 1);

        }catch (Exception e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return tema;
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

    private void tiempoEspera(){
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.err.println("finish()");
                    Intent i = new Intent(getBaseContext(), Splash.class);
                    startActivity(i);
                    finish();
                } catch (InterruptedException e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }finally {

                }
            }
        });
    }

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
            int alto = (int) v.getHeight() ;
            int ancho = (int) v.getWidth() ;

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
                case DragEvent.ACTION_DROP:
                    setActionDrop(v, event);
                    break;
            }
            return true;
        }
    };

    private double valor = 0;

    private void setActionDrop(View v, DragEvent event){
        TextView target = (TextView) v;
        TextView dragged = (TextView) event.getLocalState();
        target.setText(dragged.getText());
        String Test = String.valueOf(target.getText());
        System.err.println(valor);
        boolean correctos =
                (count == 0 && Test.contentEquals(textos[2]) ||
                        count == 1 && Test.contentEquals(textos[2]) ||
                count == 2 && Test.contentEquals(textos[1]) ||
                count == 3 && Test.contentEquals(textos[1]));

        boolean falsos = (count == 0 && Test.contentEquals(textos[1]) ||
                count == 1 && Test.contentEquals(textos[1]) ||
                count == 2 && Test.contentEquals(textos[2]) ||
                count == 3 && Test.contentEquals(textos[2]));

        if (correctos){
            Log.i("DRAG_TEST", "CORRECTO");
            Toast.makeText(getApplicationContext(),"Correcto",Toast.LENGTH_SHORT).show();
            valor += getAction(true);
        }else if (falsos) {
            Toast.makeText(getApplicationContext(), "Incorrecto Intentalo nuevamente", Toast.LENGTH_SHORT).show();
            valor += getAction(false);

        }

        System.out.println(valor);
        if((count + 1) < Parametros.Const.TOTAL_TEST){
            count ++;
            onInit();
        }else{
            alerta(valor);
        }
    }
    private boolean terminado = false;

    private void alerta(double valor){
         AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        String title = "", cuerpo = "Has optenido un punteo de " + valor, boton = "Aceptar";
        if(valor > 51)
            title = "Felicitaciones!!!";
        else
            title = "Sigue intentando";
        dialog.setMessage(cuerpo).
                setTitle(title).
                setCancelable(false).
                setNeutralButton(boton, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(getBaseContext(), DragNDropTiposActivity.class);
                        startActivity(i);
                        //finish();
                        terminado = true;
                    }
                });
        AlertDialog alert = dialog.create();
        dialog.show();
    }

    private double getAction(boolean respuesta){
        if(respuesta == true){
            return 25;
        }else
            return 0;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(terminado){
            finish();
        }
    }
}
