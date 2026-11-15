public class ContadorInseguro {
    private int valor;

    public void incrementar() { valor++; }
    public int getValor() { return valor; }

    public static void main(String[] args) throws InterruptedException {
        ContadorInseguro contador = new ContadorInseguro();
        ejecutar(contador);
        System.out.println("Esperado: 200000 | Obtenido: " + contador.getValor());
    }

    private static void ejecutar(ContadorInseguro contador) throws InterruptedException {
        Thread a = new Thread(() -> { for (int i = 0; i < 100000; i++) contador.incrementar(); });
        Thread b = new Thread(() -> { for (int i = 0; i < 100000; i++) contador.incrementar(); });
        a.start(); b.start(); a.join(); b.join();
    }
}
