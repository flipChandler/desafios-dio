package br.com.felipe;

public class Robo {

    private ComportamentoStrategy comportamentoStrategy;

    public void setStrategy(ComportamentoStrategy comportamentoStrategy) {
        this.comportamentoStrategy = comportamentoStrategy;
    }

    public void mover() {
        comportamentoStrategy.mover();
    }
}
