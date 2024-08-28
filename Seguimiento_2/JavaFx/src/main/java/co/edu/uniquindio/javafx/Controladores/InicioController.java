package co.edu.uniquindio.javafx.Controladores;
import co.edu.uniquindio.javafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class InicioController {
    @FXML
    private Button nuevoBtn;

    @FXML
    private Button pruebBtn;

    private Scene scene;
    @FXML
    void clickNuevoBtn(ActionEvent event) throws IOException {
        JOptionPane.showMessageDialog(null, "Aun estamos trabajando en esta funcionalidad");
    }
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Inicio.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    @FXML
    void clickPrueba(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Inicio.class.getResource("dashboard.fxml"));
        Pane ventana = (Pane) loader.load();
        scene = new Scene(ventana);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
