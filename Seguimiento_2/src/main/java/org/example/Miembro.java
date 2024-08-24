package org.example;

import java.util.ArrayList;
import java.util.Collection;

public class Miembro {
    private String nombre;
    private String idMiembro;
    private Collection<Miembro> prestamos;

    /**
     * Constructor Miembro
     * @param nombre
     * @param idMiembro
     */
    public Miembro(String nombre, String idMiembro) {
        this.nombre = nombre;
        this.idMiembro = idMiembro;
        prestamos = new ArrayList<Miembro>();
    }

    /**
     * Gets y Sets
     * @return
     */
    public String getNombre() {return nombre;}
    public String getIdMiembro() {return idMiembro;}
    public Collection<Miembro> getPrestamos() {return prestamos;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setIdMiembro (String idMiembro){this.idMiembro = idMiembro;}
}
