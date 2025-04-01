public class ContaCo extends ContaBancaria {

    protected double limitechequeEspeial;

    

    public ContaCo(String titular, double saldo, double limitechequeEspeial) {
        super(titular, saldo);
        this.limitechequeEspeial = limitechequeEspeial;
    }

    @Override
    public boolean sacar(double valor){
        if(valor <= saldo + limitechequeEspeial){
            saldo -= valor;
            return true;
        } else{
            return false;
        }

    }

    public String exibeLimiteChequeEspecial(){
        return "Limite de Cheque Especial: " + String.format("%.2f",this.limitechequeEspeial);
    }
}
