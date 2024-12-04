public class Jugador {

    private String nombre;
    private int puntuacion;
    private String simbolo;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntuacion = 0;
        this.simbolo = "";
    }

    public Jugador(Jugador maquina) {
        this.nombre = "Máquina";
        this.puntuacion = 0;
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