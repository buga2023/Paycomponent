package service.impl;

public class Logger {
    public static void log(String mensagem) {
        System.out.println("[LOG] " + mensagem);
    }
    public static void error(String mensagem) {
        System.err.println("[ERROR] " + mensagem);
    }
}

