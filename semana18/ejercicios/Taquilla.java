public class Taquilla {
    private int boletos = 10;

    public int vender() {
        if (boletos == 0) return 0;
        return boletos--;
    }

    public static void main(String[] args) throws InterruptedException {
        Taquilla taquilla = new Taquilla();
        Thread a = new Thread(() -> vender(taquilla, "A"));
        Thread b = new Thread(() -> vender(taquilla, "B"));
        a.start(); b.start(); a.join(); b.join();
        System.out.println("Boletos restantes: " + taquilla.boletos);
    }

    private static void vender(Taquilla t, String cliente) {
        for (int i = 0; i < 6; i++) System.out.println(cliente + " compro: " + t.vender());
    }
}
