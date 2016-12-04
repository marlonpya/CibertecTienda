package app.tienda.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
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
import app.tienda.sqlite.ConsultasSqlite;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaProductosFragment extends Fragment {
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

        if (!MiAplication.sqlite.validarVestidosRegistrados()) cargarVestidos();

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
                new AlertDialog.Builder(getActivity())
                        .setTitle(R.string.app_name)
                        .setMessage("Desea comprar "+productos.get(pos).getNombre())
                        .setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MiAplication.sqlite.comprarProducto(productos.get(pos));
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

    private void cargarVestidos() {
        MiAplication.sqlite.registroVestido(new Producto("Vestido negro floral 1", R.drawable.imagen01, 200.00));
        MiAplication.sqlite.registroVestido(new Producto("Vestido negro floral 2", R.drawable.imagen_02_vestido_negro, 300.00));
        MiAplication.sqlite.registroVestido(new Producto("Vestido casual", R.drawable.imagen_03_ropa_chica, 400.00));
        MiAplication.sqlite.registroVestido(new Producto("Vestido negro boom", R.drawable.imagen_04_vestido_chica, 250.00));
        MiAplication.sqlite.registroVestido(new Producto("Vestido rojo puas negras", R.drawable.imagen_05_vestido_rojo, 270.00));
        MiAplication.sqlite.registroVestido(new Producto("Vestido negro lotto", R.drawable.imagen_06_vestido_negro_grande, 120.00));
        MiAplication.sqlite.registroVestido(new Producto("Vestido rojo compress", R.drawable.imagen_07_vestido_negro_impactante, 530.00));
        MiAplication.sqlite.registroVestido(new Producto("Vestido negro mallas", R.drawable.imagen_08_vestido_cuadros_plomos, 350.00));
        MiAplication.sqlite.registroVestido(new Producto("Vestido rojo mediano", R.drawable.imagen_09_vestido_rojo_opaco, 460.00));
        MiAplication.sqlite.registroVestido(new Producto("Vestido verde flores", R.drawable.imagen_10_vestido_verde, 240.00));
        MiAplication.sqlite.registroVestido(new Producto("Vestido verde casual", R.drawable.imagen_11_vestido_completo_verde, 530.00));
        MiAplication.sqlite.registroVestido(new Producto("Vestido rosa y mallas casual", R.drawable.imagen_12_vestido_rosa, 210.00));
        MiAplication.sqlite.registroVestido(new Producto("Vestido verde bodas", R.drawable.imagen_13_vestido_boda_verde, 540.00));
    }

}
