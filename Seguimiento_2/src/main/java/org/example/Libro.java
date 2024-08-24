package org.example;

public class Libro {
    private String titulo;
    private String autor;
    private String ISBN;
    private boolean estado;

    /**
     * Constructor Libro
     * @param titulo
     * @param autor
     * @param ISBN
     * @param estado
     */
    public Libro(String titulo, String autor, String ISBN, boolean estado) {
        assert titulo != null;
        assert autor != null;
        assert ISBN != null;
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.estado = estado;
    }

    /**
     * Gets y Sets
     * @return
     */
    public String getTitulo() {return titulo;}
    public String getAutor() {return autor;}
    public String getISBN() {return ISBN;}
    public boolean getEstado() {return estado;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setAutor(String autor) {this.autor = autor;}
    public void setISBN(String ISBN) {this.ISBN = ISBN;}
    public void setEstado(boolean estado) {this.estado = estado;}
}
