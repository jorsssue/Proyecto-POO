package Biblioteca;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros;
    private ArrayList<Usuario> usuarios;

    public Biblioteca() {
        libros = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void registrarLibro(String titulo, String autor) {
        Libro libro = new Libro(titulo, autor);
        libros.add(libro);
        System.out.println("El libro: " + titulo + " ha sido registrado.");
    }

    public void registraUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("El usuario: " + usuario + " ha sido registrado.");
    }

    public Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo.trim())) {
                return libro;
            }
        }
        System.out.println("El libro no fue encontrado.");
        return null;
    }
    

    public Lector buscarLector(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Lector && usuario.getNombre().equalsIgnoreCase(nombre)) {
                return (Lector) usuario; 
            }
        }
        return null;
    }

    public void prestarLibro(String titulo, Lector lector) {
        Libro libro = buscarLibro(titulo);
        if (libro != null && libro.isDisponible()) {
            libro.prestamo();
            System.out.println("El libro: " + titulo + " ha sido prestado a " + lector.getNombre());
        } else {
            System.out.println("El libro no está disponible");
        }
    }

    public void devolverLibro(String titulo) {
        Libro libro = buscarLibro(titulo);
        if (libro != null && !libro.isDisponible()){
            libro.devolucion();
            System.out.println("El libro: " + titulo + " ha sido devuelto.");
        } else {
            System.out.println("El libro no ha sido prestado o no existe.");
        }
    }

    public void mostrarLibros() {
        for (int i = 0; i < libros.size(); i++) {
            System.out.println(libros.get(i));
        }
    }

    public void mostrarUsuarios() {
        for (int i = 0; i < usuarios.size(); i++) {
            usuarios.get(i).mostrarRol();
        }
    }

}
