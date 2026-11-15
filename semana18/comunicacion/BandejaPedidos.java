import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BandejaPedidos {
    private static final String FIN = "FIN";

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> bandeja = new LinkedBlockingQueue<>();
        Thread productor = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    String pedido = "Pedido-" + i;
                    bandeja.put(pedido);
                    System.out.println("Producido: " + pedido);
                }
                bandeja.put(FIN);
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        Thread consumidor = new Thread(() -> {
            try {
                String pedido;
                while (!(pedido = bandeja.take()).equals(FIN))
                    System.out.println("Procesado: " + pedido);
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        });
        productor.start(); consumidor.start();
        productor.join(); consumidor.join();
    }
}
