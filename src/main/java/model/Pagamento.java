package model;

public abstract class Pagamento {

    private Conta conta;
    private float valor;

    public Pagamento(Conta conta, float valor) {
        this.conta = conta;
        this.valor = valor;
    }

    public Conta getConta() {
        return conta;
    }

    public float getValor() {
        return valor;
    }

    public abstract String statusPagamento();

    public String getFormaPagamento() {
        return "A forma de pagamento é débito.";
    }

    public String getInfo() {
        return "Informações do Pagamento:\n" +
                "Nome: " + this.getConta().getTitular().getNome() + "\n" +
                "CPF: " + this.getConta().getTitular().getCpf() + "\n" +
                "Valor total: " + this.getValor() + "\n" +
                "Forma de pagamento: " + this.getFormaPagamento() + "\n" +
                "Status: " + this.statusPagamento() + "";
    }
}
