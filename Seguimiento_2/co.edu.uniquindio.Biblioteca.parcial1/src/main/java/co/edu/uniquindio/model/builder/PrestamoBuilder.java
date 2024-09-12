package co.edu.uniquindio.model.builder;

import co.edu.uniquindio.model.Prestamo;

import java.time.LocalDate;

public class PrestamoBuilder {
    protected LocalDate fechaPrestamo;
    protected LocalDate fechaDevolucion;

    public Prestamo build(){
        return new Prestamo(fechaPrestamo, fechaDevolucion);
    }
    public PrestamoBuilder fechaPrestamo(LocalDate fechaPrestamo){
        this.fechaPrestamo = fechaPrestamo;
        return this;
    }
    public PrestamoBuilder fechaDevolucion(LocalDate fechaDevolucion){
        this.fechaDevolucion = fechaDevolucion;
        return this;
    }
}
