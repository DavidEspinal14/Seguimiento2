package co.edu.uniquindio.services;

import co.edu.uniquindio.model.Prestamo;

import java.util.List;

public interface ICrudPrestamo {
    public boolean crearPrestamo();
    public boolean eliminarPrestamo();
    public boolean modificarPrestamo();
    public Prestamo getPrestamo();
    public List<Prestamo> getPrestamos();
}
