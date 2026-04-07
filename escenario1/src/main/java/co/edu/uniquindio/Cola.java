package co.edu.uniquindio;

public class Cola<T> {

    protected Nodo<T> inicio;
    protected Nodo<T> fin;
    protected int tam;

    public Cola() {
        inicio = null;
        fin = null;
        tam = 0;
    }

    // Agregar Final (Registrar nuevo cliente)
    public void agregar(T valor) {
        Nodo<T> newElement = new Nodo<>(valor);
        if (inicio == null && fin == null && tam == 0) {
            inicio = newElement;
            fin = newElement;
        } else {
            fin.setProximo(newElement);
            fin = newElement;
        }
        tam++;
    }

    // Quitar Inicio (Atender al cliente)
    public void eliminar() {
        if (!(inicio == null && fin == null && tam == 0)) {
            inicio = inicio.getProximo();
            tam--;
            // Si la cola se vacía, debemos asegurar que fin también sea null
            if (inicio == null) {
                fin = null;
            }
        }
    }

    // Buscar (Saber si un cliente específico está en la fila)
    public boolean buscar(T valor) {
        Nodo<T> actual = inicio;
        while (actual != null) {
            if (actual.getValor().equals(valor)) {
                return true; // Se encontró el elemento
            }
            actual = actual.getProximo();
        }
        return false; // No se encontró
    }

    // Mostrar (Ver la lista actual de turnos)
    public void mostrar() {
        if (isVacia()) {
            System.out.println("La fila está vacía. No hay clientes por atender.");
            return;
        }
        
        Nodo<T> actual = inicio;
        System.out.print("Fila actual: ");
        while (actual != null) {
            System.out.print("[" + actual.getValor() + "] -> ");
            actual = actual.getProximo();
        }
        System.out.println("Final de la fila");
    }

    // Is Vacia
    public boolean isVacia() {
        return (inicio == null && fin == null && tam == 0);
    }

    // Ver Inicio (Consultar quién es el siguiente)
    public T obtenerInicio() {
        if (isVacia()) {
            return null; // O lanzar una excepción si se prefiere
        }
        return inicio.getValor();
    }
}