package model;

public class Conta {

    private Titular titular;
    private String numero;
    private String agencia;
    private String banco;
    private String cidade;
    private String estado;
    private float saldo;
    private float limiteCredito;

    public Conta(Titular titular, String numero, String agencia, String banco, String cidade, String estado, float saldo, float limiteCredito) {
        this.titular = titular;
        this.numero = numero;
        this.agencia = agencia;
        this.banco = banco;
        this.cidade = cidade;
        this.estado = estado;
        this.saldo = saldo;
        this.limiteCredito = limiteCredito;
    }

    public Titular getTitular() {
        return titular;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getLimiteCredito() {
        return limiteCredito;
    }
}
