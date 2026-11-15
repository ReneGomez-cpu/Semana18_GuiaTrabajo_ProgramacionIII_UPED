import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

public class ServidorVisitas {
    private static final AtomicInteger visitas = new AtomicInteger();

    public static void main(String[] args) throws IOException {
        HttpServer servidor = HttpServer.create(new InetSocketAddress(8081), 0);
        servidor.createContext("/visitas", ServidorVisitas::atender);
        servidor.start();
        System.out.println("Servidor en http://localhost:8081/visitas");
    }

    private static void atender(HttpExchange intercambio) throws IOException {
        int numero = visitas.incrementAndGet();
        byte[] respuesta = ("Visita numero: " + numero).getBytes(StandardCharsets.UTF_8);
        intercambio.getResponseHeaders().set("Content-Type", "text/plain; charset=UTF-8");
        intercambio.sendResponseHeaders(200, respuesta.length);
        try (OutputStream salida = intercambio.getResponseBody()) { salida.write(respuesta); }
    }
}
