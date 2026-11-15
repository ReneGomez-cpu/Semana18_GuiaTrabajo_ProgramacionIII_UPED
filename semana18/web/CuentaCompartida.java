public class CuentaCompartida {
    private double saldo;

    public CuentaCompartida(double saldoInicial) { saldo = saldoInicial; }
    public void depositar(double monto) { saldo += monto; }
    public boolean retirar(double monto) {
        if (monto <= saldo) { saldo -= monto; return true; }
        return false;
    }
    public double getSaldo() { return saldo; }
}
