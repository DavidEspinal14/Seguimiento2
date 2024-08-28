package co.edu.uniquindio.javafx;

import javafx.util.converter.PercentageStringConverter;

import java.util.ArrayList;
import java.util.Collection;

public class Miembro {
    private String nombre;
    private String idMiembro;
    private Collection<Prestamo> prestamos;

    /**
     * Constructor Miembro
     * @param nombre
     * @param idMiembro
     */
    public Miembro(String nombre, String idMiembro) {
        this.nombre = nombre;
        this.idMiembro = idMiembro;
        prestamos = new ArrayList<Prestamo>();
    }
    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }
    /**
     * Gets y Sets
     * @return
     */
    public String getNombre() {return nombre;}
    public String getIdMiembro() {return idMiembro;}
    public Collection<Prestamo> getPrestamos() {return prestamos;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setIdMiembro (String idMiembro){this.idMiembro = idMiembro;}
}
