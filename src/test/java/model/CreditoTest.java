package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditoTest {
    Conta conta;
    Titular titular;

    @BeforeEach
    void setUp() {
        titular = new Titular(
                "Jéssica Giovanna Aurora Fernandes",
                "359.928.973-56"
        );
        conta = new Conta(
                titular,
                "50836952-4",
                "4402",
                "Santander",
                "Bento Goncalves",
                "RS",
                1200.0f,
                300.0f
        );
    }

    @Test
    void deveRetornarInformacoesComPagamentoAprovado() {
        Pagamento pagamento = new Credito(conta, 3000.0f, 10);

        String mensagem = "Informações do Pagamento:\n" +
                "Nome: Jéssica Giovanna Aurora Fernandes\n" +
                "CPF: 359.928.973-56\n" +
                "Valor total: 3000.0\n" +
                "Forma de pagamento: A forma de pagamento é crédito.\n" +
                "Status: Pagamento Aprovado. 10 x R$300.0 sem juros.";

        assertEquals(mensagem, pagamento.getInfo());
        assertEquals(1200.0f, pagamento.getConta().getSaldo(), 0.1f);
    }

    @Test
    void deveRetornarInformacoesComPagamentoReprovado() {
        Pagamento pagamento = new Credito(conta, 3000.0f, 5);

        String mensagem = "Informações do Pagamento:\n" +
                "Nome: Jéssica Giovanna Aurora Fernandes\n" +
                "CPF: 359.928.973-56\n" +
                "Valor total: 3000.0\n" +
                "Forma de pagamento: A forma de pagamento é crédito.\n" +
                "Status: Pagamento Reprovado. O valor das parcelas ultrapassou o limite de R$300.0 da conta.";

        assertEquals(mensagem, pagamento.getInfo());
        assertEquals(1200.0f, pagamento.getConta().getSaldo(), 0.1f);
    }

    @Test
    void deveRetornarInformacoesComDivisaoPorZero() {
        Pagamento pagamento = new Credito(conta, 3000.0f, 0);

        String mensagem = "Informações do Pagamento:\n" +
                "Nome: Jéssica Giovanna Aurora Fernandes\n" +
                "CPF: 359.928.973-56\n" +
                "Valor total: 3000.0\n" +
                "Forma de pagamento: A forma de pagamento é crédito.\n" +
                "Status: Pagamento Reprovado. A quantidade de parcelas é inválida.";

        assertEquals(mensagem, pagamento.getInfo());
        assertEquals(1200.0f, pagamento.getConta().getSaldo(), 0.1f);
    }
    @Test
    void deveRetornarInformacoesComValorInvalido() {
        Pagamento pagamento = new Credito(conta, 0.0f, 12);

        String mensagem = "Informações do Pagamento:\n" +
                "Nome: Jéssica Giovanna Aurora Fernandes\n" +
                "CPF: 359.928.973-56\n" +
                "Valor total: 0.0\n" +
                "Forma de pagamento: A forma de pagamento é crédito.\n" +
                "Status: Pagamento Reprovado. O valor do pagamento é inválido.";

        assertEquals(mensagem, pagamento.getInfo());
        assertEquals(1200.0f, pagamento.getConta().getSaldo(), 0.1f);
    }
}