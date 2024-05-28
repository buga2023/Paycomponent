package service.impl;

import service.Notificacao;

public class NotificacaoConsole implements Notificacao {
    public void enviarMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
