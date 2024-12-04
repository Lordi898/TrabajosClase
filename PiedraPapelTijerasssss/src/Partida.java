import java.util.Random;
import java.util.Scanner;

public class Partida {
    private Jugador jugador1;
    private Jugador maquina;

    public Partida(String nombreJugador) {
        jugador1 = new Jugador(nombreJugador);
        maquina = new Jugador(maquina);
    }

    public Jugador getJugador1() {
        return this.jugador1;
    }

    public Jugador getMaquina() {
        return this.maquina;
    }

    public void ronda() {
        System.out.println("Elija piedra, papel o tijera:");
        System.out.println("- 1 Piedra");
        System.out.println("- 2 Papel");
        System.out.println("- 3 Tijera");

        Scanner teclado = new Scanner(System.in);

        //Jugador Humano
        int numero = teclado.nextInt();
        String simbolo = mapearSimbolo(numero);
        this.jugador1.setSimbolo(simbolo);

        //Jugador Maquina
        numero = (int) (Math.random() * 3) + 1;
        simbolo = mapearSimbolo(numero);
        this.maquina.setSimbolo(simbolo);

        System.out.println(jugador1.getNombre() + "muestra " + jugador1.getSimbolo());
        System.out.println(maquina.getNombre() + "muestra " + maquina.getSimbolo());

        calcularGanador(jugador1.getSimbolo(), maquina.getSimbolo());
    }

    private void calcularGanador(String simboloJugador, String simboloMaquina) {

        int puntMaquinaAux = this.maquina.getPuntuacion();
        int puntJugadorAux = this.jugador1.getPuntuacion();

        if (simboloJugador.equals(simboloMaquina)) {
            System.out.println("Empate en esta ronda");
        }

        if ((simboloJugador.equals("piedra") && simboloMaquina.equals("tijera")) ||
                (simboloJugador.equals("tijera") && simboloMaquina.equals("papel")) ||
                (simboloJugador.equals("papel") && simboloMaquina.equals("piedra"))) {

            this.jugador1.setPuntuacion(puntJugadorAux + 1);
            System.out.println("Gana " + jugador1.getNombre() + " esta ronda.");
        } else {
            this.maquina.setPuntuacion(puntMaquinaAux + 1);
            System.out.println("La Maquina gana esta ronda");
        }
    }

    private String mapearSimbolo(int numero) {
        switch (numero) {
            case 1:
                return "piedra";
            case 2:
                return "papel";
            case 3:
                return "tijera";
            default:
                return "Valor elegido incorrecto";
        }
    }

    public void mostrarPuntuacion() {
        System.out.println("***************************************************");
        System.out.println("PUNTUACIÓN");
        System.out.println("Puntuación " + jugador1.getNombre() + ": " + jugador1.getPuntuacion());
        System.out.println("Puntuación Máquina: " + maquina.getPuntuacion());
        System.out.println("***************************************************");
    }

    public void jugadorGanador() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Fin de la partida...");
        if (jugador1.getPuntuacion() > maquina.getPuntuacion()) {
            System.out.println("Jugador ganador: " + jugador1.getNombre());
        } else {
            System.out.println("Jugador ganador: Máquina");
        }
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
}
