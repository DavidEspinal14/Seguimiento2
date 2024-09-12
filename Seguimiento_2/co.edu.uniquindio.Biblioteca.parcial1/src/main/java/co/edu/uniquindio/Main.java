package co.edu.uniquindio;

import co.edu.uniquindio.model.Bibliotecario;
import co.edu.uniquindio.model.Empleado;
import co.edu.uniquindio.model.Miembro;
import co.edu.uniquindio.model.builder.BibliotecarioBuilder;
import co.edu.uniquindio.model.builder.EmpleadoBuilder;
import co.edu.uniquindio.model.builder.MiembroBuilder;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ejemplo();
    }
    public static void ejemplo() {
        Empleado empleadoBasico = new EmpleadoBuilder()
                .nombre("Pepe")
                .cedula("1010101")
                .edad(10)
                .idEmpleado("000001")
                .build();

        Bibliotecario bibliotecario = new BibliotecarioBuilder()
                .nombre("Pepe")
                .cedula("1010101")
                .edad(10)
                .idEmpleado("000001")
                .horasdeTrabajo(30)
                .build();
        JOptionPane.showMessageDialog(null, "Bibliotecario: " + bibliotecario.getHorasDeTrabajo() +
                "\n Empleado basico: " + empleadoBasico.getNombre());
    }

}