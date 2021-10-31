package com.example.tareacdmp13.configuracion;

public class Transacciones {
    // nombre de la bd
    public  static final String NameDatabase="PMTarea13";

    // Tablas de la base de datos

    public static final String tablaPersonas = "personas";

    //Campos de la tabla persona
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";
    public static final String direccion = "direccion";

    // Transacciones DDL(Data Definition Lenguaje) Tabla personas

    public static final String CreateTablePersonas = "CREATE TABLE personas(id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "nombres TEXT, apellidos TEXT, edad INTEGER, correo TEXT, direccion TEXT)";
    public static final String DROPTablePersonas= "DROP TABLE IF EXIST personas";

}
