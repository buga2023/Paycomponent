package service;

public interface PagamentoTaxa extends Pagamento{
    double calcularTaxa(double valor);
}
