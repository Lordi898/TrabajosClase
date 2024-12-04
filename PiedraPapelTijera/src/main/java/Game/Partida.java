package Game;

import Player.Jugador;
import java.util.Random;
import java.util.Scanner;

public class Partida {
    private Jugador jugador1;
    private Jugador maquina;

    public Partida(String nombreJugador) {
        jugador1 = new Jugador(nombreJugador);
        maquina = new Jugador("maquina");
    }

    public Jugador getJugador() {
        return jugador1;
    }

    public Jugador getMaquina() {
        return maquina;
    }

    public void iniciarJuego() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creando partida...");

        while (jugador1.getPuntuacion() < 3 && maquina.getPuntuacion() < 3) {
            ronda(scanner);
        }

        mostrarGanador();
    }

    private void ronda(Scanner scanner) {
        System.out.println("Elija piedra, papel o tijeras");
        System.out.println("- 1 Piedra");
        System.out.println("- 2 Papel");
        System.out.println("- 3 Tijeras");

        int eleccionJugador = scanner.nextInt();
        String simboloJugador = mapearSimbolo(eleccionJugador);

        if (simboloJugador.equals("Valor elegido incorrecto")) {
            System.out.println(simboloJugador);
            mostrarPuntuacion();
            return;
        }
    }

    jugador.setSimbolo(simboloJugador);
    int eleccionMaquina = new Random().nextInt(3) + 1;
    String simboloMaquina = mapearSimbolo(eleccionMaquina);
    maquina.setSimbolo(simboloMaquina);

    System.out.println(jugador.getNombre() + " muestra " + simboloJugador);
        System.out.println("Máquina muestra " + simboloMaquina);

    calcularGanador(simboloJugador, simboloMaquina);
    mostrarPuntuacion();
}

private void calcularGanador() {
    if (simboloJugador.equals(simboloMaquina)) {
        System.out.println("Empate en esta ronda");
    }

    if ((simboloJugador.equals("piedra") && simboloMaquina.equals("tijera")) ||
        (simboloJugador.equals("tijera") && simboloMaquina.equals("papel")) ||
        (simboloJugador.equals("papel") && simboloMaquina.equals("piedra"))) {
            jugador.setPuntuacion(jugador.getPuntuacion() + 1);
            System.out.println("Gana " + jugador.getNombre() + " esta ronda.");
    }

    else {
        maquina.setPuntuacion(maquina.getPuntuacion() + 1);
        System.out.println("La Maquina gana esta ronda");
    }
}

@org.jetbrains.annotations.NotNull
@org.jetbrains.annotations.Contract(pure = true)
@org.jetbrains.annotations.NotNull
@org.jetbrains.annotations.Contract(pure = true)
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

private void mostrarPuntuacion() {
    System.out.println("***************************************************");
    System.out.println("PUNTUACIÓN");
    System.out.println("Puntuación " + jugador.getNombre() + ": " + jugador.getPuntuacion());
    System.out.println("Puntuación Máquina: " + maquina.getPuntuacion());
    System.out.println("***************************************************");
}

private void mostrarGanador() {
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    System.out.println("Fin de la partida...");
    if (jugador.getPuntuacion() > maquina.getPuntuacion()) {
        System.out.println("Jugador ganador: " + jugador.getNombre());
    } else {
        System.out.println("Jugador ganador: Máquina");
    }
    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
}

