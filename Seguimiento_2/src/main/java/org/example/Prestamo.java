package org.example;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Prestamo {
    public LocalDate fechaPrestamo;
    public LocalDate fechaDevolucion;
    public List<Libro> ListaLibrosAsociados;
    public List<Miembro> ListaMiembrosAsociados;

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
    public void asociarLibro(Libro libro,List<Libro> ListaLibrosPrestados) {
        if (ListaLibrosAsociados.contains(libro)) {System.out.print("el libro ya esta en el prestamo");}
        if (ListaLibrosAsociados.size()>15){System.out.print("La cantidad de libros en el prestamo es muy grande");}
        else{ListaLibrosAsociados.add(libro);
        ListaLibrosPrestados.add(libro);}
    }

    /**
     * Asociar Prestamo
     * @param miembro
     */
    public void asociarMiembro(Miembro miembro) {
        if (ListaMiembrosAsociados == null) {ListaMiembrosAsociados.add(miembro);}
        else{System.out.println("El prestamo ya esta asociado a un miembro");}
    }

    /**
     * Gets
     * @return
     */
    public LocalDate getFechaPrestamo() {return fechaPrestamo;}
    public LocalDate getFechaDevolucion() {return fechaDevolucion;}
    public void setFechaDevolucion(){this.fechaDevolucion=fechaDevolucion;}
    public Collection<Libro> getListaLibrosAsociados() {return ListaLibrosAsociados;}
    public Collection<Miembro> getListaMiembrosAsociados() {return ListaMiembrosAsociados;}
}

