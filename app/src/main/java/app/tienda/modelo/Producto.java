package app.tienda.modelo;

/**
 * Created by marlonpya on 30/11/16.
 */

public class Producto {

    private static final int NO_COMPRADO = 0;
    private static final int COMPRADO    = 1;

    private int id;
    private String nombre;
    private int imagen;
    private double precio;
    private int comprado;

    public Producto(int id, String nombre, int imagen, double precio, int comprado) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
        this.comprado = comprado;
    }

    public Producto(String nombre, int imagen, double precio) {
        this.nombre = nombre;
        this.imagen = imagen;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getComprado() {
        return comprado;
    }

    public void setComprado(int comprado) {
        this.comprado = comprado;
    }
}
