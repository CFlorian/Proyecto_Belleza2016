package intecap.gt.proyecto_belleza2016.adapter;

/**
 * Created by programadormd on 29/09/16.
 */

public class PresentacionMenu {
    private int imagen;
    private String nombre;

    public PresentacionMenu(int imagen, String nombre){
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }
}
