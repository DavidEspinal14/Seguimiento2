package org.example;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Prestamo {
    public LocalDate fechaPrestamo;
    public LocalDate fechaDevolucion;
    public Libro libro;
    public Miembro miembro;

    /**
     * Constructor
     * @param fechaPrestamo
     * @param fechaDevolucion
     */
    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = null;
    }
    public Prestamo() {}

    /**
     * Asociar Libro
     * @param libro
     */
    public void asociarLibro(Libro libro) {
        if (libro != null) {
            this.libro = libro;
        }
    }

    /**
     * Asociar Prestamo
     * @param miembro
     */
    public void asociarMiembro(Miembro miembro) {
        if (miembro != null) {
            this.miembro = miembro;
        }
    }

    /**
     * Gets
     * @return
     */
    public LocalDate getFechaPrestamo() {return fechaPrestamo;}
    public LocalDate getFechaDevolucion() {return fechaDevolucion;}
    public void setFechaDevolucion(){this.fechaDevolucion=fechaDevolucion;}
    public Libro getLibro() {
        return libro;
    }
    public Miembro getMiembro() {
        return miembro;
    }
}

