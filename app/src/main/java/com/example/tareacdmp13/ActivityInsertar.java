package com.example.tareacdmp13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tareacdmp13.configuracion.SQLiteConexion;
import com.example.tareacdmp13.configuracion.Transacciones;

public class ActivityInsertar extends AppCompatActivity {
    EditText nombres;
    EditText apellidos;
    EditText edad;
    EditText correo;
    EditText direccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        nombres =(EditText) findViewById(R.id.txtNombre);
        apellidos =(EditText) findViewById(R.id.txtApellido);
        edad =(EditText) findViewById(R.id.txtEdad);
        correo =(EditText) findViewById(R.id.txtCorreo);
        direccion =(EditText) findViewById(R.id.txtDireccion);


        Button btnAgregar = (Button) findViewById(R.id.btnAgregar);

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarPersonas();
            }
        });

    }


    private void AgregarPersonas(){
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null,1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(Transacciones.nombres , nombres.getText().toString());
        valores.put(Transacciones.apellidos , apellidos.getText().toString());
        valores.put(Transacciones.edad , edad.getText().toString());
        valores.put(Transacciones.correo , correo.getText().toString());
        valores.put(Transacciones.direccion , direccion.getText().toString());

        Long resultado = db.insert(Transacciones.tablaPersonas,Transacciones.id, valores);

        Toast.makeText(getApplicationContext(), "Registro Ingresado: Codigo: "+ resultado.toString(),Toast.LENGTH_LONG).show();
        db.close();
        LimpiarPantalla();

    }


    private void LimpiarPantalla(){
        nombres.setText("");
        apellidos.setText("");
        edad.setText("");
        correo.setText("");
        direccion.setText("");


    }
}