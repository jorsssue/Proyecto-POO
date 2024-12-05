
import java.util.Scanner;

import Biblioteca.*;

public class GestorBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n ---- Menu de biblioteca ----");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar usuario");
            System.out.println("3. Mostrar libros");
            System.out.println("4. Buscar libros");
            System.out.println("5. Prestamo de libro");
            System.out.println("6. Devolver libro");
            System.out.println("7. Mostrar usuarios");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el titulo del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    biblioteca.registrarLibro(titulo, autor);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.println("Seleccione el tipo de usuario: 1) Lector. 2) Bibliotecario.");
                    int tipoUsuario = scanner.nextInt();
                    scanner.nextLine(); 
                    if (tipoUsuario == 1) {
                        biblioteca.registraUsuario(new Lector(nombreUsuario));
                    } else if (tipoUsuario == 2) {
                        biblioteca.registraUsuario(new Bibliotecario(nombreUsuario));
                    } else {
                        System.out.println("Opción invalida");
                    }
                    break;
                case 3:
                    biblioteca.mostrarLibros();
                    break;
                case 4:
                    System.out.println("Ingrese el título del libro a buscar: ");
                    scanner.nextLine(); 
                    String buscarTitulo = scanner.nextLine().trim(); 
                    Libro libroEncontrado = biblioteca.buscarLibro(buscarTitulo);
                    if (libroEncontrado != null) {
                        System.out.println("Libro encontrado: " + libroEncontrado);
                    } else {
                        System.out.println("El libro con título '" + buscarTitulo + "' no se encuentra disponible.");
                    }
                    break;          
                case 5:
                    System.out.print("Ingrese el nombre del lector: ");
                    String nombreLector = scanner.nextLine();
                    Lector lectorPrestamo = biblioteca.buscarLector(nombreLector);
                    if (lectorPrestamo != null) {
                        System.out.print("Ingrese el titulo del libro a prestar: ");
                        String tituloPrestamo = scanner.nextLine();
                        biblioteca.prestarLibro(tituloPrestamo, lectorPrestamo);
                    } else {
                        System.out.println("Lector no encontrado.");
                    }
                    break;
                case 6:
                    System.out.print("Ingrese el titulo del libro a devolver: ");
                    String libroDevolver = scanner.nextLine();
                    biblioteca.devolverLibro(libroDevolver);
                    break;
                case 7:
                    biblioteca.mostrarUsuarios();
                    break;
                case 8:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 8);

        scanner.close();
    }
}

