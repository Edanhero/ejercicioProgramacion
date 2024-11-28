
class FondosInsuficientesException extends Exception {
    public FondosInsuficientesException(String mensaje) {
        super(mensaje);
    }
}

public class CuentaBancaria2 {
    private double saldo;

    public CuentaBancaria2(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void retirar(double cantidad) throws FondosInsuficientesException {
        if (cantidad > saldo) {
            throw new FondosInsuficientesException("Error: Fondos insuficientes. Saldo disponible: $" + saldo);
        }
        saldo -= cantidad;
        System.out.println("Retiro exitoso. Saldo restante: $" + saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public static void main(String[] args) {
        CuentaBancaria2 cuenta = new CuentaBancaria2 (500.0);

        try {
            cuenta.retirar(600.0); 
        } catch (FondosInsuficientesException e) {
            System.out.println(e.getMessage());
        }

        try {
            cuenta.retirar(200.0); 
        } catch (FondosInsuficientesException e) {
            System.out.println(e.getMessage());
        }
    }
}
