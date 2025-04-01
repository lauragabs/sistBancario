public class ContaBancaria {
    
    protected String titular;
    protected double saldo;

    public ContaBancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public boolean sacar(double valor) {
        if (this.saldo >= valor) {
            this.saldo -= valor;
            return true;
        }
        return false;
    }

    public String exibeSaldo(){
        return "Saldo da conta de " + this.titular +": "+String.format("%.2f", this.saldo);
    }

    public double getSaldo() {
        return saldo;
    }

}
