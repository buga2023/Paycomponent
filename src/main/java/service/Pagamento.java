package service;

public interface Pagamento {
    boolean processarPagamento(double valor);

    void pagar(double valor, Notificacao notificacao);
}

