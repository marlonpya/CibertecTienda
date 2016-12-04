package app.tienda.app;

import android.app.Application;

import app.tienda.sqlite.ConsultasSqlite;
import app.tienda.sqlite.ControladorSqlite;

/**
 * Created by marlonpya on 3/12/16.
 */

public class MiAplication extends Application {
    public static ConsultasSqlite sqlite;

    @Override
    public void onCreate() {
        super.onCreate();
        sqlite = new ConsultasSqlite(getApplicationContext());
    }
}
