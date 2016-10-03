package intecap.gt.proyecto_belleza2016.prueba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import intecap.gt.proyecto_belleza2016.R;

public class ControlladorCortes {

    public static final List<Cortes> ITEMS = new ArrayList<>();
    public static final Map<String, Cortes> ITEM_MAP = new HashMap<>();

    static {
        agregarItem(new Cortes(generarId(),
                "uno", R.mipmap.cortedama, "" ,"srAp9pzvRoE"));
        agregarItem(new Cortes(generarId(),
                "dos", R.mipmap.cortedama, "" ,"PCiwDjzWaIk"));
        agregarItem(new Cortes(generarId(),
                "tres", R.mipmap.cortedama, "" ,""));
        agregarItem(new Cortes(generarId(),
                "cuatro", R.mipmap.cortedama, "" ,""));
    }

    private static void agregarItem(Cortes item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static String generarId() {
        return UUID.randomUUID().toString();
    }

    public static class Cortes {
        public final String id;
        public final String nombre;
        public final int foto;
        public final String descripcion;
        public final String url;

        public Cortes(String id, String nombre, int foto, String descripcion, String url) {
            this.id = id;
            this.nombre = nombre;
            this.foto = foto;
            this.descripcion = descripcion;
            this.url = url;
        }
    }
}
