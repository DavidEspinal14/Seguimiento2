package co.edu.uniquindio.model.builder;

import co.edu.uniquindio.model.Empleado;

public class EmpleadoBuilder <T extends EmpleadoBuilder<T>>{
    protected String nombre;
    protected int edad;
    protected String cedula;
    protected String idEmpleado;

    public Empleado build(){
        return new Empleado(nombre, edad, cedula, idEmpleado);
    }
    @SuppressWarnings("unchecked")
    protected T self(){
        return (T)this;
    }

    public T nombre(String nombre) {
        this.nombre = nombre;
        return self();
    }
    public T edad(int edad) {
        this.edad = edad;
        return self();
    }
    public T cedula(String cedula) {
        this.cedula = cedula;
        return self();
    }
    public T idEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
        return self();
    }
}
