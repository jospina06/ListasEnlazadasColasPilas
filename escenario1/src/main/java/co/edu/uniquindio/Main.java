package co.edu.uniquindio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Cola<String> turnosPanaderia = new Cola<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("======================================");
        System.out.println("      BIENVENIDO A LA PANADERÍA       ");
        System.out.println("======================================");

        do {
            System.out.println("\n--- MENÚ DE TURNOS ---");
            System.out.println("1. Registrar nuevo cliente (Llegada)");
            System.out.println("2. Atender al siguiente cliente");
            System.out.println("3. Consultar quién es el siguiente");
            System.out.println("4. Ver toda la fila actual");
            System.out.println("5. Buscar un cliente en específico");
            System.out.println("6. Salir del sistema");
            System.out.print("Elige una opción: ");
        

            // Validación básica para evitar que el programa se caiga si meten letras
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada
            } else {
                System.out.println(" Por favor, ingresa un número válido.");
                scanner.nextLine(); // Limpiar el buffer de entrada
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el nombre del cliente: ");
                    String nombreCliente = scanner.nextLine();
                    turnosPanaderia.agregar(nombreCliente);
                    System.out.println(" El cliente '" + nombreCliente + "' ha sido registrado al final de la fila.");
                    break;

                case 2:
                    if (turnosPanaderia.isVacia()) {
                        System.out.println(" No hay clientes en la fila para atender.");
                    } else {
                        String atendido = turnosPanaderia.obtenerInicio();
                        turnosPanaderia.eliminar();
                        System.out.println(" Atendiendo a: " + atendido + ". (Ha salido de la fila)");
                    }
                    break;

                case 3:
                    if (turnosPanaderia.isVacia()) {
                        System.out.println(" La fila está vacía. No hay siguiente cliente.");
                    } else {
                        System.out.println(" El siguiente cliente en ser atendido es: " + turnosPanaderia.obtenerInicio());
                    }
                    break;

                case 4:
                    System.out.println(" Estado actual de la fila:");
                    turnosPanaderia.mostrar();
                    break;

                case 5:
                    if (turnosPanaderia.isVacia()) {
                        System.out.println(" La fila está vacía, no hay a quién buscar.");
                    } else {
                        System.out.print("Ingresa el nombre del cliente a buscar: ");
                        String clienteBuscado = scanner.nextLine();
                        if (turnosPanaderia.buscar(clienteBuscado)) {
                            System.out.println(" Sí, el cliente '" + clienteBuscado + "' está actualmente en la fila.");
                        } else {
                            System.out.println(" El cliente '" + clienteBuscado + "' no se encuentra en la fila.");
                        }
                    }
                    break;

                case 6:
                    System.out.println("Cerrando el sistema de la panadería... ¡Hasta luego! ");
                    break;

                default:
                    System.out.println(" Opción no válida. Por favor, intenta de nuevo.");
            }

        } while (opcion != 6);

        scanner.close();
    }
}