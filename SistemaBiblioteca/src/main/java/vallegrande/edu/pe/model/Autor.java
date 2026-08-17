package vallegrande.edu.pe.model;

public class Autor {
    private int id;
    private String nombre;
    private String pais;

    public Autor(int id, String nombre, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getPais() { return pais; }

    public void mostrarAutor() {
        System.out.println("ID: " + id);
        System.out.println("Nombre: " + nombre);
        System.out.println("País: " + pais);
        System.out.println("------------------------------------");
    }
}