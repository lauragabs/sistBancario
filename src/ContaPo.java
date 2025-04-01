public class ContaPo extends ContaBancaria {

    protected double taxaRendimento;

    public ContaPo(String titular, double saldo, double taxaRendimento) {
        super(titular, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    public void aplicarRendimento (){
        saldo += saldo * (taxaRendimento/100);
    }

    @Override
    public String exibeSaldo(){
        return "Saldo da conta poupança de " + titular + ": " + String.format("%.2f", saldo);
    }
}
