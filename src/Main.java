import java.util.Random;
import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
public class Main {
    static int jugador = 0;
    static int maquina = 0;
    static String mensajeJugador = "Las cartas del jugador son: ";
    static String mensajeMaquina = "Las cartas de la máquina son: ";
    static int[] cartas = new int[52];
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        crearMazo();
        System.out.println("BIENVENIDO JUGADOR");
        plusCard(true); // Dar carta al jugador
        plusCard(true); // Dar otra carta al jugador
        plusCard(false); // Dar carta a la máquina
        plusCard(false); // Dar otra carta a la máquina
        mostrarInicioJuego();
        addCard();
        seeMachineCards();
        System.out.println("Que tenga buen día Sr/Sra");
    }

    public static void crearMazo() {
        int valorCarta = 2;
        int contadorCartas = 0;
        for (int figura = 1; figura <= 4; figura++) {
            for (int carta = 1; carta <= 13; carta++) {
                switch (carta) {
                    case 10:
                    case 11:
                    case 12:
                        valorCarta = 10;
                        break;
                    case 13:
                        valorCarta = 11;
                        break;
                    default:
                        break;
                }
                cartas[contadorCartas] = valorCarta;
                contadorCartas++;
                valorCarta++;
            }
            valorCarta = 2;
        }
    }

    public static int drawCard() {
        int carta = random.nextInt(52);
        return cartas[carta];
    }

    public static void plusCard(boolean turnoJugador) {
        int carta = drawCard();
        if (turnoJugador) {
            jugador += carta;
            mensajeJugador += " " + carta;
        } else {
            maquina += carta;
            mensajeMaquina += " " + carta;
        }
    }

    public static void mostrarInicioJuego() {
        System.out.println(mensajeJugador);
        System.out.println(mensajeMaquina);
    }

    public static void addCard() {
        while (jugador < 21) {
            System.out.println("¿Deseas otra carta? (S/N)");
            char respuesta = scanner.next().charAt(0);
            if (respuesta == 'S' || respuesta == 's') {
                plusCard(true);
                System.out.println(mensajeJugador);
                if (jugador > 21) {
                    System.out.println("Has perdido, tu puntaje es mayor a 21");
                    break;
                } else if (jugador == 21) {
                    System.out.println("¡FELICIDADES, HAS GANADO! BLACKJACK!");
                    break;
                }
            } else {
                break;
            }
        }
    }

    public static void seeMachineCards() {
        if (jugador <= 21) {
            System.out.println(mensajeMaquina);
            if (maquina > jugador) {
                System.out.println("LA MÁQUINA HA GANADO");
            } else if (jugador > maquina) {
                System.out.println("EL JUGADOR HA GANADO");
            } else {
                System.out.println("¡EMPATE!");
            }
        }


    }
}