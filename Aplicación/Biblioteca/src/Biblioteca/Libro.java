package Biblioteca;

public class Libro {
    private String titulo;
    private String autor;
    private boolean disponible;
    
    public Libro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void prestamo() {
        disponible = false;
    }

    public void devolucion() {
        disponible = true;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
