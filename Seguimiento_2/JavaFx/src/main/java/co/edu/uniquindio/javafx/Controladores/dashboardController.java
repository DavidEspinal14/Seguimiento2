package co.edu.uniquindio.javafx.Controladores;

import co.edu.uniquindio.javafx.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableColumn;

import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class dashboardController implements Initializable {
    @FXML
    private TableColumn<?, ?> columnaFechaDevolucion;

    @FXML
    private TableColumn<?, ?> columnaFechaPrestamo;

    @FXML
    private TableColumn<Prestamo, String> columnaId;

    @FXML
    private TableColumn<?, ?> columnaIdMiembro;

    @FXML
    private TableColumn<Prestamo, String> columnaMaterial;

    @FXML
    private TableColumn<Prestamo, String> columnaNombre;
    @FXML
    private TableColumn<?, ?> columnaNombreMiembro;
    @FXML
    private TableView<Miembro> tablaMiembros;

    @FXML
    private TableView<Prestamo> tablaPrestamos;

    @FXML
    private AnchorPane barra;
    private ObservableList<Miembro> miembros;
    private ObservableList<Prestamo> prestamos;
    @FXML
    private AnchorPane menuMiembros;

    @FXML
    private AnchorPane menuPrestamos;

    private Biblioteca biblioteca;

    @FXML
    void clickMiembros(ActionEvent event) {
        menuPrestamos.setVisible(false);
        menuMiembros.setVisible(true);

    }

    @FXML
    void clickPrestamos(ActionEvent event) {
        menuMiembros.setVisible(false);
        menuPrestamos.setVisible(true);

    }
    @FXML
    void clickAgregarMiembro(ActionEvent event) {
    }
    @FXML
    void clickAgregarPrestamo(ActionEvent event) {

        }

    @FXML
    void clickEliminarMiembro(ActionEvent event) {

        }

    @FXML
    void clickFinalizarPrestamo(ActionEvent event) {

        }

    @FXML
    void clickInspeccionarMiembro(ActionEvent event) {
    }

    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.biblioteca = inicializarDatos();
        miembros = FXCollections.observableArrayList();
        this.columnaNombreMiembro.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columnaIdMiembro.setCellValueFactory(new PropertyValueFactory<>("IdMiembro"));

        prestamos = FXCollections.observableArrayList();
        this.columnaFechaPrestamo.setCellValueFactory(new PropertyValueFactory<>("fechaPrestamo"));
        this.columnaFechaDevolucion.setCellValueFactory(new PropertyValueFactory<>("fechaDevolucion"));
        this.columnaId.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMiembro().getIdMiembro()));
        this.columnaMaterial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibro().getTitulo()));
        this.columnaNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMiembro().getNombre()));

        for (Miembro miembro : this.biblioteca.getListaMiembros()) {
            if (!this.miembros.contains(miembro)) {
                this.miembros.add(miembro);
                this.tablaMiembros.setItems(miembros);
            }
        }
        for (Prestamo prestamo : this.biblioteca.getListaPrestamos()) {
            if (!this.prestamos.contains(prestamo)) {
                this.prestamos.add(prestamo);
                this.tablaPrestamos.setItems(prestamos);
            }
        }
    }
    /**
     * Metodo para inicializar una biblioteca con datos quemados
     * @return biblioteca
     */
    private Biblioteca inicializarDatos(){
        Biblioteca biblioteca = new Biblioteca("Biblioteca prueba");
        Bibliotecario bibliotecario1 = new Bibliotecario("Julian",22,"1010","01",8);
        Bibliotecario bibliotecario2 = new Bibliotecario("Laura",25,"2020","02",8);
        Miembro miembro1 = new Miembro("Carlos", "01");
        Miembro miembro2 = new Miembro("Gustavo", "02");
        Miembro miembro3 = new Miembro("Juana", "03");
        Miembro miembro4 = new Miembro("Patricia", "04");
        Miembro miembro5 = new Miembro("Romero", "05");
        Libro libro1 = new Libro("Titulo1", "Autor1",111,true);
        Libro libro2 = new Libro("Titulo2", "Autor2",222,true);
        Libro libro3 = new Libro("Titulo3", "Autor3",333,true);
        Libro libro4 = new Libro("Titulo4", "Autor4",444,true);
        Libro libro5 = new Libro("Titulo5", "Autor5",555,true);
        Libro libro6 = new Libro("Titulo6", "Autor6",666,true);
        Libro libro7 = new Libro("Titulo7", "Autor7",777,true);
        Libro libro8 = new Libro("Titulo8", "Autor8",888,true);
        Prestamo prestamo1 = new Prestamo(LocalDate.of(2024,8,27), LocalDate.of(2024,8,29));
        Prestamo prestamo2 = new Prestamo(LocalDate.of(2024,8,28), LocalDate.of(2024,8,30));
        Prestamo prestamo3 = new Prestamo(LocalDate.of(2024,8,29), LocalDate.of(2024,8,31));
        Prestamo prestamo4 = new Prestamo(LocalDate.of(2024,8,30), LocalDate.of(2024,9,1));
        prestamo1.asociarLibro(libro1);
        prestamo1.asociarMiembro(miembro1);
        prestamo2.asociarLibro(libro2);
        prestamo2.asociarMiembro(miembro2);
        prestamo3.asociarLibro(libro3);
        prestamo3.asociarMiembro(miembro3);
        prestamo4.asociarLibro(libro4);
        prestamo4.asociarMiembro(miembro4);
        List<Object> parametros = Arrays.asList(bibliotecario1,bibliotecario2,miembro1,miembro2,miembro3,miembro4,miembro5,libro1,libro2,libro3,libro4,libro5,libro6,libro7,libro8,prestamo1,prestamo2,prestamo3,prestamo4);
        parametros.forEach(biblioteca::agregarAutomatico);
        return biblioteca;
    }
}


