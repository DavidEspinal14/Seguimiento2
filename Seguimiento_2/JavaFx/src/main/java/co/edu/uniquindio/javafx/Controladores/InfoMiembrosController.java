package co.edu.uniquindio.javafx.Controladores;
import co.edu.uniquindio.javafx.Miembro;
import co.edu.uniquindio.javafx.Prestamo;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class InfoMiembrosController implements Initializable {

    @FXML
    private TableColumn<Prestamo, String> colAutor;

    @FXML
    private TableColumn<?, ?> colFechaDevolucion;

    @FXML
    private TableColumn<?, ?> colFechaPrestamo;

    @FXML
    private TableColumn<Prestamo, Integer> colIsbn;

    @FXML
    private TableView<Prestamo> tablaPrestamosMiembro;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;

    private ObservableList<Prestamo> prestamos;

    private Miembro miembro;

    /**
     * Metodo para inicializar las tablas de los prestamos que tiene cada miembro
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prestamos = FXCollections.observableArrayList();

        colFechaPrestamo.setCellValueFactory(new PropertyValueFactory<>("fechaPrestamo"));
        colFechaDevolucion.setCellValueFactory(new PropertyValueFactory<>("fechaDevolucion"));
        colAutor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getLibro().getAutor()));
        colIsbn.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getLibro().getISBN()));
    }

    /**
     * Metodo para llenar la tabla de los prestamos de un miembro
     * @param miembro
     */
    public void initAttributes(Miembro miembro){
        this.miembro = miembro;

        if (this.miembro.getPrestamos() != null) {
            for (Prestamo prestamo : this.miembro.getPrestamos()) {
                if (!this.prestamos.contains(prestamo)) {
                    this.prestamos.add(prestamo);
                    tablaPrestamosMiembro.setItems(prestamos);
                }
            }
        }

        txtNombre.setText(this.miembro.getNombre());
        txtId.setText(this.miembro.getIdMiembro());

    }

    /**
     * Seccion Gets y Sets
     * @return
     */
    public Miembro getMiembro() {
        return miembro;
    }
    public void setMiembro(Miembro miembro) {
        this.miembro = miembro;
    }
}

