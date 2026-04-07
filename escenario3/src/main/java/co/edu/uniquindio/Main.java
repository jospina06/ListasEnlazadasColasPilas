package co.edu.uniquindio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaSimpleCircular<Cancion> listaReproduccion = new ListaSimpleCircular<>();
        Scanner scanner = new Scanner(System.in);
        int opcion; 

        System.out.println("----------- Lista de Reproducción -----------");

        do {
            System.out.println("\n===== REPRODUCTOR DE MÚSICA =====");
            System.out.println("1. Agregar canción al final");
            System.out.println("2. Agregar canción al inicio");
            System.out.println("3. Mostrar canción actual");
            System.out.println("4. Pasar a la siguiente canción");
            System.out.println("5. Eliminar canción por título");
            System.out.println("6. Mostrar lista completa");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.print("Título: ");
                    String tituloF = scanner.nextLine();
                    System.out.print("Duración: ");
                    int duracionF = scanner.nextInt();
                    scanner.nextLine();

                    listaReproduccion.insertarFinal(new Cancion(tituloF, duracionF));
                    System.out.println("Canción agregada al final.");
                    break;

                case 2:
                    System.out.print("Título: ");
                    String tituloI = scanner.nextLine();
                    System.out.print("Duración: ");
                    int duracionI = scanner.nextInt();
                    scanner.nextLine();

                    listaReproduccion.insertarInicio(new Cancion(tituloI, duracionI));
                    System.out.println("Canción agregada al inicio.");
                    break;

                case 3:
                    if (listaReproduccion.esVacia()) {
                        System.out.println("No hay canciones.");
                    } else {
                        listaReproduccion.reproducirActual();
                    }
                    break;

                case 4:
                    if (listaReproduccion.esVacia()) {
                        System.out.println("No hay canciones.");
                    } else {
                        Cancion sig = listaReproduccion.pasarSiguiente();
                        if (sig == null) {
                            System.out.println("No hay referencia actual.");
                        } else {
                            System.out.println("Siguiente: " + sig);
                        }
                    }
                    break;

                case 5:
                    if (listaReproduccion.esVacia()) {
                        System.out.println("Lista vacía.");
                    } else {
                        System.out.print("Ingrese título a eliminar: ");
                        String tituloEliminar = scanner.nextLine();

                        listaReproduccion.eliminar(new Cancion(tituloEliminar, 0));
                    }
                    break;

                case 6:
                    System.out.println(listaReproduccion);
                    break;

                case 7:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 7);

        scanner.close();
    }
}