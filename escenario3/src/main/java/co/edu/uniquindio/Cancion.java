package co.edu.uniquindio;

public class Cancion {
    private String titulo; 
    private int duracion; //en minutos
    
    public Cancion(String titulo, int duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Cancion [titulo=" + titulo + ", duracion=" + duracion + "]";
    }

    @Override
    public boolean equals(Object obj) { //Necesario para eliminar por titulo 
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Cancion otra = (Cancion) obj;
        return this.titulo.equalsIgnoreCase(otra.titulo);
    }
    
}
