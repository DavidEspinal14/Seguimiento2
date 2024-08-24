package org.example;

import java.util.ArrayList;
import java.util.Collection;

public class Biblioteca {
    private String nombre;
    public Collection <Biblioteca> miembros;
    public Collection <Biblioteca> libros;
    public Collection <Biblioteca> prestamos;

    /**
     * Constructor
     * @param nombre
     */
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        miembros = new ArrayList<Biblioteca>();
        libros = new ArrayList<Biblioteca>();
        prestamos = new ArrayList<Biblioteca>();
    }



    /**
     * Gets y Sets
     * @return
     */
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public Collection <Biblioteca> getLibros() {return libros;}
    public void setLibros(Collection <Biblioteca> libros) {this.libros = libros;}
    public Collection <Biblioteca> getPrestamos() {return prestamos;}
    public void setPrestamos(Collection <Biblioteca> prestamos) {this.prestamos = prestamos;}
}
