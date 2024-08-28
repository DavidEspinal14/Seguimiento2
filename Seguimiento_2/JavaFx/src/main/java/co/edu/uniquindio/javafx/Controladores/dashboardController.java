package co.edu.uniquindio.javafx.Controladores;

import co.edu.uniquindio.javafx.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TableColumn;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
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

    /**
     * Metodo para cambiar de vista a Miembros
     * @param event
     */
    @FXML
    void clickMiembros(ActionEvent event) {
        menuPrestamos.setVisible(false);
        menuMiembros.setVisible(true);

    }

    /**
     * Metodo para cambiar de vista a Prestamos
     * @param event
     */
    @FXML
    void clickPrestamos(ActionEvent event) {
        menuMiembros.setVisible(false);
        menuPrestamos.setVisible(true);

    }

    /**
     * Metodo para agregar un miembro cuando se da click en el boton de agregar
     * @param event
     * @throws IOException
     */
    @FXML
    void clickAgregarMiembro(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/javafx/agregar-miembro.fxml"));
        Parent root = loader.load();
        AgregarMiembroController controlador = loader.getController();
        Scene scene = new Scene(root,400,500);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

        Miembro m = controlador.getMiembro();

        if (m!=null) {
            biblioteca.agregarAutomatico(m);
            this.miembros.add(m);
            this.tablaMiembros.refresh();
        }

    }

    /**
     * Metodo para agregar un prestamo cuando se da click en el boton
     * @param event
     * @throws IOException
     */
    @FXML
    void clickAgregarPrestamo(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/javafx/agregar-prestamo.fxml"));
        Parent root = loader.load();
        AgregarPrestamoController controlador = loader.getController();
        controlador.initAtributtes(biblioteca);
        Scene scene = new Scene(root,400,500);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();

        Prestamo pres = controlador.getPrestamo();
        if (pres!=null) {
            biblioteca.agregarAutomatico(pres);
            prestamos.add(pres);
            this.tablaPrestamos.refresh();
        }

    }

    /**
     * Metodo para eliminar un miembro de la biblioteca
     * @param event
     */
    @FXML
    void clickEliminarMiembro(ActionEvent event) {
        Miembro m = tablaMiembros.getSelectionModel().getSelectedItem();
        if (m!=null) {
            biblioteca.eliminarAutomatico(m);
            this.miembros.remove(m);
            this.tablaMiembros.refresh();
        }

    }

    /**
     * Metodo para eliminar un prestamo de la biblioteca
     * @param event
     */
    @FXML
    void clickFinalizarPrestamo(ActionEvent event) {
        Prestamo m = this.tablaPrestamos.getSelectionModel().getSelectedItem();
        if (m!=null) {
            prestamos.remove(m);
            this.tablaPrestamos.refresh();
        }
    }

    /**
     * metodo para inspeccionar un miembro de la lista de miembros
     * @param event
     * @throws IOException
     */
    @FXML
    void clickInspeccionarMiembro(ActionEvent event) throws IOException {
        Miembro m = this.tablaMiembros.getSelectionModel().getSelectedItem();
        if (m != null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/javafx/info-miembro.fxml"));
            Parent root = loader.load();
            InfoMiembrosController controlador = loader.getController();
            controlador.initAttributes(m);
            Scene scene = new Scene(root,400,500);
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
        }
    }

    /**
     * Metodo para inicializar las tablas y columnas con datos quemados
     * @param url
     * @param resourceBundle
     */
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
    /**
     * Seccion Gets y Sets
     */
    public Biblioteca getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }
}


