public class EstadosHilo {
    public static void main(String[] args) throws InterruptedException {
        Thread hilo = new Thread(() -> {
            try {
                Thread.sleep(300);
                System.out.println("Trabajo ejecutandose...");
            } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        }, "trabajador");

        System.out.println("Inicial: " + hilo.getState());
        hilo.start();
        System.out.println("Despues de start: " + hilo.getState());
        Thread.sleep(50);
        System.out.println("Durante sleep: " + hilo.getState());
        hilo.join();
        System.out.println("Final: " + hilo.getState());
    }
}
