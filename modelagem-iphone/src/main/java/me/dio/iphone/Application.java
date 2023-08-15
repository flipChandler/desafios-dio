package me.dio.iphone;

public class Application {

    public static void main(String[] args) {
        IphoneInterface iphone = new Iphone();
        iphone.atender();
        iphone.adicionarNovaAba();
        iphone.exibirPagina();
        iphone.atualizarPagina();
        iphone.ligar();
        iphone.iniciarCorreioVoz();
        iphone.selecionarMusica();
        iphone.tocar();
        iphone.pausar();
    }
}
