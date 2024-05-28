package service;

public interface PagamentoParcelado extends Pagamento {
    boolean processarPagamentoParcelado(double valor, int parcelas);
}
