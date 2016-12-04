package app.tienda.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import app.tienda.modelo.Cliente;
import app.tienda.modelo.Producto;

/**
 * Created by marlonpya on 3/12/16.
 */

public class ConsultasSqlite {

    ControladorSqlite sqlite;

    public ConsultasSqlite(Context context) {
        this.sqlite = new ControladorSqlite(context);
    }

    public void registroDeCliente(Cliente cliente) {
        SQLiteDatabase db = sqlite.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ControladorSqlite.CLI_NOMBRE, cliente.getNombre());
        values.put(ControladorSqlite.CLI_APELLIDO, cliente.getApellido());
        values.put(ControladorSqlite.CLI_CORREO, cliente.getCorreo());
        values.put(ControladorSqlite.CLI_CONTRASEÑA, cliente.getContraseña());
        db.insert(ControladorSqlite.TB_CLIENTE, null, values);
    }

    public void registroVestido(Producto producto) {
        SQLiteDatabase db = sqlite.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ControladorSqlite.PRO_NOMBRE, producto.getNombre());
        values.put(ControladorSqlite.PRO_IMAGEN, producto.getImagen());
        values.put(ControladorSqlite.PRO_PRECIO, producto.getPrecio());
        db.insert(ControladorSqlite.TB_PRODUCTO, null, values);
    }

    public boolean verificarCliente(String correo, String contraseña) {
        SQLiteDatabase db = sqlite.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TB_CLIENTE " +
                                    "WHERE "+ControladorSqlite.CLI_CORREO + "= '"+correo + "' " +
                                    " AND " +ControladorSqlite.CLI_CONTRASEÑA + "= '" + contraseña + "'", null);
        return cursor.moveToFirst();
    }

    public ArrayList<Producto> getMisCompras() {
        ArrayList<Producto> mis_compras = new ArrayList<>();
        SQLiteDatabase db = sqlite.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TB_PRODUCTO WHERE PRO_COMPRADO = 1", null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Producto producto = new Producto(cursor.getInt(cursor.getColumnIndex(ControladorSqlite.PRO_ID)),
                            cursor.getString(cursor.getColumnIndex(ControladorSqlite.PRO_NOMBRE)),
                            cursor.getInt(cursor.getColumnIndex(ControladorSqlite.PRO_IMAGEN)),
                            cursor.getDouble(cursor.getColumnIndex(ControladorSqlite.PRO_PRECIO)),
                            cursor.getInt(cursor.getColumnIndex(ControladorSqlite.PRO_COMPRADO)));
                    mis_compras.add(producto);
                } while (cursor.moveToNext());
            }
        }
        return mis_compras;
    }

    public ArrayList<Producto> getProductos() {
        ArrayList<Producto> mis_compras = new ArrayList<>();
        SQLiteDatabase db = sqlite.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TB_PRODUCTO", null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Producto producto = new Producto(cursor.getInt(cursor.getColumnIndex(ControladorSqlite.PRO_ID)),
                            cursor.getString(cursor.getColumnIndex(ControladorSqlite.PRO_NOMBRE)),
                            cursor.getInt(cursor.getColumnIndex(ControladorSqlite.PRO_IMAGEN)),
                            cursor.getDouble(cursor.getColumnIndex(ControladorSqlite.PRO_PRECIO)),
                            cursor.getInt(cursor.getColumnIndex(ControladorSqlite.PRO_COMPRADO)));
                    mis_compras.add(producto);
                } while (cursor.moveToNext());
            }
        }
        return mis_compras;
    }

    public Cliente getCliente(String contraseña) {
        Cliente cliente = new Cliente();
        SQLiteDatabase db = sqlite.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TB_CLIENTE WHERE CLI_CONTRASEÑA = '"+contraseña+"'", null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                cliente.setId(cursor.getInt(cursor.getColumnIndex(ControladorSqlite.CLI_ID)));
                cliente.setNombre(cursor.getString(cursor.getColumnIndex(ControladorSqlite.CLI_NOMBRE)));
                cliente.setApellido(cursor.getString(cursor.getColumnIndex(ControladorSqlite.CLI_APELLIDO)));
                cliente.setCorreo(cursor.getString(cursor.getColumnIndex(ControladorSqlite.CLI_CORREO)));
                cliente.setContraseña(cursor.getString(cursor.getColumnIndex(ControladorSqlite.CLI_CONTRASEÑA)));
            }
        }
        return cliente;
    }

    public boolean validarVestidosRegistrados() {
        SQLiteDatabase db = sqlite.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TB_PRODUCTO", null);
        return cursor.moveToFirst();
    }

    public ArrayList<Producto> getProductosNombre(String descripcion) {
        ArrayList<Producto> mis_compras = new ArrayList<>();
        SQLiteDatabase db = sqlite.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM TB_PRODUCTO WHERE " +
                "PRO_NOMBRE like '% "+descripcion+" %' " +
                "OR PRO_NOMBRE like '"+descripcion+"%' " +
                "OR PRO_NOMBRE like '% "+descripcion+"' " +
                "OR PRO_NOMBRE like '"+descripcion+"'", null);
        if (cursor.getCount() > 0) {
            if (cursor.moveToFirst()) {
                do {
                    Producto producto = new Producto(cursor.getInt(cursor.getColumnIndex(ControladorSqlite.PRO_ID)),
                            cursor.getString(cursor.getColumnIndex(ControladorSqlite.PRO_NOMBRE)),
                            cursor.getInt(cursor.getColumnIndex(ControladorSqlite.PRO_IMAGEN)),
                            cursor.getDouble(cursor.getColumnIndex(ControladorSqlite.PRO_PRECIO)),
                            cursor.getInt(cursor.getColumnIndex(ControladorSqlite.PRO_COMPRADO)));
                    mis_compras.add(producto);
                } while (cursor.moveToNext());
            }
        }
        return mis_compras;
    }

    public boolean comprarProducto(int id_producto) {
        SQLiteDatabase db = sqlite.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ControladorSqlite.PRO_COMPRADO, "1");
        return (db.update(ControladorSqlite.TB_PRODUCTO, values, ControladorSqlite.PRO_ID+"="+id_producto, null) > 0);
    }

    public void comprarProducto2(int id){
        int valor_comprado = 0;
        SQLiteDatabase db = sqlite.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from "+ControladorSqlite.TB_PRODUCTO + " where "+ControladorSqlite.PRO_ID + "="+id,null);
        if (cursor.moveToFirst()){
            do {
                valor_comprado = cursor.getInt(cursor.getColumnIndex(ControladorSqlite.PRO_COMPRADO));
                if (valor_comprado == 0){
                    db.execSQL("update "+ControladorSqlite.TB_PRODUCTO +
                            " set "+ControladorSqlite.PRO_COMPRADO + "= 1" +
                            " where "+ControladorSqlite.PRO_ID + "="+id);
                }
                db.close();
            }while (cursor.moveToNext());
        }
    }

}