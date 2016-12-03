package app.tienda.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by marlonpya on 30/11/16.
 */

public class Compra {

    private int id;
    private Date fecha;
    private ArrayList<Producto> productos;

    public Compra(int id, Date fecha, ArrayList<Producto> productos) {
        this.id = id;
        this.fecha = fecha;
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }
}
