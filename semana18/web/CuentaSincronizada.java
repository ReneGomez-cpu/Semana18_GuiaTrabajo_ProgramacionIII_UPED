public class CuentaSincronizada {
    private double saldo;

    public CuentaSincronizada(double saldoInicial) { saldo = saldoInicial; }
    public synchronized void depositar(double monto) { saldo += monto; }
    public synchronized boolean retirar(double monto) {
        if (monto <= saldo) { saldo -= monto; return true; }
        return false;
    }
    public synchronized double getSaldo() { return saldo; }
}
