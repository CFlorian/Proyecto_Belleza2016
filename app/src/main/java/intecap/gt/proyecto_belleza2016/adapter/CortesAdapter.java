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
 * Created by Roberto on 29/09/2016.
 */

public class CortesAdapter extends RecyclerView.Adapter<CortesAdapter.CortesAdapterViewHolder>{
    private List<PresentacionMenu> items;



    public static class CortesAdapterViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagen;
        public TextView nombre;

        public CortesAdapterViewHolder(View itemView) {
            super(itemView);
            imagen = (ImageView) itemView.findViewById(R.id.ivCortes);
            nombre = (TextView) itemView.findViewById(R.id.tvNombreCortes);
        }


    }
    public CortesAdapter(List<PresentacionMenu> items){
        this.items = items;
    }


    @Override
    public CortesAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.seccion_cortes, parent, false);
        return new CortesAdapterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CortesAdapterViewHolder holder, int position) {
        holder.imagen.setImageResource(items.get(position).getImagen());
        holder.nombre.setText(items.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
