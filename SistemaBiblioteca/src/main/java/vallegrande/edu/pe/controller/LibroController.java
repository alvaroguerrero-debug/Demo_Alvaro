package vallegrande.edu.pe.controller;

import java.util.ArrayList;
import java.util.List;
import vallegrande.edu.pe.model.Libro;

public class LibroController {
    private List<Libro> listaLibros = new ArrayList<>();

    public LibroController() {
        listaLibros.add(new Libro(1, "Cien Años de Soledad", "Gabriel García Márquez", 1967));
        listaLibros.add(new Libro(2, "Don Quijote de la Mancha", "Miguel de Cervantes", 1605));
    }

    public void agregarLibro(Libro libro) {
        listaLibros.add(libro);
    }

    public List<Libro> obtenerLibros() {
        return listaLibros;
    }

    public List<Libro> buscarPorTitulo(String titulo) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : listaLibros) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(libro);
            }
        }
        return resultados;
    }
}