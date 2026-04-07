package co.edu.uniquindio;

public class ListaDoble<T> {
    private NodoDoble<T> inicial;
    private NodoDoble<T> actual; 
    private int tam;

    public ListaDoble() {
        inicial = null;
        actual = null;
        tam = 0;
    }

    public void agregar(T valor) {
        NodoDoble<T> nuevo = new NodoDoble<>(valor);

        if (inicial == null) {
            inicial = nuevo;
            actual = nuevo;
            tam = 1;
        } else {
            if (actual.getSiguiente() != null) {
                NodoDoble<T> tempo = actual.getSiguiente();
                while (tempo != null) {
                    tam--;
                    tempo = tempo.getSiguiente();
                }
                actual.setSiguiente(null);
            }

            actual.setSiguiente(nuevo);
            nuevo.setAnterior(actual);
            actual = nuevo;
            tam++;
        }
    }

    public void retroceder() {
        if (actual != null && actual.getAnterior() != null) {
            actual = actual.getAnterior();
        } else {
            System.out.println("No hay páginas anteriores. Ya estás en el inicio.");
        }
    }

    public void avanzar() {
        if (actual != null && actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        } else {
            System.out.println("No hay páginas hacia adelante.");
        }
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("El historial está vacío.");
            return;
        }

        NodoDoble<T> tempo = inicial;
        System.out.print("Historial: ");
        while (tempo != null) {
            if (tempo == actual) {
                System.out.print("[  " + tempo.getValor() + " ] <-> ");
            } else {
                System.out.print(tempo.getValor() + " <-> ");
            }
            tempo = tempo.getSiguiente();
        }
        System.out.println("FIN");
    }

    public boolean buscar(T valor) {
        NodoDoble<T> tempo = inicial;
        while (tempo != null) {
            if (tempo.getValor().equals(valor)) {
                return true;
            }
            tempo = tempo.getSiguiente();
        }
        return false;
    }

    public void eliminar(T valor) {
        if (esVacia()) return;

        NodoDoble<T> tempo = inicial;

        while (tempo != null) {
            if (tempo.getValor().equals(valor)) {
                if (tempo == inicial && tempo.getSiguiente() == null) {
                    inicial = null;
                    actual = null;
                }
                else if (tempo == inicial) {
                    inicial = inicial.getSiguiente();
                    inicial.setAnterior(null);
                    if (actual == tempo) actual = inicial;
                }
                else if (tempo.getSiguiente() == null) {
                    tempo.getAnterior().setSiguiente(null);
                    if (actual == tempo) actual = tempo.getAnterior();
                }
                else {
                    tempo.getAnterior().setSiguiente(tempo.getSiguiente());
                    tempo.getSiguiente().setAnterior(tempo.getAnterior());
                    if (actual == tempo) actual = tempo.getAnterior();
                }
                tam--;
                return;
            }
            tempo = tempo.getSiguiente();
        }
    }

    public boolean esVacia() {
        return inicial == null;
    }

    public T getPaginaActual() {
        return (actual != null) ? actual.getValor() : null;
    }
}