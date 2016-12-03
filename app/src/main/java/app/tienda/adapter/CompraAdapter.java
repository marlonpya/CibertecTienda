package app.tienda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import app.tienda.R;
import app.tienda.modelo.Compra;

/**
 * Created by marlonpya on 30/11/16.
 */

public class CompraAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Compra> compras;
    private LayoutInflater inflater;

    public CompraAdapter(Context context, ArrayList<Compra> compras) {
        this.context = context;
        this.compras = compras;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return compras.size();
    }

    @Override
    public Object getItem(int i) {
        return compras.get(i);
    }

    @Override
    public long getItemId(int i) {
        return compras.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.item_compraadapter, viewGroup, false);

        return null;
    }
}
