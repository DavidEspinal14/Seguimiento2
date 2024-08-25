package org.example;

import java.io.Serializable;

public class Bibliotecario extends Empleado implements Inventario {
    public int horasTrabajo;
    public Bibliotecario(int horasTrabajo){
        super(nombre, edad, cedula, idEmpleado);
    }
    public void gestionarPrestamo(){

    }

    /**
     * Metodo para agregar libros
     * @param libro
     */
    public void agregarLibros(Libro libro){
        if (libro != null) {
            libros.add(libro);
            System.out.println("El libro \"" + libro.getTitulo() + "\" ha sido agregado a la lista.");
        } else {
            System.out.println("El objeto proporcionado no es válido.");
        }
    }

    /**
     * Metodo polimorfico para gestionar libros, dvd´s, revistas
     */
    @Override
    public void gestionarItem() {
    }
}
