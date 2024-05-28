package service.impl;

import service.PagamentoParcelado;
import service.PagamentoTaxa;

public class PagamentoCartao implements PagamentoTaxa, PagamentoParcelado {
    private static final double TAXA_CARTAO = 0.05;
    private static final double TAXA_PARCELAMENTO = 0.02; // Taxa adicional por parcela

    @Override
    public boolean processarPagamento(double valor) {
        double valorComTaxa = valor + calcularTaxa(valor);
        System.out.println("Valor total com taxa de cartão: " + valorComTaxa);
        System.out.println("Processando pagamento com cartão no valor de: " + valor);
        // Lógica para processar o pagamento com cartão
        return true; // Retornar true se o pagamento com cartão foi bem-sucedido
    }

    @Override
    public double calcularTaxa(double valor) {
        return valor * TAXA_CARTAO;
    }

    @Override
    public boolean processarPagamentoParcelado(double valor, int parcelas) {
        double valorTotal = valor + (valor * TAXA_PARCELAMENTO * parcelas);
        double valorParcela = valorTotal / parcelas;
        System.out.println("Processando pagamento parcelado em " + parcelas + " vezes de " + valorParcela);
        // Lógica para processar o pagamento parcelado
        return true; // Retornar true se o pagamento parcelado foi bem-sucedido
    }
}