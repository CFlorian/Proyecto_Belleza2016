package intecap.gt.proyecto_belleza2016;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Roberto on 29/09/2016.
 */

public class AdapterCortes extends BaseAdapter {

    protected Activity activity;
    protected ArrayList<SeccionCortes> cortes;

    public AdapterCortes (Activity activity, ArrayList<SeccionCortes> cortes){
        this.activity = activity;
        this.cortes = cortes;
    }
    @Override
    public int getCount() {
        return cortes.size();
    }

    public void clear(){
        cortes.clear();
    }
    public void addAll(ArrayList<SeccionCortes> seccionCortes){
        for (int i = 0; i < seccionCortes.size(); i++){
            cortes.add(seccionCortes.get(i));
        }
    }

    @Override
    public Object getItem(int i) {
        return cortes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = viewGroup;
        if (viewGroup == null){
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inflater.inflate(R.layout.seccion_cortes, null);
        }
        SeccionCortes dir = cortes.get(i);

        TextView titulo = (TextView) v.findViewById(R.id.tvNombreCortes);
        titulo.setText(dir.getTitulo());

        TextView descripcion = (TextView) v.findViewById(R.id.cvCortes);
        descripcion.setText(dir.getDescripcion());

        ImageView imageView = (ImageView) v.findViewById(R.id.ivCortes);
        imageView.setImageDrawable(dir.getImagen());

        return v;
    }
}
