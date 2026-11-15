public class Socio {
    private final int id;
    private final String nombre;
    private final String correo;

    public Socio(int id, String nombre, String correo) {
        if (id <= 0 || nombre == null || nombre.isBlank() || correo == null || !correo.contains("@"))
            throw new DatoInvalidoException("Datos invalidos del socio");
        this.id = id; this.nombre = nombre; this.correo = correo;
    }
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
    @Override public String toString() { return id + " - " + nombre + " - " + correo; }
}
