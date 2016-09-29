package intecap.gt.proyecto_belleza2016;

import android.graphics.drawable.Drawable;

/**
 * Created by Roberto on 29/09/2016.
 */

public class SeccionCortes {
    private String titulo;
    private String corte;
    private String descripcion;
    private Drawable imagen;

    public SeccionCortes(){
        super();
    }

    public SeccionCortes(String titulo, String corte, String descripcion, Drawable imagen){
        super();
        this.titulo = titulo;
        this.corte = corte;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Drawable getImagen() {
        return imagen;
    }

    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }

    public String getCorte() {
        return corte;
    }

    public void setCorte(String corte) {
        this.corte = corte;
    }
}
