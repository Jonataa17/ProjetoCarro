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
public class MCarro {

    private int idCarro;
    private String carro;
    private String marca;
    private String modelo;
    private int ano;
    private String proprietario;
    private String renavam;

    public MCarro() {
    }

    public MCarro(int idCarro, String carro, String marca, String modelo, int ano, String proprietario, String renavam) {
        this.idCarro = idCarro;
        this.carro = carro;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.proprietario = proprietario;
        this.renavam = renavam;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
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

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    @Override
    public String toString() {
        return "MCarro{" + "idCarro=" + idCarro + " carro=" + carro + " marca=" + marca + " modelo=" + modelo + " ano=" + ano + " proprietario=" + proprietario + " renavam=" + renavam + '}';
    }

    

}
