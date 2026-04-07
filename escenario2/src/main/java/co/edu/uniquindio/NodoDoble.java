package co.edu.uniquindio;

public class NodoDoble<T> {
    private T valor;
    private NodoDoble<T> siguiente;
    private NodoDoble<T> anterior;

    public NodoDoble(T valor) {
        this.valor = valor;
        siguiente = null;
        anterior = null;
    }

    @Override
    public String toString() {
        return "Nodo {" +
                "valor = " + valor +
                "[proximo = " + siguiente +
                ", anterior = " + anterior +
                "] }";
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NodoDoble<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble<T> anterior) {
        this.anterior = anterior;
    }
}