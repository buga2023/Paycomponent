package service;

public interface PagamentoTaxa {
    boolean processarPagamento(double valor);
    double calcularTaxa(double valor);
}
