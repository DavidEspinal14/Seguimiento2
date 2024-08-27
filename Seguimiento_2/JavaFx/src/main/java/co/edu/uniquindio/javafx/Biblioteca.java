package co.edu.uniquindio.javafx;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Libro> listalibros;
    private List<Miembro> listaMiembros;
    private List<Prestamo> listaPrestamos;
    private List<Libro> listaLibrosPrestados;
    private List<Bibliotecario> listaBibliotecarios;

    /**
     * Constructor
     * @param nombre
     */
    public Biblioteca(String nombre) {
        this.nombre = nombre;
        listalibros = new ArrayList<Libro>();
        listaBibliotecarios = new ArrayList<>();
        listaLibrosPrestados = new ArrayList<>();
        listaMiembros = new ArrayList<>();
        listaPrestamos = new ArrayList<>();
    }

    /**
     * Metodo generico para agregar cualquier objeto dependiendo de su clase en la lista correspondiente
     * @param objeto
     * @param <T>
     */
    public <T> void agregarAutomatico(T objeto) {
        if (objeto instanceof Libro) {
            listalibros.add((Libro) objeto);
        }else if (objeto instanceof Bibliotecario) {
            listaBibliotecarios.add((Bibliotecario) objeto);
        }else if (objeto instanceof Miembro) {
            listaMiembros.add((Miembro) objeto);
        }else if (objeto instanceof Prestamo) {
            listaPrestamos.add((Prestamo) objeto);
        }
    }
    /**
     * Gets y Sets
     * @return
     */
    public List<Bibliotecario> getListaBibliotecarios() {
        return listaBibliotecarios;
    }
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public Collection<Libro> getListalibros() {return listalibros;}
    public Collection<Prestamo> getListaPrestamos() {return listaPrestamos;}
    public Collection<Miembro> getListaMiembros() {return listaMiembros;}
    public Collection<Libro> getListaLibrosPrestados() {return listaLibrosPrestados;}
}
