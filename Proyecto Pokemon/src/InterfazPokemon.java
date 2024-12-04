import java.util.Scanner;

public class InterfazPokemon {
    private Scanner teclado;

    // Constructor
    public InterfazPokemon() {
        this.teclado = new Scanner(System.in);
    }

    // Método Juego: Gestiona el flujo completo del juego.
    public void Juego() {
        System.out.println("¡Bienvenido al Juego de Pokémon!");

        // Crear Pokémon del jugador
        Pokemon pokemonJugador = menuCreacionPokemonJugador();

        // Inicia las partidas contra 3 rivales
        for (int i = 1; i <= 3; i++) {
            System.out.println("PULSE ENTER PARA CONTINUAR...");
            teclado.nextLine();
            System.out.println("Te enfrentarás al rival número " + i);
            System.out.println("Presentación del pokemon oponente: ");
            System.out.println("Nombre: " + siguientePokemonRival(i).getNombre());
            System.out.println("Tipo: " + siguientePokemonRival(i).getTipo());
            System.out.println("Nivel: " + siguientePokemonRival(i).getNivel());
            System.out.println("Aguante: " + siguientePokemonRival(i).getAguante());
            Pokemon pokemonRival = siguientePokemonRival(i);
            System.out.println("PULSE ENTER PARA CONTINUAR...");
            teclado.nextLine();

            // Crear y ejecutar una partida
            Pokemon ganador = Partida(pokemonJugador, pokemonRival);

            if (ganador == pokemonJugador) {
                System.out.println("¡Has ganado el combate contra " + pokemonRival.getNombre() + "!");
                if (i < 3) {
                    pokemonJugador.subirNivel();
                    System.out.println("¡Tu Pokémon ha subido de nivel! Nivel actual: " + pokemonJugador.getNivel());
                } else {
                    mostrarJuegoSuperado();
                    return;
                }
            } else {
                mostrarFinPartida();
                return;
            }
        }
    }

    // Método Partida: Gestiona un combate completo entre dos Pokémon.
    public Pokemon Partida(Pokemon pokemonJugador, Pokemon pokemonRival) {
        Combate combate = new Combate(pokemonJugador, pokemonRival);

        System.out.println("¡Que comience el combate!");
        while (combate.Ganador() == null) {
            combate.Ronda();
        }

        return combate.Ganador();
    }

    // Menú para la creación del Pokémon del jugador.
    public Pokemon menuCreacionPokemonJugador() {
        System.out.println("........................");
        System.out.println("Crea tu Pokémon......");
        System.out.println("........................");

        System.out.print("Introduce un nombre: ");
        String nombre = teclado.nextLine();

        String tipo = "";
        while (true) {
            System.out.println("Elige su tipo: ");
            System.out.println("1.- Agua");
            System.out.println("2.- Tierra");
            System.out.println("3.- Fuego");
            int opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar buffer
            if (opcion == 1) {
                tipo = "agua";
                break;
            } else if (opcion == 2) {
                tipo = "tierra";
                break;
            } else if (opcion == 3) {
                tipo = "fuego";
                break;
            } else {
                System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }

        return new Pokemon(nombre, tipo);
    }

    // Selecciona el Pokémon rival basado en el número de combate.
    public Pokemon siguientePokemonRival(int numero) {
        return switch (numero) {
            case 1 -> new Pokemon("Caterpie", "tierra", 1);
            case 2 -> new Pokemon("Bulbasaur", "agua", 2);
            case 3 -> new Pokemon("Charmander", "fuego", 3);
            default -> null;
        };
    }

    // Mensaje para cuando el jugador gana el juego.
    public void mostrarJuegoSuperado() {
        System.out.println("PULSE ENTER PARA CONTINUAR...");
        teclado.nextLine();
        System.out.println("\033[41m++++++++++ ENHORABUENA +++++++++++\033[0m");
        System.out.println("\033[41m+++++ HAS SUPERADO EL JUEGO ++++++\033[0m");
        System.out.println("\033[41m++++ ERES UN MAESTRO POKEMON +++++\033[0m");
    }

    // Mensaje para cuando el jugador pierde el juego.
    public void mostrarFinPartida() {
        System.out.println("\033[41m++++++++++ LO SIENTO +++++++++++\033[0m");
        System.out.println("\033[41m+++++ HAS SIDO ELIMINADO ++++++\033[0m");
        System.out.println("\033[41m+++++ VUELVE A INTENTARLO ++++++\033[0m");
    }
}
