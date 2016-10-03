package intecap.gt.proyecto_belleza2016.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import intecap.gt.proyecto_belleza2016.R;
import intecap.gt.proyecto_belleza2016.Video;

/**
 * Created by programadormd on 29/09/16.
 */

public class PresentacionAdapter extends RecyclerView.Adapter<PresentacionAdapter.PresentacionAdapterViewHolder> {
    private List<PresentacionMenu> items;
    private Context context;

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

    public class PresentacionAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imagen;
        public TextView nombre;
        public int position;

        public PresentacionAdapterViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            imagen = (ImageView) v.findViewById(R.id.ivCortes);
            nombre = (TextView) v.findViewById(R.id.tvNombreCortes);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),  "Categoria = " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
            /*
            PresentacionMenu menu = items.get(position);
            Intent intent = new Intent(context, Video.class);
            intent.putExtra(Video.ACTIVITY_SERVICE, menu.getImagen());
            context.startActivity(intent);*/
        }
    }
}
