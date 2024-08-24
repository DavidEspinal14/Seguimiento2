package org.example;
import java.time.LocalDate;
public class Prestamo {
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;

    /**
     * Constructor
     * @param fechaPrestamo
     * @param fechaDevolucion
     */
    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Gets
     * @return
     */
    public LocalDate getFechaPrestamo() {return fechaPrestamo;}
    public LocalDate getFechaDevolucion() {return fechaDevolucion;}
}
