package vallegrande.edu.pe.view;

import java.util.Scanner;

public class AgendaView {

    private Scanner scanner;

    // Constructor
    public AgendaView() {
        scanner = new Scanner(System.in);
    }

    // Mostrar título
    public void mostrarTitulo() {
        System.out.println("---------------------------");
        System.out.println("AGENDA DE CONTACTOS");
        System.out.println("---------------------------");
    }

    // Mostrar menú
    public void mostrarMenu() {
        System.out.println("\nMENU PRINCIPAL");
        System.out.println("1. Registrar contacto");
        System.out.println("2. Listar contactos");
        System.out.println("3. Buscar contacto");
        System.out.println("4. Eliminar contacto");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    // Leer opción del menú
    public int leerOpcion() {
        return scanner.nextInt();
    }

    // Leer texto
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        scanner.nextLine();
        return scanner.nextLine();
    }

    // Leer número
    public int leerNumero(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextInt();
    }

    // Mostrar mensaje
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}