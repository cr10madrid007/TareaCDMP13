package com.example.tareacdmp13;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.tareacdmp13.configuracion.SQLiteConexion;
import com.example.tareacdmp13.configuracion.Transacciones;
import com.example.tareacdmp13.tablas.Personas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteConexion conexion;
    ListView listapersonas;
    ArrayList<Personas> lista;
    ArrayList<String> ArregloPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnInsertar =(Button) findViewById(R.id.btnInsertar);

        Button btnEditar =(Button) findViewById(R.id.btnEditar);

        conexion = new SQLiteConexion( this, Transacciones.NameDatabase, null, 1);
        listapersonas=(ListView) findViewById(R.id.listapersonas);

        obtenerListaPersonas();
        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, ArregloPersonas);
        listapersonas.setAdapter(adp);


        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityInsertar.class);
                startActivity(intent);
            }
        });


        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ActivityEditar.class);
                startActivity(intent);
            }
        });
    }

    private void obtenerListaPersonas(){
        SQLiteDatabase db = conexion.getReadableDatabase();
        Personas list_personas = null;
        lista= new ArrayList<Personas>();

        // cursor de bd, nos apoya a recorrer la informacion

        Cursor cursor= db.rawQuery("SELECT * FROM "+Transacciones.tablaPersonas, null);

        // recorremos la informacion del cursor

        while (cursor.moveToNext()){
            list_personas= new Personas();
            list_personas.setId(cursor.getInt(0));
            list_personas.setNombres(cursor.getString(1));
            list_personas.setApellidos(cursor.getString(2));
            list_personas.setEdad(cursor.getInt(3));
            list_personas.setCorreo(cursor.getString(4));
            list_personas.setDireccion(cursor.getString(5));

            lista.add(list_personas);
        }
        cursor.close();

        fillList();

    }

    private void fillList(){
        ArregloPersonas = new ArrayList<String>();
        for (int i = 0; i < lista.size(); i++){
            ArregloPersonas.add(lista.get(i).getId() + "\n"
                    +lista.get(i).getNombres()+" "+lista.get(i).getApellidos()+ "\t"
                    +lista.get(i).getEdad()+"\n"
                    +lista.get(i).getCorreo()+"\n"
                    +lista.get(i).getDireccion());
        }
    }



}