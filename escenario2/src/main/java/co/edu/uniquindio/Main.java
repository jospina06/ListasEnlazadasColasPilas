package co.edu.uniquindio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ListaDoble<String> historial = new ListaDoble<>();
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        System.out.println("======================================");
        System.out.println("      SIMULADOR DE NAVEGADOR WEB      ");
        System.out.println("======================================");

        do {
            System.out.println("\n--- Pestaña Actual: " + 
                    (historial.getPaginaActual() != null ? historial.getPaginaActual() : "Ninguna (Página de inicio)") + " ---");
            System.out.println("1.  Visitar nueva página (URL)");
            System.out.println("2. <- Atrás (Retroceder)");
            System.out.println("3. -> Adelante (Avanzar)");
            System.out.println("4.  Mostrar todo el historial");
            System.out.println("5.  Buscar si una página está en el historial");
            System.out.println("6.  Eliminar una página del historial");
            System.out.println("7.  Salir");
            System.out.print("Elige una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println(" Por favor, ingresa un número.");
                scanner.nextLine(); 
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa la URL (ej. www.google.com): ");
                    String url = scanner.nextLine();
                    historial.agregar(url);
                    System.out.println(" Cargando " + url + "...");
                    break;

                case 2:
                    System.out.println("Navegando hacia atrás...");
                    historial.retroceder();
                    break;

                case 3:
                    System.out.println("Navegando hacia adelante...");
                    historial.avanzar();
                    break;

                case 4:
                    historial.mostrar();
                    break;

                case 5:
                    if (historial.esVacia()) {
                        System.out.println(" Historial vacío.");
                    } else {
                        System.out.print("Ingresa la URL a buscar: ");
                        String urlBusqueda = scanner.nextLine();
                        if (historial.buscar(urlBusqueda)) {
                            System.out.println(" La página " + urlBusqueda + " SÍ está en tu historial.");
                        } else {
                            System.out.println(" No se encontró " + urlBusqueda + ".");
                        }
                    }
                    break;

                case 6:
                    if (historial.esVacia()) {
                        System.out.println(" Historial vacío.");
                    } else {
                        System.out.print("Ingresa la URL exacta que deseas eliminar: ");
                        String urlEliminar = scanner.nextLine();
                        historial.eliminar(urlEliminar);
                        System.out.println(" Acción completada. (Si la URL existía, fue eliminada)");
                    }
                    break;

                case 7:
                    System.out.println("Cerrando el navegador... ¡Hasta luego!");
                    break;

                default:
                    System.out.println(" Opción no válida.");
            }

        } while (opcion != 7);

        scanner.close();
    }
}