package vallegrande.edu.pe.view;

import java.util.List;
import java.util.Scanner;
import vallegrande.edu.pe.controller.AutorController;
import vallegrande.edu.pe.controller.LibroController;
import vallegrande.edu.pe.model.Autor;
import vallegrande.edu.pe.model.Libro;

public class BibliotecaView {
    private LibroController libroController = new LibroController();
    private AutorController autorController = new AutorController();
    private Scanner scanner = new Scanner(System.in);

    public void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n===== BIBLIOTECA =====");
            System.out.println("1. Registrar libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Buscar libro");
            System.out.println("4. Registrar autor Nuevo");
            System.out.println("5. Listar autores Nuevo");
            System.out.println("6. Salir");
            opcion = leerEnteroValido("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> registrarLibro();
                case 2 -> listarLibros();
                case 3 -> buscarLibro();
                case 4 -> registrarAutor();
                case 5 -> listarAutores();
                case 6 -> System.out.println("¡Gracias por usar el sistema!");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private void registrarLibro() {
        System.out.println("\n--- Registrar Libro ---");
        int id = leerEnteroValido("Ingrese ID: ");
        String titulo = leerTextoNoVacio("Ingrese Título: ");
        String autor = leerTextoNoVacio("Ingrese Nombre del Autor: ");
        int anio = leerEnteroValido("Ingrese Año: ");

        libroController.agregarLibro(new Libro(id, titulo, autor, anio));
        System.out.println("¡Libro registrado exitosamente!");
    }

    private void listarLibros() {
        System.out.println("\n--- Lista de Libros ---");
        List<Libro> libros = libroController.obtenerLibros();
        if (libros.isEmpty()) System.out.println("No hay libros registrados.");
        else libros.forEach(Libro::mostrarLibro);
    }

    private void buscarLibro() {
        String titulo = leerTextoNoVacio("\nIngrese título a buscar: ");
        List<Libro> encontrados = libroController.buscarPorTitulo(titulo);
        if (encontrados.isEmpty()) System.out.println("No se encontraron coincidencias.");
        else encontrados.forEach(Libro::mostrarLibro);
    }

    private void registrarAutor() {
        System.out.println("\n--- Registrar Autor Nuevo ---");
        int id = leerEnteroValido("Ingrese ID: ");
        String nombre = leerTextoNoVacio("Nombre del Autor: ");
        String pais = leerTextoNoVacio("Ingrese País: ");

        autorController.agregarAutor(new Autor(id, nombre, pais));
        System.out.println("¡Autor registrado exitosamente!");
    }

    private void listarAutores() {
        System.out.println("\n--- Lista de Autores ---");
        List<Autor> autores = autorController.obtenerAutores();
        if (autores.isEmpty()) System.out.println("No hay autores registrados.");
        else autores.forEach(Autor::mostrarAutor);
    }

    private int leerEnteroValido(String mensaje) {
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print(mensaje);
            try {
                numero = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un valor numérico entero.");
            }
        }
        return numero;
    }

    private String leerTextoNoVacio(String mensaje) {
        String texto = "";
        while (texto.trim().isEmpty()) {
            System.out.print(mensaje);
            texto = scanner.nextLine();
            if (texto.trim().isEmpty()) {
                System.out.println("❌ No puede estar vacío. Reintente.");
            }
        }
        return texto;
    }
}