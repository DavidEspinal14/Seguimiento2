package co.edu.uniquindio.model;

import co.edu.uniquindio.services.ICrudMiembro;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Biblioteca implements ICrudMiembro{
    private String nombre;
    private List<Libro> listalibros;
    private List<Miembro> listaMiembros;
    private List<Prestamo> listaPrestamos;
    private List<Empleado> listaEmpleados;

    /**
     * Constructor
     * @param nombre
     */
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        listalibros = new ArrayList<Libro>();
        listaEmpleados = new ArrayList<>();
        listaMiembros = new ArrayList<>();
        listaPrestamos = new ArrayList<>();
    }
    /**
     * Metodo generico para agregar cualquier objeto automaticamente a su lista correspondiente
     * @param objeto
     * @param <T>
     */
    public <T> void agregarAutomatico(T objeto) {
        if (objeto instanceof Libro) {
            listalibros.add((Libro) objeto);
        }else if (objeto instanceof Miembro) {
            listaMiembros.add((Miembro) objeto);
        }else if (objeto instanceof Prestamo) {
            listaPrestamos.add((Prestamo) objeto);
        }else if (objeto instanceof Empleado) {
            listaEmpleados.add((Empleado) objeto);
        }
    }
    /**
     * Gets y Sets
     * @return
     */
    public void setListalibros(List<Libro> listalibros) {
        this.listalibros = listalibros;
    }
    public void setListaMiembros(List<Miembro> listaMiembros) {
        this.listaMiembros = listaMiembros;
    }
    public void setListaPrestamos(List<Prestamo> listaPrestamos) {
        this.listaPrestamos = listaPrestamos;
    }
    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }
    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public Collection<Libro> getListalibros() {return listalibros;}
    public Collection<Prestamo> getListaPrestamos() {return listaPrestamos;}
    public Collection<Miembro> getListaMiembros() {return listaMiembros;}

    /**
     * Metodo para verificar si un miembro ya existe
     * @param nombre
     * @return
     */
    private boolean verificarMiembroRepetido(String nombre){
        for (Miembro miembro : listaMiembros){
            if (miembro.getNombre().equals(nombre)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean crearMiembro(String nombre, String idMiembro) {
        if (!verificarMiembroRepetido(nombre)){
            Miembro miembro = Miembro.builder().nombre(nombre).idMiembro(idMiembro).build();
            listaMiembros.add(miembro);
            return true;
        }
        return false;
    }

    @Override
    public boolean eliminarMiembro(String idMiembro) {
        for (Miembro miembro : listaMiembros){
            if (miembro.getIdMiembro().equals(idMiembro)){
                listaMiembros.remove(miembro);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean actualizarMiembro(String nombre, String idMiembro) {
        for (Miembro miembro : listaMiembros){
            if (miembro.getNombre().equals(nombre)){
                miembro.setNombre(nombre);
                miembro.setIdMiembro(idMiembro);
                return true;
            }
        }
        return false;
    }

    @Override
    public Miembro getMiembro(String idMiembro) {
        for (Miembro miembro : listaMiembros){
            if (miembro.getIdMiembro().equals(idMiembro)){
                return miembro;
            }
        }
        return null;
    }

    @Override
    public List<Miembro> getMiembros() {
        if (listaMiembros.size() > 0) {
            return listaMiembros;
        }else {
            return null;
        }
    }
}
