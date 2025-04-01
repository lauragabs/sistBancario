public class ContaPoEstudantil extends ContaPo{

    private double limiteIsencaotaxa;

    public ContaPoEstudantil(String titular, double saldo, double taxaRendimento, double limiteIsencaotaxa) {
        super(titular, saldo, taxaRendimento);
        this.limiteIsencaotaxa = limiteIsencaotaxa;
    }

    @Override
    public boolean sacar(double valor){
        return super.sacar(valor);
    }

    public String exibeLimiteIsencao(){
        return "Limite de isenção de taxa para estudante: " + String.format("%.2f", limiteIsencaotaxa);
    }

}
