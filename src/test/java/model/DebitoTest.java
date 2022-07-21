package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DebitoTest {
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
        Pagamento pagamento = new Debito(conta, 1200.0f);

        String mensagem = "Informações do Pagamento:\n" +
                "Nome: Jéssica Giovanna Aurora Fernandes\n" +
                "CPF: 359.928.973-56\n" +
                "Valor total: 1200.0\n" +
                "Forma de pagamento: A forma de pagamento é débito.\n" +
                "Status: Pagamento Aprovado.";

        assertEquals(mensagem, pagamento.getInfo());
        assertEquals(0.0f, pagamento.getConta().getSaldo(), 0.1f);
    }

    @Test
    void deveRetornarInformacoesComPagamentoReprovado() {
        Pagamento pagamento = new Debito(conta, 3000.0f);

        String mensagem = "Informações do Pagamento:\n" +
                "Nome: Jéssica Giovanna Aurora Fernandes\n" +
                "CPF: 359.928.973-56\n" +
                "Valor total: 3000.0\n" +
                "Forma de pagamento: A forma de pagamento é débito.\n" +
                "Status: Pagamento Reprovado.";

        assertEquals(mensagem, pagamento.getInfo());
        assertEquals(1200.0f, pagamento.getConta().getSaldo(), 0.1f);
    }

    @Test
    void deveRetornarInformacoesComValorInvalido() {
        Pagamento pagamento = new Debito(conta, 0.0f);

        String mensagem = "Informações do Pagamento:\n" +
                "Nome: Jéssica Giovanna Aurora Fernandes\n" +
                "CPF: 359.928.973-56\n" +
                "Valor total: 0.0\n" +
                "Forma de pagamento: A forma de pagamento é débito.\n" +
                "Status: Pagamento Reprovado. O valor do pagamento é inválido.";

        assertEquals(mensagem, pagamento.getInfo());
        assertEquals(1200.0f, pagamento.getConta().getSaldo(), 0.1f);
    }
}