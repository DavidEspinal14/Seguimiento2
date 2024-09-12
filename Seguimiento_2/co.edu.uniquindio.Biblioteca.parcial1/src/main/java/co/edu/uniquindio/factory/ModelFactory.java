package co.edu.uniquindio.factory;

import co.edu.uniquindio.model.*;
import co.edu.uniquindio.model.builder.BibliotecarioBuilder;
import co.edu.uniquindio.services.ICrudMiembro;
import co.edu.uniquindio.services.ICrudPrestamo;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ModelFactory implements ICrudMiembro, ICrudPrestamo {
    private static ModelFactory instance;
    private static Biblioteca biblioteca;

    private ModelFactory() {
        inicializarDatosQuemados();
    }

    public ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    @Override
    public boolean crearMiembro(String nombre, String idMiembro) {
        return biblioteca.crearMiembro(nombre,idMiembro);
    }

    @Override
    public boolean eliminarMiembro(String idMiembro) {
        return biblioteca.eliminarMiembro(idMiembro);
    }

    @Override
    public boolean actualizarMiembro(String nombre, String idMiembro) {
        return biblioteca.actualizarMiembro(nombre,idMiembro);
    }

    @Override
    public Miembro getMiembro(String idMiembro) {
        return biblioteca.getMiembro(idMiembro);
    }

    @Override
    public List<Miembro> getMiembros() {
        return biblioteca.getMiembros();
    }

    @Override
    public boolean crearPrestamo() {
        return false;
    }

    @Override
    public boolean eliminarPrestamo() {
        return false;
    }

    @Override
    public boolean modificarPrestamo() {
        return false;
    }

    @Override
    public Prestamo getPrestamo() {
        return null;
    }

    @Override
    public List<Prestamo> getPrestamos() {
        return List.of();
    }
    /**
     * Inicializa los datos de una biblioteca, incluyendo miembros, bibliotecario, libros y prestamos
     * @return una instancia de Biblioteca con datos predefinidos
     */
    private void inicializarDatosQuemados() {
        //Miembros
        Miembro miembro1 = Miembro.builder().nombre("Carlos").idMiembro("01").build();
        Miembro miembro2 = Miembro.builder().nombre("Gustavo").idMiembro("02").build();
        Miembro miembro3 = Miembro.builder().nombre("Juana").idMiembro("03").build();
        Miembro miembro4 = Miembro.builder().nombre("Patricia").idMiembro("04").build();
        Miembro miembro5 = Miembro.builder().nombre("Romero").idMiembro("05").build();
        //Libros
        Libro libro1 = Libro.builder().titulo("Titulo1").autor("Autor1").ISBN(111).estado(true).build();
        Libro libro2 = Libro.builder().titulo("Titulo2").autor("Autor2").ISBN(222).estado(true).build();
        Libro libro3 = Libro.builder().titulo("Titulo3").autor("Autor3").ISBN(333).estado(true).build();
        Libro libro4 = Libro.builder().titulo("Titulo4").autor("Autor4").ISBN(444).estado(true).build();
        Libro libro5 = Libro.builder().titulo("Titulo5").autor("Autor5").ISBN(555).estado(true).build();
        Libro libro6 = Libro.builder().titulo("Titulo6").autor("Autor6").ISBN(666).estado(true).build();
        Libro libro7 = Libro.builder().titulo("Titulo7").autor("Autor7").ISBN(777).estado(true).build();
        Libro libro8 = Libro.builder().titulo("Titulo8").autor("Autor8").ISBN(888).estado(true).build();
        Libro libro9 = Libro.builder().titulo("Titulo9").autor("Autor9").ISBN(999).estado(true).build();
        Libro libro10= Libro.builder().titulo("Titulo10").autor("Autor10").ISBN(1010).estado(true).build();
        //Prestamos
        Prestamo prestamo1 = Prestamo.builder().fechaPrestamo(LocalDate.of(2024,8,27)).fechaDevolucion(LocalDate.of(2024,8,29)).build();
        Prestamo prestamo2 = Prestamo.builder().fechaPrestamo(LocalDate.of(2024,8,28)).fechaDevolucion(LocalDate.of(2024,8,30)).build();
        Prestamo prestamo3 = Prestamo.builder().fechaPrestamo(LocalDate.of(2024,8,29)).fechaDevolucion(LocalDate.of(2024,8,31)).build();
        Prestamo prestamo4 = Prestamo.builder().fechaPrestamo(LocalDate.of(2024,8,30)).fechaDevolucion(LocalDate.of(2024,9,1)).build();
        //Asociacion de Miembros y Libros a cada prestamo
        prestamo1.asociarLibro(libro1);
        prestamo1.asociarMiembro(miembro1);
        prestamo2.asociarLibro(libro2);
        prestamo2.asociarMiembro(miembro2);
        prestamo3.asociarLibro(libro3);
        prestamo3.asociarMiembro(miembro3);
        prestamo4.asociarLibro(libro4);
        prestamo4.asociarMiembro(miembro4);
        //Bibliotecarios
        Bibliotecario bibliotecario1 = new BibliotecarioBuilder().nombre("Julian").cedula("1010").edad(20).idEmpleado("01").horasdeTrabajo(8).build();
        Bibliotecario bibliotecario2 = new BibliotecarioBuilder().nombre("Laura").cedula("2020").edad(25).idEmpleado("02").horasdeTrabajo(8).build();
        //Asociacion de todos los objetos a la biblioteca
        List<Object> parametros = Arrays.asList(bibliotecario1,bibliotecario2,miembro1,miembro2,miembro3,miembro4,miembro5
                ,libro1,libro2,libro3,libro4,libro5,libro6,libro7,libro8,libro9,libro10);
        parametros.forEach(biblioteca::agregarAutomatico);
    }
}
