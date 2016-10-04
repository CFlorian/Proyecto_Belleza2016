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
    public static final int Cortedama = R.string.corte_dama;
    public static final int Cortecaballero = R.string.corte_caballero;
    public static final int Corteniño = R.string.corte_niño;
    public static final int Corteniña = R.string.corte_niña;

    static {
        agregarItem(new Cortes(generarId(),
                "Damas", R.drawable.cortedama, Cortedama ,"QC0zzrDt4uE",1));
        agregarItem(new Cortes(generarId(),
                "Caballeros", R.drawable.caballero,Cortecaballero,"PCiwDjzWaIk",2));
        agregarItem(new Cortes(generarId(),
                "Niñas", R.drawable.nina, Corteniña,"oBJ2LpQ9rwY",3));
        agregarItem(new Cortes(generarId(),
                "Niños", R.drawable.peinado_ninos, Corteniño,"vY9Jud39XwU",4));
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
        public final int descripcion;
        public final String url;
        public int id2;

        public Cortes(String id, String nombre, int foto, int descripcion, String url, int id2) {
            this.id = id;
            this.nombre = nombre;
            this.foto = foto;
            this.descripcion = descripcion;
            this.url = url;
            this.id2 = id2;

        }

        public String getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public int getFoto() {
            return foto;
        }

        public int getDescripcion() {
            return descripcion;
        }

        public String getUrl() {
            return url;
        }

        public int getId2(){ return id2;}
    }
}
