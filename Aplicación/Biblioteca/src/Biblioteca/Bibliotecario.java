package Biblioteca;

public class Bibliotecario extends Usuario{
    
    public Bibliotecario(String nombre) {
        super(nombre);
    }

    @Override
    public void mostrarRol() {
        System.out.println("Bibliotecario: " + nombre);
    }

    public void registrarLibro(Biblioteca biblioteca, String titulo, String autor) {
        biblioteca.registrarLibro(titulo, autor);
        System.out.println("El bibliotecario ha registrado el libro.");
    }
    
}
