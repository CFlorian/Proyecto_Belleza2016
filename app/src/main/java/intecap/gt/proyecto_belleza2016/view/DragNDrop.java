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
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import intecap.gt.proyecto_belleza2016.R;
import intecap.gt.proyecto_belleza2016.utilidades.Parametros;

public class DragNDrop extends AppCompatActivity {

    private TextView descripcion, respuesta1, respuesta2;
    private int count = 0;
    private ImageView imagen;
    private String[][] TEXTOS = {
            {"Arrastre el nombre correcto para el siguiente peinado",
            "Peinado con Trenza",
            "Peinado con Trenza",
            "Corte con capas"},
            {"Arrastre el nombre correcto para el siguiente peinado",
                    "Peinado ondulado",
                    "Peinado ondulado",
                    "Peinado estilo hombre"}
    };

    private SharedPreferences sp;

    private int IMGS[] = {R.mipmap.p1, R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_ndrop_tipos);
        onInit();
    }



    private void onInit() {
        descripcion = (TextView) findViewById(R.id.tvDescrip);
        imagen = (ImageView) findViewById(R.id.ivImagen);
        respuesta1 = (TextView) findViewById(R.id.tvRes1);
        respuesta2 = (TextView) findViewById(R.id.tvRes2);

        descripcion.setText(TEXTOS[count][0]);
        imagen.setImageResource(IMGS[count]);
        respuesta1.setText(TEXTOS[count][2]);
        respuesta2.setText(TEXTOS[count][3]);
        recuperaPreferencias();

        findViewById(R.id.tvRes1).setOnLongClickListener(longListener);
        findViewById(R.id.tvRes2).setOnLongClickListener(longListener);
        findViewById(R.id.tvTarget).setOnDragListener(dropListener);
    }

    private void recuperaPreferencias(){
        try{

           sp = getSharedPreferences(Parametros.VALOR, Context.MODE_PRIVATE);
            int tema = sp.getInt(Parametros.VALOR, 1);

        }catch (Exception e){
            System.err.println(e.getMessage());
            System.err.println("Se genero un problema al querer cargar el dato correspondiente al parecer no se encuentra.");
        }
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
            int alto = (int) v.getHeight() / 2;
            int ancho = (int) v.getWidth() / 2;

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

    private void setActionDrop(View v, DragEvent event){
        Log.i("DRAG_EVENT", "libero");
        TextView target = (TextView) v;
        TextView dragged = (TextView) event.getLocalState();
        target.setText(dragged.getText());
        String Test = String.valueOf(target.getText());

        if (Test.equals(TEXTOS[count][1])){
            Log.i("DRAG_TEST", "CORRECTO");
            Toast.makeText(getApplicationContext(),"Correcto",Toast.LENGTH_SHORT).show();
        }else
            Toast.makeText(getApplicationContext(),"Incorrecto Intentalo nuevamente",Toast.LENGTH_SHORT).show();
        System.out.println(count);
        System.err.println(getAction(Test));

        if((count + 1) < IMGS.length){
            count ++;
            onInit();
        }else{
            Intent i = new Intent(getBaseContext(), DragNDropTiposActivity.class);
            startActivity(i);
        }

    }

    private double getAction(String test){
        final String RESPUESTAS[] ={TEXTOS[0][2], TEXTOS[1][3]};
        System.err.println(RESPUESTAS[count]);
        if(test.contentEquals(RESPUESTAS[count]))
            return 1;
        else
            return 0;
    }

    /**
     * ----------------------------------------------------
     */

    private ArrayList getBundle(){
        Bundle b = null;
        Intent i = null;
        return null;
    }
    /**
     * ---------------------------------------------------
     */

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
