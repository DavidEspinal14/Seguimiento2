package org.example;

public abstract class Empleado {
    public String nombre;
    public int edad;
    public String cedula;
    public String idEmpleado;

    /**
     * Constructor
     * @param nombre
     * @param edad
     * @param cedula
     */
    public Empleado(String nombre, int edad, String cedula, String idEmpleado) {
        this.nombre = nombre;
        this.edad = edad;
        this.cedula = cedula;
        this.idEmpleado = idEmpleado;
    }

    /**
     * Gets y Sets
     * @return
     */
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getIdEmpleado() {return idEmpleado;}
    public void setIdEmpleado(String idEmpleado) {this.idEmpleado = idEmpleado;}
}
