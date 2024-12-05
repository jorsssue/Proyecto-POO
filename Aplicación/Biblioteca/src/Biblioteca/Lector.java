package Biblioteca;

public class Lector extends Usuario {

    public Lector(String nombre) {
        super(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void mostrarRol() {
        System.out.println("Lector: " + nombre);
    }
}
