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
        if (renavam == null || renavam.trim().length() != 9) {
            return false;
        }
        int calc = 0;
        int digito = Integer.parseInt(renavam.substring(8, 9));

        for (int i = 0; i < renavam.length() - 1; i++) {
            calc += Integer.parseInt(renavam.substring(i, i + 1)) * (i + 2);
        }
        return (calc % 11 == digito || calc % 11 == 0);
    }
}
