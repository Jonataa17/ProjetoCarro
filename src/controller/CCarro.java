/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.MCarro;

/**
 *
 * @author 182120038
 */
public class CCarro {

    ArrayList<MCarro> carros = new ArrayList<>();
    int idCarro = 1;

    /**
     * geraID gerencia a geração de id's autoincrement para Carro.
     *
     * @return
     */
    public int geraID() {
        return this.idCarro++;
    }

    /**
     * addCarro adiciona um Carro na lista de carros.
     *
     * @param c
     */
    public void addCarro(MCarro c) {
        this.carros.add(c);
    }

    /**
     * getCarros retorna a lista de carros.
     *
     * @return
     */
    public ArrayList<MCarro> getCarros() {
        return this.carros;
    }

    /**
     * removeCarro remove Carro da lista de carros.
     *
     * @param c
     */
    public void removeCarro(MCarro c) {
        this.carros.remove(c);
    }

    public MCarro getCarroRenavam(String r) {
        MCarro c = null;
        for (MCarro carro : carros) {
            if (carro.getRenavam().equals(r)) {
                c = carro;
                break;
            }
        }
        return c;
    }

    /**
     * mockCarros inicializa aplicação com carros.
     */
    public void mockCarros() {
        MCarro c1 = new MCarro();
        c1.setCarro("Celta");
        c1.setMarca("Chevrolet - GM");
        c1.setModelo("1.0 LT");
        c1.setAno(2012);
        c1.setProprietario("Elvis Presley");
        c1.setRenavam("72232508604");
        this.addCarro(c1);
    }

    public static boolean ValidaRENAVAM(String renavam) {
        // Completa com zeros a esquerda se for no padrao antigo de 9 digitos
        // renavam = 00639884962
        if (renavam.matches("^([0-9]{9})$")) {
            renavam = "00" + renavam;
        }

        // Valida se possui 11 digitos pos formatacao
        if (!renavam.matches("[0-9]{11}")) {
            return false;
        }
        // Remove o digito (11 posicao)
        // renavamSemDigito = 0063988496
        String renavamSemDigito = renavam.substring(0, 10);

        // Inverte os caracteres (reverso)
        // renavamReversoSemDigito = 69488936
        String renavamReversoSemDigito = new StringBuffer(renavamSemDigito).reverse().toString();

        int soma = 0;

        // Multiplica as strings reversas do renavam pelos numeros multiplicadores
        // para apenas os primeiros 8 digitos de um total de 10
        // Exemplo: renavam reverso sem digito = 69488936
        // 6, 9, 4, 8, 8, 9, 3, 6
        // * * * * * * * *
        // 2, 3, 4, 5, 6, 7, 8, 9 (numeros multiplicadores - sempre os mesmos [fixo])
        // 12 + 27 + 16 + 40 + 48 + 63 + 24 + 54
        // soma = 284
        for (int i = 0; i < 8; i++) {
            Integer algarismo = Integer.parseInt(renavamReversoSemDigito.substring(i, i + 1));
            Integer multiplicador = i + 2;
            soma += algarismo * multiplicador;
        }

        // Multiplica os dois ultimos digitos e soma
        soma += Character.getNumericValue(renavamReversoSemDigito.charAt(8)) * 2;
        soma += Character.getNumericValue(renavamReversoSemDigito.charAt(9)) * 3;

        // mod11 = 284 % 11 = 9 (resto da divisao por 11)
        int mod11 = soma % 11;

        // Faz-se a conta 11 (valor fixo) - mod11 = 11 - 9 = 2
        int ultimoDigitoCalculado = 11 - mod11;

        // ultimoDigito = Caso o valor calculado anteriormente seja 10 ou 11, transformo ele em 0
        // caso contrario, eh o proprio numero
        ultimoDigitoCalculado = (ultimoDigitoCalculado >= 10 ? 0 : ultimoDigitoCalculado);

        // Pego o ultimo digito do renavam original (para confrontar com o calculado)
        int digitoRealInformado = Integer.valueOf(renavam.substring(renavam.length() - 1, renavam.length()));

        // Comparo os digitos calculado e informado
        if (ultimoDigitoCalculado == digitoRealInformado) {
            return true;
        }
        return false;
    }
}
