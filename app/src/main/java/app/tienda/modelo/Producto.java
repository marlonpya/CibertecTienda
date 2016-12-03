package app.tienda.modelo;

/**
 * Created by marlonpya on 30/11/16.
 */

public class Producto {
    public static final int SOMBRERO    = 0;
    public static final int BLUSA       = 1;
    public static final int CORREA      = 2;
    public static final int FALDA       = 3;
    public static final int PANTALON    = 4;
    public static final int ZATAPATOS   = 5;
    public static final int ACCESORIOS  = 6;

    private int id;
    private String nombre;
    private int imagen;
    private int tipo;
    private double precio;

    public Producto(int id, String nombre, int imagen, int tipo, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.tipo = tipo;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
