package app.tienda.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import app.tienda.R;
import app.tienda.adapter.ProductoAdapter;
import app.tienda.app.MiAplication;
import app.tienda.modelo.Producto;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaProductosFragment extends Fragment {
    public static final String TAG = ListaProductosFragment.class.getSimpleName();
    private EditText etBuscador;
    private Button btnBuscar;
    private ListView lvProductos;

    private ProductoAdapter adapter;
    private ArrayList<Producto> productos;

    public ListaProductosFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lista_productos, container, false);

        etBuscador = (EditText) view.findViewById(R.id.etBuscador);
        btnBuscar = (Button) view.findViewById(R.id.btnBuscar);
        lvProductos = (ListView) view.findViewById(R.id.lvProductos);

        productos = MiAplication.sqlite.getProductos();

        adapter = new ProductoAdapter(getActivity(), productos);
        lvProductos.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etBuscador.getText().toString().isEmpty()) {
                    productos = MiAplication.sqlite.getProductosNombre(etBuscador.getText().toString());
                    adapter = new ProductoAdapter(getActivity(), productos);
                    lvProductos.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        lvProductos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int pos, long l) {
                Producto item = productos.get(pos);
                Log.d(TAG, String.valueOf(item.getId())+item.getNombre()+String.valueOf(item.getImagen())+String.valueOf(item.getPrecio())+String.valueOf(item.getPrecio()));
                new AlertDialog.Builder(getActivity())
                        .setTitle(R.string.app_name)
                        .setMessage("Desea comprar "+productos.get(pos).getNombre())
                        .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.d(TAG, String.valueOf(MiAplication.sqlite.comprarProducto(productos.get(pos).getId())));
                                dialogInterface.dismiss();
                                Toast.makeText(getActivity(), "Comprado "+productos.get(pos).getNombre(), Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("CANCELAR", null)
                        .show();
            }
        });

        return view;
    }


}
