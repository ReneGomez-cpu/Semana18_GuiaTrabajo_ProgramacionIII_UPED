import java.util.concurrent.atomic.AtomicInteger;

public class ContadorAtomico {
    private final AtomicInteger valor = new AtomicInteger();

    public void incrementar() { valor.incrementAndGet(); }
    public int getValor() { return valor.get(); }

    public static void main(String[] args) throws InterruptedException {
        ContadorAtomico contador = new ContadorAtomico();
        Thread a = new Thread(() -> { for (int i = 0; i < 100000; i++) contador.incrementar(); });
        Thread b = new Thread(() -> { for (int i = 0; i < 100000; i++) contador.incrementar(); });
        a.start(); b.start(); a.join(); b.join();
        System.out.println("Esperado: 200000 | Obtenido: " + contador.getValor());
    }
}
