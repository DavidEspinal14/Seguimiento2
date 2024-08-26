package co.edu.uniquindio.javafx.Controladores;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class InicioController {
    @FXML
    private Button nuevoBtn;

    @FXML
    private Button pruebBtn;

    @FXML
    void clickNuevoBtn(ActionEvent event) {
        System.out.println("Prueba2");
    }

    @FXML
    void clickPrueba(ActionEvent event) {
        System.out.println("Prueba");
    }

}
