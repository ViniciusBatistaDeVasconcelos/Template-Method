package model;

public class Credito extends Pagamento {

    private int qtdParcelas;

    public Credito(Conta conta, float valor, int qtdParcelas) {
        super(conta, valor);
        this.qtdParcelas = qtdParcelas;
    }

    @Override
    public String statusPagamento() {
        if (qtdParcelas <= 0) return "Pagamento Reprovado. A quantidade de parcelas é inválida.";
        if (this.getValor() <= 0) return "Pagamento Reprovado. O valor do pagamento é inválido.";

        double valorParcelas = this.getValor() / qtdParcelas;

        if (valorParcelas <= getConta().getLimiteCredito()) {
            return "Pagamento Aprovado. " + this.qtdParcelas + " x R$" + valorParcelas + " sem juros.";
        }
        return "Pagamento Reprovado. O valor das parcelas ultrapassou o limite de " +
                "R$" + this.getConta().getLimiteCredito() + " da conta.";
    }

    @Override
    public String getFormaPagamento() {
        return "A forma de pagamento é crédito.";
    }
}
