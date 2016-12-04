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
}
