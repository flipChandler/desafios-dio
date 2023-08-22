package br.com.felipe.subsistemacep;

public class CepApi {

    private static final CepApi instance = new CepApi();

    private CepApi(){}

    public static CepApi getInstance() {
        return instance;
    }

    public String recuperarCidade(String cep) {
        return "Araraquara";
    }

    public String recuperarEstado(String cep) {
        return "SP";
    }
}
