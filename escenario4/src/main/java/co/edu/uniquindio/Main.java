package co.edu.uniquindio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDobleCircular<Jugador> jugadores = new ListaDobleCircular<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n===== JUEGO POR TURNOS =====");
            System.out.println("1. Agregar jugador al final");
            System.out.println("2. Agregar jugador al inicio");
            System.out.println("3. Mostrar jugador actual");
            System.out.println("4. Pasar turno (siguiente)");
            System.out.println("5. Retroceder turno (anterior)");
            System.out.println("6. Ver siguiente jugador");
            System.out.println("7. Ver jugador anterior");
            System.out.println("8. Expulsar jugador");
            System.out.println("9. Mostrar jugadores");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.print("Nombre del jugador: ");
                    String nombreF = scanner.nextLine();
                    jugadores.insertarFinal(new Jugador(nombreF));
                    System.out.println("Jugador agregado al final.");
                    break;

                case 2:
                    System.out.print("Nombre del jugador: ");
                    String nombreI = scanner.nextLine();
                    jugadores.insertarInicio(new Jugador(nombreI));
                    System.out.println("Jugador agregado al inicio.");
                    break;

                case 3:
                    if (jugadores.esVacia()) {
                        System.out.println("No hay jugadores.");
                    } else {
                        System.out.println("Turno actual: " + jugadores.getActual().getValor());
                    }
                    break;

                case 4:
                    if (jugadores.esVacia()) {
                        System.out.println("No hay jugadores.");
                    } else {
                        System.out.println("Siguiente turno: " + jugadores.pasarSiguiente());
                    }
                    break;

                case 5:
                    if (jugadores.esVacia()) {
                        System.out.println("No hay jugadores.");
                    } else {
                        System.out.println("Turno anterior: " + jugadores.pasarAnterior());
                    }
                    break;

                case 6:
                    if (jugadores.esVacia()) {
                        System.out.println("No hay jugadores.");
                    } else {
                        System.out.println("Siguiente jugador: " + jugadores.consultarSiguiente());
                    }
                    break;

                case 7:
                    if (jugadores.esVacia()) {
                        System.out.println("No hay jugadores.");
                    } else {
                        System.out.println("Jugador anterior: " + jugadores.consultarAnterior());
                    }
                    break;

                case 8:
                    if (jugadores.esVacia()) {
                        System.out.println("No hay jugadores.");
                    } else {
                        System.out.print("Nombre del jugador a expulsar: ");
                        String nombreE = scanner.nextLine();
                        jugadores.eliminar(new Jugador(nombreE));
                    }
                    break;

                case 9:
                    System.out.println(jugadores);
                    break;

                case 10:
                    System.out.println("Fin del juego.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 10);

        scanner.close();
    }
}