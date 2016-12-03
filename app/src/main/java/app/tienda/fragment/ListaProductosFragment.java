package app.tienda.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import app.tienda.R;
import app.tienda.adapter.ProductoAdapter;
import app.tienda.modelo.Producto;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaProductosFragment extends Fragment {

    private ProductoAdapter adapter;
    private ArrayList<Producto> productos;
    private ListView lvProductos;

    public ListaProductosFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_productos, container, false);

        lvProductos = (ListView) view.findViewById(R.id.lvProductos);

        productos = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            productos.add(new Producto(0, "Cartera ASDAF", R.drawable.cartera, Producto.ACCESORIOS, 20.00));
        }
        adapter = new ProductoAdapter(getActivity(), productos);
        lvProductos.setAdapter(adapter);
        lvProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return view;
    }

}
