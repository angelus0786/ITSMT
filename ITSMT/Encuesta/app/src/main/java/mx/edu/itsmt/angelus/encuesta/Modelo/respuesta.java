package mx.edu.itsmt.angelus.encuesta.Modelo;

/**
 * Created by angelus on 24/06/2017.
 */

public class respuesta {

    int id;
    int idPregunta;
    int respuesta;

    public respuesta(int id, int idPregunta, int respuesta) {
        this.id = id;
        this.idPregunta = idPregunta;
        this.respuesta = respuesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }
}
