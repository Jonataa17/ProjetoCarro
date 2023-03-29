/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.MPessoa;

/**
 *
 * @author 182120038
 */
public class CPessoa {

    ArrayList<MPessoa> pessoas = new ArrayList<>();
    int idPessoa = 1;

    /**
     * geraID gerencia a geração de id's autoincrement para pessoas.
     *
     * @return
     */
    public int geraID() {
        return this.idPessoa++;
    }

    /**
     * addPessoa adiciona um pessoa na lista de pessoas.
     *
     * @param p
     */
    public void addPessoa(MPessoa p) {
        this.pessoas.add(p);
    }

    /**
     * getPessoas retorna a lista de pessoas.
     *
     * @return
     */
    public ArrayList<MPessoa> getPessoas() {
        return this.pessoas;
    }

    /**
     * removePessoa remove Pessoa da lista de pessoas.
     *
     * @param c
     */
    public void removePessoa(MPessoa c) {
        this.pessoas.remove(c);
    }

    /**
     * mockClientes inicializa aplicação com clientes.
     */
    public void mockPessoas() {
        MPessoa p1 = new MPessoa();
        p1.setCpf("43009514034");
        p1.setNome("Elvis Presley");
        p1.setIdade(35);
        p1.setEndereco("Estrada da fama, Hollywood");
        this.addPessoa(p1);
    }

    public MPessoa getPessoaCPF(String cpf) {
        MPessoa p = null;
        for (MPessoa pessoa : pessoas) {
            if (pessoa.getCpf().equals(cpf)) {
                p = pessoa;
                break;
            }
        }

        return p;
    }
}
