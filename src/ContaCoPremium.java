public class ContaCoPremium extends ContaCo {

    private double cashBackPercentual;

    public ContaCoPremium(String titular, double saldo, double limitechequeEspeial, double cashBackPercentual) {
        super(titular, saldo, limitechequeEspeial);
        this.cashBackPercentual = cashBackPercentual;
    }

    @Override
    public boolean sacar(double valor){
        if (super.sacar(valor)){
            double cashBack = valor * (cashBackPercentual/100);
            saldo += cashBack;
            return true;
        } 
        return false;
    }

    public String exibeBeneficioPremium(){
        return "Conta Corrente Premium com CashBacke de " + String.format("%.2f",this.cashBackPercentual) + "% em casa saque";
    }

}
