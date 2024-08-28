package co.edu.uniquindio.javafx.Controladores;
import co.edu.uniquindio.javafx.Miembro;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AgregarMiembroController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private Button btnGuardar;
    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNombre;
    private Miembro miembro;

    /**
     * Metodo para crear un nuevo miembro al dar click en el boton guardar
     * @param event
     */
    @FXML
    void clickGuardar(ActionEvent event) {
        String nombre = txtNombre.getText();
        String id = txtId.getText();

        Miembro m = new Miembro(nombre, id);

        this.miembro = m;

        Stage stage = (Stage) btnGuardar.getScene().getWindow();
        stage.close();
    }

    /**
     * Seccion Gets y sets
     * @return
     */
    public Miembro getMiembro() {
        return miembro;
    }
}
