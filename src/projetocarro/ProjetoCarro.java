/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetocarro;

import controller.CCarro;
import controller.CPessoa;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.MCarro;
import model.MPessoa;
import util.Validador;

/**
 *
 * @author 182120038
 */
public class ProjetoCarro {

    public static CCarro cadCarro = new CCarro();
    public static CPessoa cadPessoa = new CPessoa();
    public static Scanner leia = new Scanner(System.in);

    public static int leiaNumInt() {
        Scanner leiaNum = new Scanner(System.in);
        int num = 99;
        try {
            num = leiaNum.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Tente Novamente!\n" + e.getMessage());
            leiaNum.nextLine();
        }
        return num;
    }//fim leiaNumInt

    public static void menuP() {
        System.out.println("..: Consórcio :..");
        System.out.println("1 - Gerenciar Pessoa");
        System.out.println("2 - Gerenciar Carros");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }//fim menuP

    public static void subMenu(int op) {
        String tpCad = null;
        switch (op) {
            case 1:
                tpCad = "Pessoa";
                break;
            case 2:
                tpCad = "Carro";
                break;
        }
        System.out.println(".: Gerenciar " + tpCad);
        System.out.println("1 - Cadastrar " + tpCad);
        System.out.println("2 - Editar " + tpCad);
        System.out.println("3 - Listar " + tpCad + "s");
        System.out.println("4 - Deletar " + tpCad);
        System.out.println("0 - Voltar ");
        System.out.print("Escolha uma opção: ");
    }//fim subMenu

    public static void cadastrarPessoa() {
        int idPessoa;
        String cpf;
        String nome;
        int idade;
        String endereco;

        System.out.println("-- Cadastro Pessoa --");
        System.out.print("Informe o CPF: ");
        boolean cpfis;
        int opCPF;
        do {
            cpf = leia.nextLine();
            cpfis = Validador.isCPF(cpf);
            if (!cpfis) {
                System.out.print("CPF Invalido!"
                        + "\nDeseja tentar novamente? 1 - Sim || 2 - Não: ");
                opCPF = leiaNumInt();
                if (opCPF == 1) {
                    System.out.print("Informe o CPF: ");
                } else if (opCPF == 2) {
                    System.out.println("Cadastro encerrado pelo usuario!");
                    return;
                }
            }

        } while (!cpfis);

        if (cadPessoa.getPessoaCPF(cpf) != null) {
            System.out.println("Pessoa já cadastrada!");
        } else {
            System.out.print("Informe o seu nome: ");
            nome = leia.nextLine().toUpperCase();
            System.out.print("Informe o sua idade: ");
            idade = leia.nextInt();
            System.out.print("Status do cadastro: ");
            endereco = leia.nextLine();
            idPessoa = cadPessoa.geraID();

            MPessoa pes = new MPessoa(idade, cpf, nome, idade, endereco);
            cadPessoa.addPessoa(pes);
            System.out.println("Pessoa cadastrada com sucesso!");
        }
    }//fim cadastrarPessoa

    public static void deletarPessoa() {
        System.out.println("-- Deletar Pessoa --");
        System.out.print("Informe o CPF: ");
        String cpf = leia.next();

        if (Validador.isCPF(cpf)) {
            MPessoa pes = cadPessoa.getPessoaCPF(cpf);
            if (pes != null) {
                cadPessoa.removePessoa(pes);
                System.out.println("Pessoa deletada com sucesso!");
            } else {
                System.out.println("Essa pessoa não consta na base de dados!");
            }
        } else {
            System.out.println("CPF inválido!");
        }
    }//fim deletarPessoa

    public static void listarPessoa() {

        for (MPessoa pes : cadPessoa.getPessoas()) {
            System.out.println("---->");
            System.out.println("CPF:\t" + pes.getCpf());
            System.out.println("Nome:\t" + pes.getNome());
            System.out.println("Idade:\t" + pes.getIdade());
        }
    }//fim listarPessoa

