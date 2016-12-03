package app.tienda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.tienda.R;
import app.tienda.modelo.Producto;

/**
 * Created by marlonpya on 30/11/16.
 */

public class ProductoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Producto> productos;
    private LayoutInflater inflater;

    public ProductoAdapter (Context context, ArrayList<Producto> productos) {
        this.context = context;
        this.productos = productos;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return productos.size();
    }

    @Override
    public Object getItem(int i) {
        return productos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return productos.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.item_productoadapter, viewGroup, false);

        ImageView ivImagen = (ImageView)view.findViewById(R.id.item_imagen);
        TextView tvNombre = (TextView)view.findViewById(R.id.item_nombre);
        TextView tvPrecio = (TextView)view.findViewById(R.id.item_precio);

        Producto producto = productos.get(i);

        ivImagen.setImageResource(producto.getImagen());
        tvNombre.setText(producto.getNombre());
        tvPrecio.setText(String.valueOf(producto.getPrecio()));

        return view;
    }
}
