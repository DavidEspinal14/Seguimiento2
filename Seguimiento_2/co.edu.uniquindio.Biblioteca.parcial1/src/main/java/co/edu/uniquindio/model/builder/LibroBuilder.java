package co.edu.uniquindio.model.builder;

import co.edu.uniquindio.model.Libro;

public class LibroBuilder {
    protected String titulo;
    protected String autor;
    protected int ISBN;
    protected boolean estado;

    public Libro build(){
        return new Libro(titulo,autor,ISBN,estado);
    }
    public LibroBuilder titulo(String titulo){
        this.titulo = titulo;
        return this;
    }
    public LibroBuilder autor(String autor){
        this.autor = autor;
        return this;
    }
    public LibroBuilder ISBN(int ISBN){
        this.ISBN = ISBN;
        return this;
    }
    public LibroBuilder estado(boolean estado){
        this.estado = estado;
        return this;
    }
}
