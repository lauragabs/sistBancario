public class ContaCoEmpresarial extends ContaCo{

    private double taxaJurosEmprestimo;

    public ContaCoEmpresarial(String titular, double saldo, double limitechequeEspeial, double taxaJurosEmprestimo) {
        super(titular, saldo, limitechequeEspeial);
        this.taxaJurosEmprestimo = taxaJurosEmprestimo;
    }

    public boolean solicitaEmprestimo(double valor) {
        if ((saldo + limitechequeEspeial) >= valor) {
            double valorComJuros = valor + (valor * (taxaJurosEmprestimo / 100));
            saldo += valorComJuros; 
            return true; 
        }
        return false; 
    }

    @Override
    public String exibeSaldo(){
        return "Saldo da conta empresadial de " + titular + ": " + String.format("%.2f", saldo);
    }

}
