package model;

public class Debito extends Pagamento {

    public Debito(Conta conta, float valor) {
        super(conta, valor);
    }

    @Override
    public String statusPagamento() {
        if (this.getValor() <= 0) return "Pagamento Reprovado. O valor do pagamento é inválido.";

        if (this.getConta().getSaldo() >= this.getValor()) {
            this.getConta().setSaldo(this.getConta().getSaldo() - this.getValor());
            return "Pagamento Aprovado.";
        }
        return "Pagamento Reprovado.";
    }
}
