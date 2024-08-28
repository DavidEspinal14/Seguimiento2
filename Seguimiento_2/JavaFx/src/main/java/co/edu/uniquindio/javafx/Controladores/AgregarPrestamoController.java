package co.edu.uniquindio.javafx.Controladores;

import co.edu.uniquindio.javafx.Biblioteca;
import co.edu.uniquindio.javafx.Libro;
import co.edu.uniquindio.javafx.Miembro;
import co.edu.uniquindio.javafx.Prestamo;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class AgregarPrestamoController {

    @FXML
    private ComboBox<Libro> boxLibro;

    @FXML
    private ComboBox<Miembro> boxMiembro;

    @FXML
    private Button btnGuardar;

    private Biblioteca biblioteca;
    private Prestamo prestamo;

    @FXML
    void clickGuardar(ActionEvent event) {
        Libro l = boxLibro.getSelectionModel().getSelectedItem();
        Miembro m = boxMiembro.getSelectionModel().getSelectedItem();
        Prestamo p = new Prestamo(LocalDate.now(),LocalDate.now().plusDays(3));
        p.asociarMiembro(m);
        p.asociarLibro(l);
        this.prestamo = p;
        Stage stage = (Stage) btnGuardar.getScene().getWindow();
        stage.close();
    }
    public void initAtributtes(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
        boxLibro.setItems(FXCollections.observableArrayList(biblioteca.getListalibros()));
        boxMiembro.setItems(FXCollections.observableArrayList(biblioteca.getListaMiembros()));

        boxLibro.setCellFactory(lv -> new ListCell<Libro>(){
            @Override
            protected void updateItem(Libro item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getTitulo()+" -- "+item.getISBN());
            }
        });

        boxMiembro.setCellFactory(lv -> new ListCell<Miembro>(){
            @Override
            protected void updateItem(Miembro item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getNombre()+" -- "+item.getIdMiembro());
            }
        });
        boxLibro.setButtonCell(boxLibro.getCellFactory().call(null));
        boxMiembro.setButtonCell(boxMiembro.getCellFactory().call(null));
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }
}

