package co.edu.uniquindio.model;

import co.edu.uniquindio.model.builder.BibliotecarioBuilder;
import co.edu.uniquindio.services.IGestionInventario;

import java.util.List;

public class Bibliotecario extends Empleado implements IGestionInventario {
    private int horasDeTrabajo;

    /**
     * Constructor
     * @param nombre
     * @param edad
     * @param cedula
     * @param idEmpleado
     */
    public Bibliotecario(String nombre, int edad, String cedula, String idEmpleado,int horasDeTrabajo) {
        super(nombre, edad, cedula, idEmpleado);
        this.horasDeTrabajo = horasDeTrabajo;
    }
    public BibliotecarioBuilder builder() {
        return new BibliotecarioBuilder();
    }
    @Override
    public void agregarPrestamo(Prestamo prestamo, List<Prestamo> listaPrestamos) {
        if (prestamo.getFechaDevolucion()==null){
            listaPrestamos.add(prestamo);
        }
    }

    @Override
    public void eliminarPrestamo(Prestamo prestamo, List<Prestamo> listaPrestamos) {
        for (Prestamo p : listaPrestamos) {
            if (p.getFechaDevolucion()!=null){
                listaPrestamos.remove(p);
            }
        }
    }

    public int getHorasDeTrabajo() {
        return horasDeTrabajo;
    }

    public void setHorasDeTrabajo(int horasDeTrabajo) {
        this.horasDeTrabajo = horasDeTrabajo;
    }
}
