public class CuentaBancaria {
    public static void main(String[] args) {
        double saldoInicial = 1000.0;
        double retiroSemanal = 200.0;
        int semanasEnUnMes = 4;

        double saldoFinal = saldoInicial - (retiroSemanal * semanasEnUnMes);

        System.out.println("El saldo final en la cuenta es: $" + saldoFinal);
    }

    public void retirar(double d) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retirar'");
    }
}
