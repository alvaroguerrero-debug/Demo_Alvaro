package vallegrande.edu.pe.app;

import vallegrande.edu.pe.controller.AgendaController;
import vallegrande.edu.pe.model.Contacto;
import vallegrande.edu.pe.view.AgendaView;

public class Main {
    public static void main(String[] args) {
        // 1. Crear los componentes principales
        AgendaController controller = new AgendaController();
        AgendaView view = new AgendaView();

        // 2. Precarga obligatoria de 5 contactos iniciales
        // (Reutilizamos tus datos iniciales de Ana y Carlos y agregamos 3 más)
        controller.agregarContacto(new Contacto(1, "Ana", "Torres", "Cañete", "983745656", "ana@gmail.com"));
        controller.agregarContacto(new Contacto(2, "Carlos", "Perez", "Imperial", "951264456", "carlos@gmail.com"));
        controller.agregarContacto(new Contacto(3, "Maria", "Lopez", "Lima", "912345678", "maria@gmail.com"));
        controller.agregarContacto(new Contacto(4, "Juan", "Gomez", "San Vicente", "955443322", "juan@gmail.com"));
        controller.agregarContacto(new Contacto(5, "Luis", "Ramirez", "Mala", "977889900", "luis@gmail.com"));

        // Mostrar título inicial
        view.mostrarTitulo();

        int opcion = 0;
        int siguienteId = 6; // Contador para asignar ID automático a los contactos nuevos que registre el usuario

        // 3. Bucle principal del menú
        do {
            view.mostrarMenu();
            opcion = view.leerOpcion();

            switch (opcion) {
                case 1:
                    view.mostrarMensaje("\n--- REGISTRAR CONTACTO ---");
                    String nombres = view.leerTexto("Ingrese nombres: ");
                    String apellidos = view.leerTexto("Ingrese apellidos: ");
                    String direccion = view.leerTexto("Ingrese dirección: ");
                    String telefono = view.leerTexto("Ingrese teléfono: ");
                    String correo = view.leerTexto("Ingrese correo: ");

                    // Se crea con el ID autoincrementado (siguienteId++)
                    Contacto nuevoContacto = new Contacto(siguienteId++, nombres, apellidos, direccion, telefono, correo);
                    controller.agregarContacto(nuevoContacto);
                    break;

                case 2:
                    controller.listarContactos();
                    break;

                case 3:
                    view.mostrarMensaje("\n--- BUSCAR CONTACTO ---");
                    String textoBuscar = view.leerTexto("Ingrese nombre o apellido a buscar: ");
                    controller.buscarContacto(textoBuscar);
                    break;

                case 4:
                    view.mostrarMensaje("\n--- ELIMINAR CONTACTO ---");
                    int idEliminar = view.leerNumero("Ingrese el ID del contacto a eliminar: ");
                    controller.eliminarContacto(idEliminar);
                    break;

                case 5:
                    view.mostrarMensaje("\n¡Gracias por utilizar la Agenda de Contactos!");
                    break;

                default:
                    view.mostrarMensaje("Opción no válida. Ingrese un número entre 1 y 5.");
                    break;
            }

        } while (opcion != 5);
    }
}