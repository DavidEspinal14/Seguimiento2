package org.example;

public class Libro {
    private String titulo;
    private String autor;
    private int ISBN;
    private boolean estado;

    /**
     * Constructor Libro
     * @param titulo
     * @param autor
     * @param ISBN
     * @param estado
     */
    public Libro(String titulo, String autor, int ISBN, boolean estado) {
        assert titulo != null;
        assert autor != null;
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
    public int getISBN() {return ISBN;}
    public boolean getEstado() {return estado;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public void setAutor(String autor) {this.autor = autor;}
    public void setISBN(int ISBN) {this.ISBN = ISBN;}
    public void prestar(){this.estado = false;}
    public void terminarPrestamo(){this.estado = true;}
}
