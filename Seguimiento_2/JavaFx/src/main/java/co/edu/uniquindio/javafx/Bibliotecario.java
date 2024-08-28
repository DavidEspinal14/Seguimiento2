package co.edu.uniquindio.javafx;

import java.util.List;

public class Bibliotecario extends Empleado implements Inventario {
    public int horasTrabajo;

    public Bibliotecario(String nombre,int edad, String cedula, String idEmpleado, int horasTrabajo){
        super(nombre, edad, cedula, idEmpleado);
        this.horasTrabajo = horasTrabajo;
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
     * Metodo que agrega miembros
     * @param miembro
     * @param ListaMiembros
     */

    public void agregarMiembro( Miembro miembro, List <Miembro> ListaMiembros){
        if(miembro.getIdMiembro()== null){
            ListaMiembros.add(miembro);
        }
    }

    /**
     * Metodo para asociar Un prestamo a un miembro
     * @param ListaMiembros
     * @param ListaPrestamos
     */
    public void asociarPrestamoMiembro(List<Miembro> ListaMiembros, List<Prestamo> ListaPrestamos) {
        for (Prestamo prestamo : ListaPrestamos) {
            List<Miembro> miembrosAsociados = (List<Miembro>) prestamo.getListaMiembrosAsociados();
            for (Miembro miembro : ListaMiembros) {
                if (!miembrosAsociados.contains(miembro)) {
                    miembrosAsociados.add(miembro);
                }
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

    @Override
    public void gestionarRevista() {
    }
}
