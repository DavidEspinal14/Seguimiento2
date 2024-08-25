package org.example;

import java.util.Collection;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Libro> Listalibros;
    private List<Miembro> ListaMiembros;
    private List<Prestamo> ListaPrestamos;
    private List<Libro> ListaLibrosPrestados;

    /**
     * Constructor
     * @param nombre
     */
    public Biblioteca(String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets y Sets
     * @return
     */
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public Collection<Libro> getListalibros() {return Listalibros;}
    public Collection<Prestamo> getListaPrestamos() {return ListaPrestamos;}
    public Collection<Miembro> getListaMiembros() {return ListaMiembros;}
    public Collection<Libro> getListaLibrosPrestados() {return ListaLibrosPrestados;}
}
