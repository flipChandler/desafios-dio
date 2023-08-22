package br.com.felipe;

public class Application {

    public static void main(String[] args) {
        var robo = new Robo();
        robo.setStrategy(new ComportamentoAgressivo());
        robo.mover();
        robo.mover();
        robo.setStrategy(new ComportamentoDefensivo());
        robo.mover();
        robo.setStrategy(new ComportamentoNormal());
        robo.mover();
    }
}
