package app.tienda.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.tienda.R;
import app.tienda.app.MiAplication;
import app.tienda.modelo.Cliente;
import app.tienda.util.Constantes;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {
    private TextView nombre_perfil, apellido_perfil, correo_perfil;
    private String contraseña_id;

    public PerfilFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        nombre_perfil = (TextView) view.findViewById(R.id.nombre_perfil);
        apellido_perfil = (TextView) view.findViewById(R.id.apellido_perfil);
        correo_perfil = (TextView) view.findViewById(R.id.correo_perfil);

        contraseña_id = getActivity().getIntent().getStringExtra(Constantes.K_CONTRASEÑA);
        Cliente cliente = MiAplication.sqlite.getCliente(contraseña_id);
        nombre_perfil.setText(cliente.getNombre());
        apellido_perfil.setText(cliente.getApellido());
        correo_perfil.setText(cliente.getCorreo());
        return view;
    }

}
