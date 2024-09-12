package co.edu.uniquindio.services;

import co.edu.uniquindio.model.Miembro;

import java.util.ArrayList;
import java.util.List;

public interface ICrudMiembro {
    public boolean crearMiembro(String nombre, String idMiembro);
    public boolean eliminarMiembro(String idMiembro);
    public boolean actualizarMiembro(String nombre, String idMiembro);
    public Miembro getMiembro(String idMiembro);
    public List<Miembro> getMiembros();
}
