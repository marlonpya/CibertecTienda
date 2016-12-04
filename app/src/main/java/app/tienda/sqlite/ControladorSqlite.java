package app.tienda.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by marlonpya on 3/12/16.
 */

public class ControladorSqlite extends SQLiteOpenHelper {

    public static final String DB_NOMBRE = "db.tienda";
    public static final int DB_VERSION = 1;

    public static final String TB_PRODUCTO  = "TB_PRODUCTO";
    public static final String PRO_ID       = "PRO_ID";
    public static final String PRO_NOMBRE   = "PRO_NOMBRE";
    public static final String PRO_IMAGEN   = "PRO_IMAGEN";
    public static final String PRO_PRECIO   = "PRO_PRECIO";
    public static final String PRO_COMPRADO = "PRO_COMPRADO";
    public static final String CREATE_TB_PRODUCTO = "CREATE TABLE " + TB_PRODUCTO +"(" +
            PRO_ID + " INTEGER AUTO_INCREMENT PRIMARY KEY," +
            PRO_NOMBRE + " TEXT," +
            PRO_IMAGEN + " INTEGER," +
            PRO_PRECIO + " DECIMAL," +
            PRO_COMPRADO + " INTEGER NOT NULL);";

    public static final String TB_CLIENTE   = "TB_CLIENTE";
    public static final String CLI_ID       = "CLI_ID";
    public static final String CLI_NOMBRE   = "CLI_NOMBRE";
    public static final String CLI_APELLIDO = "CLI_APELLIDO";
    public static final String CLI_CORREO   = "CLI_CORREO";
    public static final String CLI_CONTRASEÑA="CLI_CONTRASEÑA";
    public static final String CREATE_TB_CLIENTE = "CREATE TABLE " + TB_CLIENTE + "(" +
            CLI_ID + " INTEGER AUTO_INCREMENT PRIMARY KEY," +
            CLI_NOMBRE + " TEXT," +
            CLI_APELLIDO + " TEXT," +
            CLI_CORREO + " TEXT," +
            CLI_CONTRASEÑA + " TEXT);";

    public ControladorSqlite(Context context) {
        super(context, ControladorSqlite.DB_NOMBRE, null, ControladorSqlite.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ControladorSqlite.CREATE_TB_CLIENTE);
        sqLiteDatabase.execSQL(ControladorSqlite.CREATE_TB_PRODUCTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
