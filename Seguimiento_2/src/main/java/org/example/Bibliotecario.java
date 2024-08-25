package org.example;

import java.util.List;

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
    public void agregarLibros(Libro libro, List<Libro> ListaLibros){
        if (libro.getTitulo() != null) {
            ListaLibros.add(libro);
            System.out.println("El libro \"" + libro.getTitulo() + "\" ha sido agregado a la lista.");
        } else {
            System.out.println("El objeto proporcionado no es válido.");
        }
    }
    /**
     * Agregar un prestamo
     * @param
     * @return
     */
    public void agregarPrestamo(Prestamo prestamo, List<Prestamo> ListaPrestamos) {
        if (prestamo.getFechaDevolucion()==null){
            ListaPrestamos.add(prestamo);
        }
    }

    /**
     * Metodo para terminar un prestamo
     * @param
     */
    public void devolverPrestamo(Prestamo prestamo, List<Prestamo> ListaPrestamos) {
        for (Prestamo prestamo1 : ListaPrestamos) {
            if (prestamo1.getFechaDevolucion()!=null){
                ListaPrestamos.remove(prestamo1);
            }
        }
    }


    /**
     * Metodo polimórfico para gestionar libros, dvd´s, revistas
     */
    @Override
    public void gestionarItem(Prestamo prestamo, List<Prestamo> ListaPrestamos) {
        agregarPrestamo(prestamo, ListaPrestamos);
        devolverPrestamo(prestamo, ListaPrestamos);
        gestionarRevista();
    }
}
