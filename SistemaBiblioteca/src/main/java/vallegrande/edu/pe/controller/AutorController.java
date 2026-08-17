package vallegrande.edu.pe.controller;

import java.util.ArrayList;
import java.util.List;
import vallegrande.edu.pe.model.Autor;

public class AutorController {
    private List<Autor> listaAutores = new ArrayList<>();

    public AutorController() {
        listaAutores.add(new Autor(1, "Gabriel García Márquez", "Colombia"));
        listaAutores.add(new Autor(2, "Miguel de Cervantes", "España"));
    }

    public void agregarAutor(Autor autor) {
        listaAutores.add(autor);
    }

    public List<Autor> obtenerAutores() {
        return listaAutores;
    }
}