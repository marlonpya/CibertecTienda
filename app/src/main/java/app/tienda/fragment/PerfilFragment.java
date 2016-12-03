package app.tienda.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import app.tienda.R;
import app.tienda.adapter.CompraAdapter;
import app.tienda.adapter.ProductoAdapter;
import app.tienda.modelo.Producto;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    public PerfilFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        return view;
    }

}
