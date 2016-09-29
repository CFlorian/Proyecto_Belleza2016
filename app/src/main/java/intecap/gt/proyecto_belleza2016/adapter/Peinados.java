package intecap.gt.proyecto_belleza2016.adapter;

/**
 * Created by programadormd on 29/09/16.
 */

public class Peinados {

    private int imagenp;
    private String nombrep;

    public Peinados(int imagen_peinados, String nombre_peinados){
        this.imagenp = imagen_peinados;
        this.nombrep = nombre_peinados;
    }

    public int getImagenp() {
        return imagenp;
    }

    public String getNombrep() {
        return nombrep;
    }
}
