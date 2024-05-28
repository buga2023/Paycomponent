import domain.SistemaPagamento;
import service.Notificacao;
import service.impl.NotificacaoConsole;
import service.impl.PagamentoBoleto;
import service.impl.PagamentoCartao;
import service.impl.PagamentoPIX;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Notificacao notificacao = new NotificacaoConsole();

        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1. Boleto");
        System.out.println("2. Cartão");
        System.out.println("3. PIX");
        int escolha = scanner.nextInt();

        SistemaPagamento sistemaPagamento = null;
        switch (escolha) {
            case 1:
                sistemaPagamento = new SistemaPagamento(new PagamentoBoleto(), notificacao);
                break;
            case 2:
                sistemaPagamento = new SistemaPagamento(new PagamentoCartao(), notificacao);
                break;
            case 3:
                sistemaPagamento = new SistemaPagamento(new PagamentoPIX(), notificacao);
                break;
            default:
                System.out.println("Escolha inválida.");
                return;
        }

        System.out.println("Digite o valor do pagamento:");
        double valor = scanner.nextDouble();

        if (escolha == 2) { // Se for pagamento com cartão, perguntar sobre parcelamento
            System.out.println("Deseja parcelar o pagamento? (s/n)");
            String respostaParcelamento = scanner.next();

            if (respostaParcelamento.equalsIgnoreCase("s")) {
                System.out.println("Em quantas parcelas?");
                int parcelas = scanner.nextInt();
                sistemaPagamento.processarPagamentoParcelado(valor, parcelas);
            } else {
                sistemaPagamento.processarPagamento(valor);
            }
        } else {
            sistemaPagamento.processarPagamento(valor);
        }

        scanner.close();
    }
}

