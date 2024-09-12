package co.edu.uniquindio.model;

import co.edu.uniquindio.model.builder.PrestamoBuilder;

import java.time.LocalDate;
import java.util.ListResourceBundle;

public class Prestamo {

    private Miembro miembro;
    private Bibliotecario bibliotecario;
    private Libro libro;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
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

    public static PrestamoBuilder builder(){
        return new PrestamoBuilder();
    }
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
