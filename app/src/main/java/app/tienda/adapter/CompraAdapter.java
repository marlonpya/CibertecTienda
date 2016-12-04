package app.tienda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import app.tienda.R;
import app.tienda.modelo.Producto;

/**
 * Created by marlonpya on 30/11/16.
 */

public class CompraAdapter extends BaseAdapter {
    private ArrayList<Producto> productos;
    private LayoutInflater inflater;

    public CompraAdapter(Context context, ArrayList<Producto> productos) {
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
        view = inflater.inflate(R.layout.item_compraadapter, viewGroup, false);
        return view;
    }
}
