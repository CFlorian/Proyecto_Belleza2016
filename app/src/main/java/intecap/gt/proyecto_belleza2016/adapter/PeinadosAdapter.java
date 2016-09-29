package intecap.gt.proyecto_belleza2016.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import intecap.gt.proyecto_belleza2016.R;


public class PeinadosAdapter extends RecyclerView.Adapter<PeinadosAdapter.PeinadosAdapterViewHolder> {
    private List<PresentacionMenu> items;



    public static class PeinadosAdapterViewHolder extends RecyclerView.ViewHolder {
        public ImageView imagenp;
        public TextView nombrep;

        public PeinadosAdapterViewHolder(View v) {
            super(v);
            imagenp = (ImageView) v.findViewById(R.id.ivPeinados);
            nombrep = (TextView) v.findViewById(R.id.tvNombrePeinados);
        }
    }
    public PeinadosAdapter(List<PresentacionMenu> items){
        this.items = items;
    }

    @Override
    public PeinadosAdapter.PeinadosAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.peinados, parent, false);
        return new PeinadosAdapter.PeinadosAdapterViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(PeinadosAdapter.PeinadosAdapterViewHolder holder, int position) {
        holder.imagenp.setImageResource(items.get(position).getImagen());
        holder.nombrep.setText(items.get(position).getNombre());
    }
}
