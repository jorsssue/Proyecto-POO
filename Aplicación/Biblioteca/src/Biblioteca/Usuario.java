package Biblioteca;

public abstract class Usuario {
    protected String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract void mostrarRol();

    @Override
    public String toString() {
        return "Persona{nombre='" + nombre + "'}";
    }
}
