package mx.edu.itsmt.angelus.encuesta.Modelo;

/**
 * Created by angelus on 24/06/2017.
 */

public class TipoPregunta {
    int idTipo;
    String tipo;


    public TipoPregunta(int idTipo, String tipo) {
        this.idTipo = idTipo;
        this.tipo = tipo;
    }

    public int getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(int idTipo) {
        this.idTipo = idTipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
