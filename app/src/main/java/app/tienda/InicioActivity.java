package app.tienda;

import android.accessibilityservice.GestureDescription;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import app.tienda.app.MiAplication;
import app.tienda.modelo.Producto;
import app.tienda.sqlite.ConsultasSqlite;
import app.tienda.util.Constantes;

public class InicioActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout layout;
    private Button btnIngresar, btnRegistrarse;
    private Toolbar toolbar;
    private EditText etCorreoIngreso, etContraseñaIngreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        layout = (LinearLayout) findViewById(R.id.layout_activity_inicio);
        btnIngresar = (Button) findViewById(R.id.btnIngresar);
        btnRegistrarse = (Button) findViewById(R.id.btnRegistrarse);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        etCorreoIngreso = (EditText) findViewById(R.id.etCorreoIngreso);
        etContraseñaIngreso = (EditText)findViewById(R.id.etContraseñaIngreso);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Iniciar Sesión");

        btnRegistrarse.setOnClickListener(this);
        btnIngresar.setOnClickListener(this);

        if (!MiAplication.sqlite.validarVestidosRegistrados()) cargarVestidos();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegistrarse:
                irRegistrarse();
                break;
            case R.id.btnIngresar:
                ingresarCliente();
                break;
        }
    }

    private void irRegistrarse() {
        startActivity(new Intent(InicioActivity.this, RegistroActivity.class));
    }

    private void ingresarCliente() {
        String correo = etCorreoIngreso.getText().toString().trim();
        String contraseña = etContraseñaIngreso.getText().toString().trim();

        if (MiAplication.sqlite.verificarCliente(correo, contraseña)) {
            Toast.makeText(InicioActivity.this, "BIENVENIDO " + correo, Toast.LENGTH_LONG).show();
            startActivity(new Intent(InicioActivity.this, PrincipalActivity.class)
            .putExtra(Constantes.K_CONTRASEÑA, contraseña));
        } else {
            Snackbar.make(layout, "CLIENTE NO REGISTRADO", Snackbar.LENGTH_LONG).show();
        }
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