    public static void editarPessoa() {

        System.out.println("-- Editar Pessoa --");
        System.out.print("Informe o CPF: ");
        String cpf = leia.nextLine();
        if (Validador.isCPF(cpf)) {
            MPessoa pes = cadPessoa.getPessoaCPF(cpf);
            if (pes != null) {
                System.out.println("1 - Nome:\t" + pes.getNome());
                System.out.println("2 - Idade:\t" + pes.getIdade());
                System.out.println("3 - Endereço:\t" + pes.getEndereco());
                System.out.println("4 - Todas as opções acima");
                System.out.print("Qual das opções deseja alterar? 1 || 2 || 3 || 4\n Digite aqui: ");
                int opEditar = leiaNumInt();
                switch (opEditar) {
                    case 1:
                        System.out.print("Informe o nome: ");
                        pes.setNome(leia.nextLine());
                        break;
                    case 2:
                        System.out.print("Informe a idade: ");
                        pes.setIdade(leia.nextInt());
                        break;
                    case 3:
                        System.out.print("Informe o endereço: ");
                        pes.setEndereco(leia.nextLine());
                        break;
                    case 4:
                        System.out.print("Informe o nome: ");
                        pes.setNome(leia.nextLine());
                        System.out.print("Informe a idade: ");
                        pes.setIdade(leia.nextInt());
                        System.out.print("Informe o endereço: ");
                        pes.setEndereco(leia.nextLine());
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
                System.out.println("Pessoa editada com sucesso!");
            } else {
                System.out.println("Pessoa não cadastrada!");
            }
        } else {
            System.out.println("CPF inválido!");
        }
    }//fim editarPessoa

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        cadPessoa.mockPessoas();
        cadCarro.mockCarros();

        int opM;

        do {
            menuP();
            opM = leiaNumInt();
            switch (opM) {
                case 1:
                case 2:
                    int opSM;
                    do {
                        subMenu(opM);
                        opSM = leiaNumInt();
                        switch (opSM) {
                            case 1:
                                System.out.println("--Cadastrar--");
                                if (opM == 1) {
                                    cadastrarPessoa();
                                } else if (opM == 2) {
                                    cadastrarCarro();
                                }
                                break;
                            case 2:
                                System.out.println("--Editar--");
                                if (opM == 1) {
                                    editarPessoa();
                                } else if (opM == 2) {
                                    editarCarro();
                                }
                                break;
                            case 3:
                                System.out.println("--Listar--");
                                if (opM == 1) {
                                    listarPessoa();
                                } else if (opM == 2) {
                                    listarCarro();
                                }
                                break;
                            case 4:
                                System.out.println("--Deletar--");
                                if (opM == 1) {
                                    deletarPessoa();
                                } else if (opM == 2) {
                                    deletarCarro();
                                }
                                break;
                            case 0:
                                System.out.println("--Menu Principal--");
                                break;
                            default:
                                System.out.println("--Opção Invalida, Tente Novamente!--");
                                break;
                        }
                    } while (opSM != 0);
                    break;
                case 0:
                    System.out.println("--Fim do programa--");
                    break;
                default:
                    System.out.println("--Opção Invalida, Tente Novamente!--");
                    break;
            }
        } while (opM != 0);
    }

    private static void cadastrarCarro() {

        System.out.println("-- Cadastrar Carro --");

        boolean isRenavam;
        MCarro carro;
        String renavam;
        do {
            System.out.print("Informe o Renavam do carro: ");
            renavam = leia.nextLine();
            isRenavam = CCarro.ValidaRENAVAM(renavam);
            if (isRenavam) {
                carro = cadCarro.getCarroRenavam(renavam);
                if (carro != null) {
                    System.out.println("Carro já cadastrado: " + carro.getCarro());
                }
            } else {
                System.out.println("Renavam inválido!");
            }
        } while (!isRenavam);

        int idCarro = cadCarro.geraID();
        System.out.print("Informe o nome do carro: ");
        String nome = leia.nextLine();

        System.out.print("Informe a marca do carro: ");
        String marca = leia.nextLine();

        System.out.print("Informe o modelo do carro: ");
        String modelo = leia.nextLine();

        System.out.print("Informe o ano do carro: ");
        int ano = leiaNumInt();

        System.out.println("Informe o Renavam: ");
        renavam = leia.nextLine();

        System.out.println("Informe o proprietario do carro: ");
        String proprietario = leia.nextLine();

        MCarro c = new MCarro(idCarro, nome, marca, modelo, ano, proprietario, renavam);
        cadCarro.addCarro(c);
        System.out.println("Carro cadastrado!");

    }//fim cadastarCarro

    private static void editarCarro() {

    }//fim editarCarro

    private static void listarCarro() {

        for (MCarro c : cadCarro.getCarros()) {
            System.out.println("---->");
            System.out.println("Carro:\t" + c.getCarro());
            System.out.println("Modelo:\t" + c.getModelo());
            System.out.println("Ano:\t" + c.getAno());
        }
    }//fim listarCarro

    private static void deletarCarro() {
        System.out.println("-- Deletar Carro --");
        System.out.print("Informe o Renavam: ");
        String renavam = leia.next();

        if (CCarro.ValidaRENAVAM(renavam)) {
            MCarro c = cadCarro.getCarroRenavam(renavam);
            if (c != null) {
                cadCarro.removeCarro(c);
                System.out.println("Carro deletado com sucesso!");
            } else {
                System.out.println("Esse carro não consta na base de dados!");
            }
        } else {
            System.out.println("Renavam inválido!");
        }
    }//fim deletarCarro 

}
