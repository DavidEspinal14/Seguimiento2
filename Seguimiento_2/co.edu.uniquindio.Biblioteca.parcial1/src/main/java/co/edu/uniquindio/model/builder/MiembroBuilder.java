package co.edu.uniquindio.model.builder;

import co.edu.uniquindio.model.Miembro;

public class MiembroBuilder {
    protected String nombre;
    protected String idMiembro;

    public Miembro build(){
        return new Miembro(nombre, idMiembro);
    }

    public MiembroBuilder nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public MiembroBuilder idMiembro(String idMiembro) {
        this.idMiembro = idMiembro;
        return this;
    }
}
