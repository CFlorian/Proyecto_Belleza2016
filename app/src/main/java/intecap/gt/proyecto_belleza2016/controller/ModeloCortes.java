package intecap.gt.proyecto_belleza2016.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Roberto on 29/09/2016.
 */

public class ModeloCortes {

    public static final List<Cortes> ITEMS = new ArrayList<>();
    public static final Map<String, Cortes> ITEM_MAP = new HashMap<>();

    static {
        agregarItem(new Cortes(generarId(),
                "uno", android.R.drawable.picture_frame, "", ""));
        agregarItem(new Cortes(generarId(),
                "dos", android.R.drawable.picture_frame, "", ""));
        agregarItem(new Cortes(generarId(),
                "tres", android.R.drawable.picture_frame, "", ""));
        agregarItem(new Cortes(generarId(),
                "cuatro", android.R.drawable.picture_frame, "", ""));
    }

    private static void agregarItem(Cortes item){
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static String generarId(){
        return UUID.randomUUID().toString();
    }

    private static class Cortes {
        public final String id;
        public final String nombre;
        public final int imagen;
        public final String url;
        public final String descripcion;

        public Cortes(String id, String nombre, int imagen, String url, String descripcion) {
            this.id = id;
            this.nombre = nombre;
            this.imagen = imagen;
            this.url = url;
            this.descripcion = descripcion;
        }
    }
}
