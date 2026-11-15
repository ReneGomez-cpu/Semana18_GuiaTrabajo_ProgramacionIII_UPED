import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositorioSocios {
    private final List<Socio> socios = new ArrayList<>();
    public RepositorioSocios() {
        socios.add(new Socio(1, "Ana Lopez", "ana@correo.com"));
        socios.add(new Socio(2, "Carlos Perez", "carlos@correo.com"));
    }
    public synchronized Socio buscarPorId(int id) {
        return socios.stream().filter(s -> s.getId() == id).findFirst()
                .orElseThrow(() -> new SocioNoEncontradoException("No existe el socio " + id));
    }
    public synchronized void agregar(Socio socio) {
        if (socios.stream().anyMatch(s -> s.getId() == socio.getId()))
            throw new DatoInvalidoException("El id ya esta registrado");
        socios.add(socio);
    }
    public synchronized List<Socio> listar() { return Collections.unmodifiableList(new ArrayList<>(socios)); }
}
