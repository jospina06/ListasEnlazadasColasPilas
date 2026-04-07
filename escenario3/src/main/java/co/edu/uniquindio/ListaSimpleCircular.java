package co.edu.uniquindio;

public class ListaSimpleCircular<T> {
    private Nodo<T> inicial;
    private Nodo<T> actual;
    private int tam; // variable tamano

    public ListaSimpleCircular() {
        inicial = null;
        tam = 0;
    }

    public boolean insertarFinal(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if (inicial == null && tam == 0) {
            inicial = nuevo;
            inicial.setProximo(inicial);
            actual = inicial;
            tam++;
            return true;
        }
        Nodo<T> tempo = inicial;
        while (tempo.getProximo() != inicial) {
            tempo = tempo.getProximo();
        }
        tempo.setProximo(nuevo);
        nuevo.setProximo(inicial);
        tam++;
        return true;

    }

    public void insertarInicio(T valor) {
        Nodo<T> nuevoNodo = new Nodo<>(valor);

        if (tam == 0) {
            inicial = nuevoNodo;
            inicial.setProximo(inicial);
            actual = inicial;
        } else {
            Nodo<T> tempo = inicial;
            while (tempo.getProximo() != inicial) {
                tempo = tempo.getProximo();
            }
            tempo.setProximo(nuevoNodo);
            nuevoNodo.setProximo(inicial);
            inicial = nuevoNodo;
        }
        tam++;
    }

    public void eliminarFinal() {
        if (inicial != null && inicial.getProximo() == inicial && tam == 1) {
            inicial = null;
            tam--;
            return;
        }

        Nodo<T> tempo = inicial;
        while (tempo.getProximo().getProximo() != inicial) {
            tempo = tempo.getProximo();
        }
        tempo.setProximo(inicial);
        tam--;
    }

    public void eliminarInicio() {
        if (tam == 0)
            return;
        if (tam == 1) {
            inicial = null;
        } else {
            Nodo<T> tempo = inicial;
            while (tempo.getProximo() != inicial) {
                tempo = tempo.getProximo();
            }
            tempo.setProximo(inicial.getProximo());
            inicial = inicial.getProximo();
        }
        tam--;
    }

    public void eliminar(T valor) {
        if (tam == 0) {
            System.out.println("La lista está vacía.");
            return;
        }

        Nodo<T> actualNodo = inicial;
        Nodo<T> anterior = null;

        do {
            if (actualNodo.getValor().equals(valor)) {
                // Caso 1: eliminar el primero
                if (actualNodo == inicial) {
                    eliminarInicio();
                    System.out.println("Elemento eliminado (inicio).");
                    return;
                }

                // Caso 2: eliminar el último
                if (actualNodo.getProximo() == inicial) {
                    eliminarFinal();
                    System.out.println("Elemento eliminado (final).");
                    return;
                }

                // Caso 3: nodo intermedio
                anterior.setProximo(actualNodo.getProximo());
                tam--;
                System.out.println("Elemento eliminado (intermedio).");
                return;
            }

            anterior = actualNodo;
            actualNodo = actualNodo.getProximo();
        } while (actualNodo != inicial);
        System.out.println("El elemento no se encontró en la lista.");
    }

    public boolean esVacia() {
        return inicial == null && tam == 0;
    }

    public int localizar(T valor) {
        Nodo<T> tempo = inicial;
        int index = 0;

        do {
            if (tempo.getValor().equals(valor)) {
                return index;
            }
            tempo = tempo.getProximo();
            index++;
        } while (tempo != inicial);

        return -1;
    }

    public T pasarSiguiente() {
        if (actual == null)
            return null;
        actual = actual.getProximo();
        return actual.getValor();
    }

    public void reproducirActual() {
        if (actual == null) {
            System.out.println("No hay canción en reproducción.");
            return;
        }

        Cancion cancion = (Cancion) actual.getValor();
        System.out.println("Reproduciendo: " + cancion.getTitulo());
        try {
            Thread.sleep(cancion.getDuracion() * 1000); 
        } catch (InterruptedException e) {
            System.out.println("Error en la reproducción.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("ListaSimpleCircular: ");
        if (tam == 0) {
            sb.append("vacia");
        } else {
            Nodo<T> temp = inicial;
            for (int i = 0; i < tam; i++) {
                sb.append(temp.getValor()).append("[").append(temp.getProximo().getValor()).append("]");
                if (i < tam - 1)
                    sb.append(" -> ");
                temp = temp.getProximo();
            }
            sb.append(" (circular)");
        }
        return sb.toString();
    }

    public Nodo<T> getInicial() {
        return inicial;
    }

    public void setInicial(Nodo<T> inicial) {
        this.inicial = inicial;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
}