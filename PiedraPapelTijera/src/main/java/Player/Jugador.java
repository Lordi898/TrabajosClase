package Player;

public class Jugador {

    private String nombre;
    private int puntuacion;
    private String simbolo;

    public Jugador(String nombreJugador) {
        this.nombre = nombre;
        this.puntuacion = 0;
        this.simbolo = "";
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
