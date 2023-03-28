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
public class Pessoa {

    private int idPessoa;
    private String carro;
    private String marca;
    private String modelo;
    private int ano;
    private String proprietario;

    public Pessoa() {
    }

    public Pessoa(int idPessoa, String carro, String marca, String modelo, int ano, String proprietario) {
        this.idPessoa = idPessoa;
        this.carro = carro;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.proprietario = proprietario;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public String toString() {
        return "Pessoa" + "idPessoa=" + idPessoa + ", carro=" + carro + ", marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", proprietario=" + proprietario ;
    }

}
