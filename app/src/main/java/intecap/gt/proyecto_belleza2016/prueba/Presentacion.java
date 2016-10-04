package intecap.gt.proyecto_belleza2016.prueba;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import intecap.gt.proyecto_belleza2016.R;
import intecap.gt.proyecto_belleza2016.utilidades.Parametros;


public class Presentacion extends Fragment {
    private boolean mTwoPane;
    private GridLayoutManager gManager;
    private RecyclerView recyclerView;
    private String KEY = "llave";


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_item_list, container, false);

        gManager = new GridLayoutManager(getActivity(), 2);
        recyclerView = (RecyclerView) v.findViewById(R.id.item_list);
        recyclerView.setLayoutManager(gManager);
        assert recyclerView != null;
        setupRecyclerView(recyclerView);
        return v;
    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(ControlladorCortes.ITEMS));
    }

    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private final List<ControlladorCortes.Cortes> mValues;

        public SimpleItemRecyclerViewAdapter(List<ControlladorCortes.Cortes> items) {
            mValues = items;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_content, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, final int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setImageResource(mValues.get(position).getFoto());
            holder.mContentView.setText(mValues.get(position).getNombre());
            Log.i("Prueba","La posicion es " + position);
            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    int pos2 = holder.mItem.getId2();
                    Intent intent = new Intent(context, DesarrolloActivity.class);
                    intent.putExtra(DesarrolloFragment.ARG_ITEM_ID, holder.mItem.id);
                    SharedPreferences sp;
                    sp =  getActivity().getSharedPreferences(Parametros.VALOR, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putInt(Parametros.VALOR,pos2);
                    editor.commit();
                    Log.i("Prueba","La posicion es " + holder.mItem.id);
                    Log.i("Prueba2","La posicion es " + holder.mItem.id2);
                    Log.i("Prueba3","La posicion es " + pos2);
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final ImageView mIdView;
            public final TextView mContentView;
            public ControlladorCortes.Cortes mItem;
            public int Position2;
            public CardView cvPosicion;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (ImageView) view.findViewById(R.id.id);
                mContentView = (TextView) view.findViewById(R.id.content);
                cvPosicion = (CardView) view.findViewById(R.id.cvPosicion);
            }
        }
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }
}
