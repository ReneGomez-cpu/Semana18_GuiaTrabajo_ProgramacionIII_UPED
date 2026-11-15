public class ContadorSeguro {
    private int valor;

    public synchronized void incrementar() { valor++; }
    public synchronized int getValor() { return valor; }

    public static void main(String[] args) throws InterruptedException {
        ContadorSeguro contador = new ContadorSeguro();
        Thread a = new Thread(() -> { for (int i = 0; i < 100000; i++) contador.incrementar(); });
        Thread b = new Thread(() -> { for (int i = 0; i < 100000; i++) contador.incrementar(); });
        a.start(); b.start(); a.join(); b.join();
        System.out.println("Esperado: 200000 | Obtenido: " + contador.getValor());
    }
}
