module co.edu.uniquindio.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires java.desktop;

    opens co.edu.uniquindio.javafx to javafx.fxml;
    exports co.edu.uniquindio.javafx;
    exports co.edu.uniquindio.javafx.Controladores;
    opens co.edu.uniquindio.javafx.Controladores to javafx.fxml;
}