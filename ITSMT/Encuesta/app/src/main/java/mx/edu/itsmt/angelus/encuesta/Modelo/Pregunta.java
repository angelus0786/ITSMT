package mx.edu.itsmt.angelus.encuesta.Modelo;

import java.io.Serializable;

/**
 * Created by angelus on 24/06/2017.
 */

public class Pregunta implements Serializable {
     int idPregunta;
     String pregunta;
     int valor;
     int respuesta;
     int imagen;
     String img;

    public Pregunta() {

   }

    public Pregunta(int idPregunta, String pregunta, int valor, int respuesta) {
        this.idPregunta = idPregunta;
        this.pregunta = pregunta;
        this.valor = valor;
        this.respuesta = respuesta;
    }
    public Pregunta(int idPregunta, String pregunta, int imagen) {
        this.idPregunta = idPregunta;
        this.pregunta = pregunta;
        this.imagen = imagen;
    }

    public Pregunta(int idPregunta, String pregunta, String imagen) {
        this.idPregunta = idPregunta;
        this.pregunta = pregunta;
        this.img = imagen;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
