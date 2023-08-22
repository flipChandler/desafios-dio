package br.com.felipe;

public class ComportamentoNormal implements ComportamentoStrategy {

    @Override
    public void mover() {
        System.out.println("Movendo-se normalmente...");
    }
}
