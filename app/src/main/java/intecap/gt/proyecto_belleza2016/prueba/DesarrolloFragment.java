package intecap.gt.proyecto_belleza2016.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import intecap.gt.proyecto_belleza2016.R;
import intecap.gt.proyecto_belleza2016.utilidades.Alert;
import intecap.gt.proyecto_belleza2016.utilidades.OnAction;
import intecap.gt.proyecto_belleza2016.view.DragNDrop;

public class DesarrolloFragment extends Fragment {

    public static final String ARG_ITEM_ID = "item_id";
    private ControlladorCortes.Cortes mItem;

    public DesarrolloFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = ControlladorCortes.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.detalles_items, container, false);

        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.tvDescripcion)).setText(mItem.getDescripcion());
        }

        onInit(rootView);
        return rootView;
    }

    private void onInit(View rootView) {
        FloatingActionButton fabAuto = (FloatingActionButton) rootView.findViewById(R.id.btnAuto);
        fabAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent i = new Intent(getActivity().getBaseContext(), DragNDrop.class);
               startActivity(i);

            }
        });
    }
}
