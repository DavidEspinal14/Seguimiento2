package co.edu.uniquindio.javafx;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Prestamo {
    public LocalDate fechaPrestamo;
    public LocalDate fechaDevolucion;
    public Libro libro;
    public Miembro miembro;
    private Collection<Miembro> listaMiembrosAsociados;

    /**
     * Constructor
     * @param fechaPrestamo
     * @param fechaDevolucion
     */
    public Prestamo(LocalDate fechaPrestamo, LocalDate fechaDevolucion) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        listaMiembrosAsociados = new ArrayList<>();
    }
    public Prestamo() {}

    /**
     * Asociar Libro
     * @param libro
     */
    public void asociarLibro(Libro libro) {
        if (libro != null && libro.getEstado()==true) {
            libro.setEstado(false);
            this.libro = libro;
        }else {
            JOptionPane.showMessageDialog(null, "El Libro que desea asociar, ya se encuentra en un prestamo");
        }
    }

    /**
     * Asociar Prestamo
     * @param miembro
     */
    public void asociarMiembro(Miembro miembro) {
        if (miembro != null && this.miembro == null) {
            miembro.agregarPrestamo(this);
            this.miembro = miembro;

        }else{
            JOptionPane.showMessageDialog(null,"Este prestamo ya tiene un miembro asociado");
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

    public Collection<Miembro> getListaMiembrosAsociados() {
        return listaMiembrosAsociados;
    }
}
