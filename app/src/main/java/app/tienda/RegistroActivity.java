package app.tienda;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import app.tienda.app.MiAplication;
import app.tienda.modelo.Cliente;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener{
    private LinearLayout layout;
    private Button btnRegistro;
    private Toolbar toolbar;
    private EditText etNombreRegistro, etApellidoRegistro, etCorreoRegistro, etCorreoRegistroRepetido, etContraseñaRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        layout = (LinearLayout) findViewById(R.id.layout_activity_registro);
        btnRegistro = (Button)findViewById(R.id.btnRegistro);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        etNombreRegistro = (EditText) findViewById(R.id.etNombreRegistro);
        etApellidoRegistro = (EditText) findViewById(R.id.etApellidoRegistro);
        etCorreoRegistro = (EditText) findViewById(R.id.etCorreoRegistro);
        etCorreoRegistroRepetido = (EditText) findViewById(R.id.etCorreoRegistroRepetida);
        etContraseñaRegistro = (EditText) findViewById(R.id.etContraseñaRegistro);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Registrar Usuario");

        btnRegistro.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnRegistro :
                registroCliente();
                break;
        }
    }

    private void registroCliente() {
        String nombre           = etNombreRegistro.getText().toString();
        String apellido         = etApellidoRegistro.getText().toString();
        String correo           = etCorreoRegistro.getText().toString();
        String correo_repetido  = etCorreoRegistroRepetido.getText().toString();
        String contraseña       = etContraseñaRegistro.getText().toString();
        if (!nombre.isEmpty() || !apellido.isEmpty() || !correo.isEmpty() || !correo_repetido.isEmpty() || !contraseña.isEmpty()) {
            if (correo.equals(correo_repetido)) {
                Cliente cliente_registro = new Cliente(nombre, apellido, correo, contraseña);
                MiAplication.sqlite.registroDeCliente(cliente_registro);
                Toast.makeText(RegistroActivity.this, "BIENVENIDO " + cliente_registro.getNombre(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegistroActivity.this, InicioActivity.class));
                finish();
            } else {
                Snackbar.make(layout, "Los Correos no coinciden", Snackbar.LENGTH_LONG).show();
            }
        } else {
            Snackbar.make(layout, "Debe ingresar todos los datos", Snackbar.LENGTH_LONG).show();
        }
    }
}
