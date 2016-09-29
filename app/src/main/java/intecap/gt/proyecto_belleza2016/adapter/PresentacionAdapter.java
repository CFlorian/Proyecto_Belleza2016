package intecap.gt.proyecto_belleza2016.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import intecap.gt.proyecto_belleza2016.R;

/**
 * Created by programadormd on 29/09/16.
 */

public class PresentacionAdapter extends RecyclerView.Adapter<PresentacionAdapter.PresentacionAdapterViewHolder> {
    private List<PresentacionMenu> items;



    public static class PresentacionAdapterViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView nombre;

        public PresentacionAdapterViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.ivCortes);
            nombre = (TextView) v.findViewById(R.id.tvNombreCortes);
        }
    }
    public PresentacionAdapter(List<PresentacionMenu> items){
        this.items = items;
    }

    @Override
    public PresentacionAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.seccion_cortes, parent, false);
        return new PresentacionAdapterViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(PresentacionAdapterViewHolder holder, int position) {
        holder.imagen.setImageResource(items.get(position).getImagen());
        holder.nombre.setText(items.get(position).getNombre());
    }
}
