package co.edu.uniquindio.services;

import co.edu.uniquindio.model.Prestamo;

import java.util.List;

public interface IGestionInventario {
    public void agregarPrestamo(Prestamo prestamo, List<Prestamo> listaPrestamos);
    public void eliminarPrestamo(Prestamo prestamo, List<Prestamo> listaPrestamos);
}
