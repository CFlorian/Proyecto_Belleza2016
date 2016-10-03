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
                "Damas", R.drawable.cortedama, "Primero debemos reunir los materiales adecuados: 1 Consigue un " +
                "buen par de tijeras de peluquero. Si decides cortarte el cabello por tu cuenta, debes buscar tijeras de buena " +
                "calidad especialmente diseñadas para cortar cabello. Puedes encontrarlas en línea o en las tiendas de suministros " +
                "para salones de belleza. Usar tijeras de buena calidad hará que sea más fácil cortarte el cabello en casa.Debes" +
                " buscar tijeras de peluquero que tengan una cuchilla de acero inoxidable y una cuchilla afilada. No utilices " +
                "tijeras de cocina, tijeras para uso doméstico o tijeras de jardinería, ya que podrían arrancarte o dañarte el " +
                "cabello." +
                "2 Compra una maquinilla para cortar cabello y una rasuradora para cabello. Puedes encontrarlas en línea o en una " +
                "tienda de suministros para salones de belleza. Consigue maquinillas eléctricas de buena calidad, ya que vas a usar " +
                "estas herramientas para hacer el corte bob.Una rasuradora para cabello también será útil para hacer este corte, ya " +
                "que te permitirá dar forma y recortar el cabello sin tener que hacer ningún corte mayor. Asegúrate de que la " +
                "rasuradora esté afilada, puesto que una cuchilla sin filo hará que sea más difícil de usar." +
                "3 Consigue un peine y bandas elásticas para cabello. También necesitarás un peine y tres bandas elásticas. Puedes " +
                "encontrar estos productos en línea o en el pasillo de artículos de belleza de cualquier farmacia local. El peine " +
                "te ayudará a separar el cabello en secciones iguales para hacer el corte. Las bandas mantendrán las secciones de " +
                "cabello separadas mientras cortas." ,"QC0zzrDt4uE"));
        agregarItem(new Cortes(generarId(),
                "Caballeros", R.drawable.caballero,  "Primero debemos reunir los materiales adecuados: 1 Consigue un " +
                "buen par de tijeras de peluquero. Si decides cortarte el cabello por tu cuenta, debes buscar tijeras de buena " +
                "calidad especialmente diseñadas para cortar cabello. Puedes encontrarlas en línea o en las tiendas de suministros " +
                "para salones de belleza. Usar tijeras de buena calidad hará que sea más fácil cortarte el cabello en casa.Debes" +
                " buscar tijeras de peluquero que tengan una cuchilla de acero inoxidable y una cuchilla afilada. No utilices " +
                "tijeras de cocina, tijeras para uso doméstico o tijeras de jardinería, ya que podrían arrancarte o dañarte el " +
                "cabello." +
                "2 Compra una maquinilla para cortar cabello y una rasuradora para cabello. Puedes encontrarlas en línea o en una " +
                "tienda de suministros para salones de belleza. Consigue maquinillas eléctricas de buena calidad, ya que vas a usar " +
                "estas herramientas para hacer el corte bob.Una rasuradora para cabello también será útil para hacer este corte, ya " +
                "que te permitirá dar forma y recortar el cabello sin tener que hacer ningún corte mayor. Asegúrate de que la " +
                "rasuradora esté afilada, puesto que una cuchilla sin filo hará que sea más difícil de usar." +
                "3 Consigue un peine y bandas elásticas para cabello. También necesitarás un peine y tres bandas elásticas. Puedes " +
                "encontrar estos productos en línea o en el pasillo de artículos de belleza de cualquier farmacia local. El peine " +
                "te ayudará a separar el cabello en secciones iguales para hacer el corte. Las bandas mantendrán las secciones de " +
                "cabello separadas mientras cortas."  ,"AV0RqHz1cac" +
                ""));
        agregarItem(new Cortes(generarId(),
                "Niñas", R.drawable.nina, "Primero debemos reunir los materiales adecuados: 1 Consigue un " +
                "buen par de tijeras de peluquero. Si decides cortarte el cabello por tu cuenta, debes buscar tijeras de buena " +
                "calidad especialmente diseñadas para cortar cabello. Puedes encontrarlas en línea o en las tiendas de suministros " +
                "para salones de belleza. Usar tijeras de buena calidad hará que sea más fácil cortarte el cabello en casa.Debes" +
                " buscar tijeras de peluquero que tengan una cuchilla de acero inoxidable y una cuchilla afilada. No utilices " +
                "tijeras de cocina, tijeras para uso doméstico o tijeras de jardinería, ya que podrían arrancarte o dañarte el " +
                "cabello." +
                "2 Compra una maquinilla para cortar cabello y una rasuradora para cabello. Puedes encontrarlas en línea o en una " +
                "tienda de suministros para salones de belleza. Consigue maquinillas eléctricas de buena calidad, ya que vas a usar " +
                "estas herramientas para hacer el corte bob.Una rasuradora para cabello también será útil para hacer este corte, ya " +
                "que te permitirá dar forma y recortar el cabello sin tener que hacer ningún corte mayor. Asegúrate de que la " +
                "rasuradora esté afilada, puesto que una cuchilla sin filo hará que sea más difícil de usar." +
                "3 Consigue un peine y bandas elásticas para cabello. También necesitarás un peine y tres bandas elásticas. Puedes " +
                "encontrar estos productos en línea o en el pasillo de artículos de belleza de cualquier farmacia local. El peine " +
                "te ayudará a separar el cabello en secciones iguales para hacer el corte. Las bandas mantendrán las secciones de " +
                "cabello separadas mientras cortas."  ,"5coJa7lrRQw"));
        agregarItem(new Cortes(generarId(),
                "Niños", R.drawable.peinado_ninos, "Primero debemos reunir los materiales adecuados: 1 Consigue un " +
                "buen par de tijeras de peluquero. Si decides cortarte el cabello por tu cuenta, debes buscar tijeras de buena " +
                "calidad especialmente diseñadas para cortar cabello. Puedes encontrarlas en línea o en las tiendas de suministros " +
                "para salones de belleza. Usar tijeras de buena calidad hará que sea más fácil cortarte el cabello en casa.Debes" +
                " buscar tijeras de peluquero que tengan una cuchilla de acero inoxidable y una cuchilla afilada. No utilices " +
                "tijeras de cocina, tijeras para uso doméstico o tijeras de jardinería, ya que podrían arrancarte o dañarte el " +
                "cabello." +
                "2 Compra una maquinilla para cortar cabello y una rasuradora para cabello. Puedes encontrarlas en línea o en una " +
                "tienda de suministros para salones de belleza. Consigue maquinillas eléctricas de buena calidad, ya que vas a usar " +
                "estas herramientas para hacer el corte bob.Una rasuradora para cabello también será útil para hacer este corte, ya " +
                "que te permitirá dar forma y recortar el cabello sin tener que hacer ningún corte mayor. Asegúrate de que la " +
                "rasuradora esté afilada, puesto que una cuchilla sin filo hará que sea más difícil de usar." +
                "3 Consigue un peine y bandas elásticas para cabello. También necesitarás un peine y tres bandas elásticas. Puedes " +
                "encontrar estos productos en línea o en el pasillo de artículos de belleza de cualquier farmacia local. El peine " +
                "te ayudará a separar el cabello en secciones iguales para hacer el corte. Las bandas mantendrán las secciones de " +
                "cabello separadas mientras cortas."  ,"5coJa7lrRQw"));
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

        public String getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public int getFoto() {
            return foto;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public String getUrl() {
            return url;
        }
    }
}
