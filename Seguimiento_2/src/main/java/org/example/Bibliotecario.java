package org.example;

public class Bibliotecario extends Empleado{
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
    }
}
