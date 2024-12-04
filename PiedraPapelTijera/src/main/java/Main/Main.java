package Main;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import Game.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserte su nombre: ");
        String nombreJugador = scanner.nextLine();

        Partida partida = new Partida(nombreJugador);
        partida.iniciarJuego();
    }
}