package app.tienda.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import app.tienda.R;
import app.tienda.adapter.CompraAdapter;
import app.tienda.adapter.ProductoAdapter;
import app.tienda.app.MiAplication;
import app.tienda.modelo.Producto;

/**
 * A simple {@link Fragment} subclass.
 */
public class CompraFragment extends Fragment {

    private ListView listView;
    private ArrayList<Producto> mis_compras;
    private ProductoAdapter adapter;

    public CompraFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_compra, container, false);

        listView = (ListView) view.findViewById(R.id.lvMisCompras);

        mis_compras = MiAplication.sqlite.getMisCompras();

        adapter = new ProductoAdapter(getActivity(), mis_compras);

        for (Producto item : mis_compras) {
            Log.d("CompraFragment", String.valueOf(item.getId())+item.getNombre()+String.valueOf(item.getImagen())+String.valueOf(item.getPrecio())+String.valueOf(item.getPrecio()));
        }
        listView.setAdapter(adapter);

        return view;
    }
}
