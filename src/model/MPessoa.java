/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author 182120038
 */
public class MPessoa {

    private int idCarro;
    private String cpf;
    private String nome;
    private int idade;
    private String endereco;

    public MPessoa() {
    }

    public MPessoa(int idCarro, String cpf, String nome, int idade, String endereco) {
        this.idCarro = idCarro;
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.endereco = endereco;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Carro" + "idCarro=" + idCarro + ", cpf=" + cpf + ", nome=" + nome + ", idade=" + idade + ", endereco=" + endereco;
    }

}
