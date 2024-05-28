package domain;

import service.Notificacao;
import service.Pagamento;
import service.impl.NotificacaoConsole;
import service.impl.PagamentoBoleto;
import service.impl.PagamentoCartao;
import service.impl.PagamentoPIX;

import java.util.Scanner;

public class SistemaPagamento {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Notificacao notificacao = new NotificacaoConsole();
        Pagamento pagamento = null;

        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1. Boleto");
        System.out.println("2. Cartão");
        System.out.println("3. PIX");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                pagamento = new PagamentoBoleto();
                break;
            case 2:
                System.out.println("Digite o número de parcelas:");
                int parcelas = scanner.nextInt();
                pagamento = new PagamentoCartao(parcelas);
                break;
            case 3:
                pagamento = new PagamentoPIX();
                break;
            default:
                System.out.println("Opção inválida!");
                return;
        }

        System.out.println("Digite o valor do pagamento:");
        double valor = scanner.nextDouble();

        if (pagamento != null) {
            pagamento.pagar(valor, notificacao);
        }
    }
}
