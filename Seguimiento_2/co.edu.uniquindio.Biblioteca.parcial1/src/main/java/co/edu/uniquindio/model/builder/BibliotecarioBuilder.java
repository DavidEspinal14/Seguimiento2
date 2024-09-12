package co.edu.uniquindio.model.builder;

import co.edu.uniquindio.model.Bibliotecario;

public class BibliotecarioBuilder extends EmpleadoBuilder<BibliotecarioBuilder>{
    protected int horasDeTrabajo;

    public BibliotecarioBuilder horasdeTrabajo(int horasDeTrabajo) {
        this.horasDeTrabajo = horasDeTrabajo;
        return this;
    }
    @Override
    public Bibliotecario build() {
        return new Bibliotecario(nombre,edad,cedula,idEmpleado,horasDeTrabajo);
    }
    @Override
    protected BibliotecarioBuilder self(){
        return this;
    }
}
