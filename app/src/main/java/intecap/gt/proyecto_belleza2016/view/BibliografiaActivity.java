package intecap.gt.proyecto_belleza2016.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import intecap.gt.proyecto_belleza2016.R;
import intecap.gt.proyecto_belleza2016.utilidades.Parametros;

public class BibliografiaActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tema1, tema2, tema3, tema4;
    private Button btn1, btn2, btn3, btn4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bibliografia);
        Toolbar toolbar = (Toolbar) findViewById(R.id.detail_toolbar);
        setSupportActionBar(toolbar);
        iniciaVars();
    }

    private void iniciaVars() {
        tema1 = (TextView) findViewById(R.id.tvTema1);
        tema2 = (TextView) findViewById(R.id.tvTema2);
        tema3 = (TextView) findViewById(R.id.tvTema3);
        tema4 = (TextView) findViewById(R.id.tvTema4);
        btn1 = (Button) findViewById(R.id.btnOpen1);
        btn2 = (Button) findViewById(R.id.btnOpen2);
        btn3 = (Button) findViewById(R.id.btnOpen3);
        btn4 = (Button) findViewById(R.id.btnOpen4);
        btn1.setText(Parametros.tema1);
        btn2.setText(Parametros.tema2);
        btn3.setText(Parametros.tema3);
        btn4.setText(Parametros.tema4);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnOpen1:
                Intent intent = null;
                intent = new Intent(intent.ACTION_VIEW, Uri.parse(Parametros.tema1));
                startActivity(intent);
                break;
            case R.id.btnOpen2:
                Intent intent2 = null;
                intent2 = new Intent(intent2.ACTION_VIEW, Uri.parse(Parametros.tema2));
                startActivity(intent2);
                break;
            case R.id.btnOpen3:
                Intent intent3 = null;
                intent3 = new Intent(intent3.ACTION_VIEW, Uri.parse(Parametros.tema3));
                startActivity(intent3);
                break;
            case R.id.btnOpen4:
                Intent intent4 = null;
                intent4 = new Intent(intent4.ACTION_VIEW, Uri.parse(Parametros.tema4));
                startActivity(intent4);
                break;
        }
    }
}
