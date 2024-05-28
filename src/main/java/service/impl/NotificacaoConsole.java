package service.impl;

import service.Notificacao;

public class NotificacaoConsole implements Notificacao {
    public void enviarNotificacao(String mensagem) {
        System.out.println(mensagem);
    }
}
