package co.edu.uniquindio;

public class ListaDobleCircular<T> {
    private Nodo<T> inicial;
    private Nodo<T> actual;
    private int tam;
    
    public ListaDobleCircular() {
        inicial = null; 
        tam = 0;
    }

    public boolean insertarFinal(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if (inicial == null && tam == 0) {
            inicial = nuevo;
            inicial.setProximo(inicial);
            inicial.setAnterior(inicial);
            actual = inicial;
            tam++;
            return true;
        } else{
            Nodo<T> ultimo = inicial.getAnterior();

            ultimo.setProximo(nuevo);
            nuevo.setAnterior(ultimo);

            nuevo.setProximo(inicial);
            inicial.setAnterior(nuevo);
        }
        tam++;
        return true;

    }

    public void insertarInicio(T valor) {
        Nodo<T> nuevo = new Nodo<>(valor);

        if (tam == 0) {
            inicial = nuevo;
            inicial.setProximo(inicial);
            inicial.setAnterior(inicial);
            actual = inicial;
        } else {
            Nodo<T> ultimo = inicial.getAnterior();
            nuevo.setProximo(inicial);
            nuevo.setAnterior(ultimo);
            ultimo.setProximo(nuevo);
            inicial.setAnterior(nuevo);
            inicial = nuevo;
        }
        tam++;
    }

    public void eliminar(T valor) {
        if (tam == 0) return;
        Nodo<T> temp = inicial;
        do {
            if (temp.getValor().equals(valor)) {

                // Caso: único nodo
                if (tam == 1) {
                    inicial = null;
                    actual = null;
                } else {
                    temp.getAnterior().setProximo(temp.getProximo());
                    temp.getProximo().setAnterior(temp.getAnterior());
                    if (temp == inicial) {
                        inicial = temp.getProximo();
                    }
                    if (temp == actual) {
                        actual = temp.getProximo();
                    }
                }
                tam--;
                return;
            }
            temp = temp.getProximo();
        } while (temp != inicial);
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

    public T consultarSiguiente() {
        return (actual != null) ? actual.getProximo().getValor() : null;
    }

    public T consultarAnterior() {
        return (actual != null) ? actual.getAnterior().getValor() : null;
    }

    public T pasarSiguiente() {
        if (actual == null)
            return null;
        actual = actual.getProximo();
        return actual.getValor();
    }

    public T pasarAnterior() {
        if (actual == null)
            return null;
        actual = actual.getAnterior();
        return actual.getValor();
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

    public Nodo<T> getActual() {
        return actual;
    }

    public void setActual(Nodo<T> actual) {
        this.actual = actual;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }
}
