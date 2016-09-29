package intecap.gt.proyecto_belleza2016.view;

import android.content.ClipData;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import intecap.gt.proyecto_belleza2016.R;

public class DragNDropTiposActivity extends AppCompatActivity {

    private TextView descripcion, respuesta1, respuesta2;
    private ImageView imagen;
    String texto,respuesta,op1, op2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_ndrop_tipos);
        texto = "Arrastre el nombre correcto para el siguiente peinado";
        respuesta = "Peinado con Trenza";
        op1 = "Peinado con Trenza";
        op2 = "Corte con capas";
        iniciaVars();
    }

    private void iniciaVars() {
        descripcion = (TextView) findViewById(R.id.tvDescrip);
        descripcion.setText(texto);
        imagen = (ImageView) findViewById(R.id.ivImagen);
        imagen.setImageResource(R.mipmap.p1);
        respuesta1 = (TextView) findViewById(R.id.tvRes1);
        respuesta1.setText(op1);
        respuesta2 = (TextView) findViewById(R.id.tvRes2);
        respuesta2.setText(op2);
        findViewById(R.id.tvRes1).setOnLongClickListener(longListener);
        findViewById(R.id.tvRes2).setOnLongClickListener(longListener);
        findViewById(R.id.tvTarget).setOnDragListener(dropListener);
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
                        Toast.makeText(getApplicationContext(),"Correcto",Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(getApplicationContext(),"Incorrecto Intentalo nuevamente",Toast.LENGTH_SHORT).show();
                    }
                    break;
            }

            return true;
        }
    };
}
