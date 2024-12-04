import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        String nombre = teclado.nextLine();
        System.out.println("Creando partida...");
        Partida partida = new Partida(nombre);

        boolean hayGanador = false;

        while (!hayGanador) {
            partida.ronda();
            if (partida.getJugador1().getPuntuacion() == 3) {
                hayGanador = true;
                partida.jugadorGanador();
            } else if (partida.getMaquina().getPuntuacion() == 3) {
                hayGanador = true;
                partida.jugadorGanador();
            }
            partida.mostrarPuntuacion();
        }
    }
}